package bitshow.service;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import bitshow.exception.ProdutoAnunciadoNotFoundException;
import bitshow.model.entidade.Produto_Anunciado;
import bitshow.model.repository.ProdutoAnunciadoRepository;
import bitshow.model.specification.ProdutoAnunciadoSpecifications;

@Service
public class ProdutoAnunciadoService {

    @Autowired
    private ProdutoAnunciadoRepository produtoAnunciadoRepository;

    public Produto_Anunciado criarProdutoAnunciado(Produto_Anunciado produtoAnunciado) {
        if (produtoAnunciado.getNome() == null || produtoAnunciado.getNome().isEmpty()) {
            throw new IllegalArgumentException("O nome do produto não pode ser nulo ou vazio");
        }

        if (produtoAnunciado.getDescricao() == null || produtoAnunciado.getDescricao().isEmpty()) {
            throw new IllegalArgumentException("A descrição do produto não pode ser nula ou vazia");
        }

        if (produtoAnunciado.getPreco() == null) {
            throw new IllegalArgumentException("O preço do produto não pode ser nulo");
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(produtoAnunciado.getDataAnuncio());
        calendar.add(Calendar.DAY_OF_MONTH, 15);
        produtoAnunciado.setEncerramentoAnuncio(calendar.getTime());

        return produtoAnunciadoRepository.save(produtoAnunciado);
    }

    public Produto_Anunciado getProdutoAnunciadoById(Long id) {
        return produtoAnunciadoRepository.findById(id).orElse(null);
    }
    public List<Produto_Anunciado> buscarPorCategoria(Long idCategoria) {
        Specification<Produto_Anunciado> spec = ProdutoAnunciadoSpecifications.porCategoria(idCategoria);
        return produtoAnunciadoRepository.findAll(spec);
    }

    public List<Produto_Anunciado> buscarPorUsuario(Long idUsuario) {
        Specification<Produto_Anunciado> spec = ProdutoAnunciadoSpecifications.porUsuario(idUsuario);
        return produtoAnunciadoRepository.findAll(spec);
    }
    public List<Produto_Anunciado> buscarProdutosValidos() {
        Specification<Produto_Anunciado> spec = Specification.where(
                ProdutoAnunciadoSpecifications.produtoNaoNulo()
                        .and(ProdutoAnunciadoSpecifications.descricaoNaoVazia())
                        .and(ProdutoAnunciadoSpecifications.dataAnuncioValida())
        );

        return produtoAnunciadoRepository.findAll(spec);
    }

	public List<Produto_Anunciado> listarProdutos() {
		return produtoAnunciadoRepository.findAll();
	}

	public Produto_Anunciado obterProdutoPorId(Long id) {
		Optional<Produto_Anunciado> produtoOptional = produtoAnunciadoRepository.findById(id);
	      return produtoOptional.orElseThrow();
	    }

	public void excluirProduto(Long id) throws ProdutoAnunciadoNotFoundException {
		Optional<Produto_Anunciado> produtoOptional = produtoAnunciadoRepository.findById(id);

        if (produtoOptional.isPresent()) {
            Produto_Anunciado produtoAnunciado = produtoOptional.get();
            produtoAnunciadoRepository.delete(produtoAnunciado);
        } else {
            throw new ProdutoAnunciadoNotFoundException("Produto não encontrado com o ID: " + id);
        }
    }
		


	public Produto_Anunciado atualizarProduto(Long id, Produto_Anunciado produto) throws ProdutoAnunciadoNotFoundException {
		Optional<Produto_Anunciado> produtoOptional = produtoAnunciadoRepository.findById(id);

        if (produtoOptional.isPresent()) {
            Produto_Anunciado produtoExistente = produtoOptional.get();
            produtoExistente.setNome(produto.getNome());
            produtoExistente.setDescricao(produto.getDescricao());
            produtoExistente.setPreco(produto.getPreco());
           return produtoAnunciadoRepository.save(produtoExistente);
        
        } else {
            throw new ProdutoAnunciadoNotFoundException("Produto não encontrado com o ID: " + id);
        }
    }
}
