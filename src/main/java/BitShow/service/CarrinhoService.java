package BitShow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import BitShow.model.ntidade.Carrinho;
import BitShow.model.repository.CarrinhoRepository;

@Service
public class CarrinhoService {

    @Autowired
    private CarrinhoRepository carrinhoRepository;

    @Autowired
    private ProdutoAnunciadoService produtoAnunciadoService;

    public Carrinho adicionarAoCarrinho(Carrinho carrinho) {
        if (produtoAnunciadoService.getProdutoAnunciadoById(carrinho.getProdutoAnunciado().getId()) == null) {
            throw new IllegalArgumentException("O produto associado não existe");
        }
        return carrinhoRepository.save(carrinho);
    }

    public Carrinho getCarrinhoById(Long id) {
        return carrinhoRepository.findById(id).orElse(null);
        
    }
    	
 }
