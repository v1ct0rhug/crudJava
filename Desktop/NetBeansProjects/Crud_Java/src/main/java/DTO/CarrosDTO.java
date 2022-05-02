
package DTO;


public class CarrosDTO {
    private String nome, ano_fabricacao, marca;
    private int id;
    

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the ano_fabricacao
     */
    public String getAno_fabricacao() {
        return ano_fabricacao;
    }

    /**
     * @param ano_fabricacao the ano_fabricacao to set
     */
    public void setAno_fabricacao(String ano_fabricacao) {
        this.ano_fabricacao = ano_fabricacao;
    }

    /**
     * @return the marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
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
