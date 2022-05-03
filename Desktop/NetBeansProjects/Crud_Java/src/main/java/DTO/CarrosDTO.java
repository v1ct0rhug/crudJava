
package DTO;


public class CarrosDTO {
    private String nome, ano_fabricacao, marca;
    private int id;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAno_fabricacao() {
        return ano_fabricacao;
    }

    public void setAno_fabricacao(String ano_fabricacao) {
        this.ano_fabricacao = ano_fabricacao;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
   
    
}
