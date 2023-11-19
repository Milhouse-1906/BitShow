package BitShow.service;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import BitShow.model.ntidade.Produto_Anunciado;
import BitShow.model.repository.ProdutoAnunciadoRepository;

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

    public List<Produto_Anunciado> getProdutosAnunciadosPorCategoria(Long idCategoria) {
        return produtoAnunciadoRepository.findAllByCategoriaId(idCategoria);
    }
}
