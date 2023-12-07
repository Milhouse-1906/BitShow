package bitshow.model.entidade;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "carrinho")
public class Carrinho {

	public Carrinho(Long id, Produto_Anunciado produtoAnunciado, Usuario usuario) {
		super();
		this.id = id;
		this.produtoAnunciado = produtoAnunciado;
		this.usuario = usuario;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_produto")
	private Produto_Anunciado produtoAnunciado;

	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;

	public Carrinho() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Produto_Anunciado getProdutoAnunciado() {
		return produtoAnunciado;
	}

	public void setProdutoAnunciado(Produto_Anunciado produtoAnunciado) {
		this.produtoAnunciado = produtoAnunciado;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public static Carrinho getCarrinhoById(Long id2) {
		return null;
	}

	public static Carrinho adicionarAoCarrinho(Carrinho carrinho2) {
		return null;
	}

}
