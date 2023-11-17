package BitShow_Model_Entidade;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
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
    @JoinColumn(name = "idproduto")
    private Produto_Anunciado produtoAnunciado;

    @ManyToOne
    @JoinColumn(name = "usuario")
    private Usuario usuario;

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

    
}
