package municipales.modelo;

public class Categoria {

	private int id;
	private String nomCategoria;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomCategoria() {
		return nomCategoria;
	}

	public void setNomCategoria(String nomCategoria) {
		this.nomCategoria = nomCategoria;
	}

	public Categoria(int id, String nomCategoria) {
		this.id = id;
		this.nomCategoria = nomCategoria;
	}


	public Categoria(String nomCategoria) {
		this.nomCategoria = nomCategoria;
	}


}
