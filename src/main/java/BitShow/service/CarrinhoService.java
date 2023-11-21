package BitShow.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import BitShow.excepition.CarrinhoNotFoundException;
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

	public void removerDoCarrinho(Long id) throws CarrinhoNotFoundException {
		Optional<Carrinho> carrinhoOptional = carrinhoRepository.findById(id);

        if (carrinhoOptional.isPresent()) {
            Carrinho carrinho = carrinhoOptional.get();
            carrinhoRepository.delete(carrinho);
        } 
        else {
            throw new CarrinhoNotFoundException("Carrinho não encontrado com o ID: " + id);}
 }
		

	public Carrinho atualizarCarrinho(Long id, Carrinho carrinhoDTO) throws CarrinhoNotFoundException {
	       Optional<Carrinho> carrinhoOptional = carrinhoRepository.findById(id);

	       if (carrinhoOptional.isPresent()) {
	            Carrinho carrinhoExistente = carrinhoOptional.get();
	            return carrinhoRepository.save(carrinhoExistente);
	     }
        else {
          throw new CarrinhoNotFoundException("Carrinho não encontrado com o ID: " + id);
	        }
	}
    	
 }
