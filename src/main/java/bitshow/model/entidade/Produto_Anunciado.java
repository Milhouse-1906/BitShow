package bitshow.model.entidade;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "PRODUTO_ANUNCIADO")
public class Produto_Anunciado {

    public Produto_Anunciado(Long id, String nome, String descricao, String preco, Date dataAnuncio,
			Date encerramentoAnuncio, Date dataVenda, Usuario usuario, Categoria categoria) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.dataAnuncio = dataAnuncio;
		this.encerramentoAnuncio = encerramentoAnuncio;
		this.dataVenda = dataVenda;
		this.usuario = usuario;
		this.categoria = categoria;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;
    private String preco;

    @Temporal(TemporalType.DATE)
    private Date dataAnuncio;

    @Temporal(TemporalType.DATE)
    private Date encerramentoAnuncio;

    @Temporal(TemporalType.DATE)
    private Date dataVenda;

    @ManyToOne
    @JoinColumn(name = "idusuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "categoria")
    private Categoria categoria;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getPreco() {
		return preco;
	}

	public void setPreco(String preco) {
		this.preco = preco;
	}

	public Date getDataAnuncio() {
		return dataAnuncio;
	}

	public void setDataAnuncio(Date dataAnuncio) {
		this.dataAnuncio = dataAnuncio;
	}

	public Date getEncerramentoAnuncio() {
		return encerramentoAnuncio;
	}

	public void setEncerramentoAnuncio(Date encerramentoAnuncio) {
		this.encerramentoAnuncio = encerramentoAnuncio;
	}

	public Date getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

    
}
