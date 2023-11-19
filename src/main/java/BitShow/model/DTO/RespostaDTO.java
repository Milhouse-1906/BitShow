package BitShow.model.DTO;

public class RespostaDTO {
    private Long id;
    private String texto;
    private UsuarioDTO usuario;
    private PerguntaDTO pergunta;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public UsuarioDTO getUsuario() {
		return usuario;
	}
	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}
	public PerguntaDTO getPergunta() {
		return pergunta;
	}
	public void setPergunta(PerguntaDTO pergunta) {
		this.pergunta = pergunta;
	}

}
