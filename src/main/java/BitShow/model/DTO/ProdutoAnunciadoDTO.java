package BitShow.model.DTO;

import java.sql.Date;

public class ProdutoAnunciadoDTO {
    private Long id;
    private String nome;
    private String descricao;
    private String preco;
    private Date dataAnuncio;
    private Date encerramentoAnuncio;
    private Date dataVenda;
    private UsuarioDTO usuario;
    private CategoriaDTO categoria;

    // getters e setters
}