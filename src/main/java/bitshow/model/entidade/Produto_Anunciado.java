package bitshow.model.entidade;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;

@Entity
@Table(name = "PRODUTO_ANUNCIADO")
public class Produto_Anunciado {

	public Produto_Anunciado(Long id, String nome, String descricao, BigDecimal preco, Date dataAnuncio,
			Date encerramentoAnuncio, Date dataVenda, Usuario usuario, Categoria categoria) {
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
	private BigDecimal preco;
	private String nome;
	private String descricao;

	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date dataAnuncio;

	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date encerramentoAnuncio;

	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date dataVenda;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "id_categoria")
	private Categoria categoria;

	public Produto_Anunciado() {
	}

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

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
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
