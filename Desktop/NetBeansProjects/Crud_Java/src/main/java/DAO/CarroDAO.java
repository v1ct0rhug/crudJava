
package DAO;

import DTO.CarrosDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;



public class CarroDAO {
    
    Connection conexao;
    PreparedStatement pstt;
    ResultSet rs;
  public ArrayList<CarrosDTO> lista = new ArrayList<>();
    
    public void cadastrarCarro(CarrosDTO objcarrodto){
        String sql = "insert into carros (nome, ano_fabricacao, marca) values (?,?,?)";
        
    conexao = new ConexaoDAO().conectaBD();
    
    
        try {
            pstt = conexao.prepareStatement(sql);
            pstt.setString(1, objcarrodto.getNome());
            pstt.setString(2, objcarrodto.getAno_fabricacao());
            pstt.setString(3, objcarrodto.getMarca());
            
            pstt.execute();
            pstt.close();
            
            
        } catch (Exception error) {
            JOptionPane.showMessageDialog(null, "CarroDAO cadastrar" + error);
        }
    }
    /*  Usa-se Result set, pois ele pega o banco de dados e consegue percorrer a tabela*/
    public ArrayList<CarrosDTO> PesquisarCarro () {
    	String sql= "SELECT * FROM carros";
    	
    	conexao = new ConexaoDAO().conectaBD();
    	
    	try {
    		pstt = conexao.prepareStatement(sql);
    				
    		rs = pstt.executeQuery();
    		
    		/* Faz uma estrutura de repetição, porque não se sabe quantos cadastros tem no banco. Então a estrutura de repetição lê todos os cadastros. */
			while (rs.next()) {
				CarrosDTO objCarrosDTO = new CarrosDTO();
				objCarrosDTO.setId(rs.getInt("id"));
				objCarrosDTO.setNome(rs.getString("nome"));
				objCarrosDTO.setAno_fabricacao(rs.getString("ano_fabricacao"));
				objCarrosDTO.setMarca(rs.getString("marca"));
				
				
				lista.add(objCarrosDTO);
			}
    		
    		
		} catch (Exception error) {
			JOptionPane.showMessageDialog(null, "CarroDAO Pesquisar" + error);
		}
    	return lista;
    }
     
}
