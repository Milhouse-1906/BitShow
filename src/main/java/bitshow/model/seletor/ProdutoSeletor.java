package bitshow.model.seletor;

public class ProdutoSeletor {

	private String nome;
	private String categoria;
	private Double valorMinimo;
	private Double valorMaximo;

	public ProdutoSeletor(String nome, String categoria, Double valorMinimo, Double valorMaximo) {
		super();
		this.nome = nome;
		this.categoria = categoria;
		this.valorMinimo = valorMinimo;
		this.valorMaximo = valorMaximo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Double getValorMinimo() {
		return valorMinimo;
	}

	public void setValorMinimo(Double valorMinimo) {
		this.valorMinimo = valorMinimo;
	}

	public Double getValorMaximo() {
		return valorMaximo;
	}

	public void setValorMaximo(Double valorMaximo) {
		this.valorMaximo = valorMaximo;
	}

}
