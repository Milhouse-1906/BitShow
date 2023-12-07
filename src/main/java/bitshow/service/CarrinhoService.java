package bitshow.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bitshow.exception.CarrinhoNotFoundException;
import bitshow.model.entidade.Carrinho;
import bitshow.model.entidade.Usuario;
import bitshow.model.repository.CarrinhoRepository;


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
		

	public Carrinho atualizarCarrinho(Long id, Carrinho carrinho) throws CarrinhoNotFoundException {
	       Optional<Carrinho> carrinhoOptional = carrinhoRepository.findById(id);

	       if (carrinhoOptional.isPresent()) {
	            Carrinho carrinhoExistente = carrinhoOptional.get();
	            return carrinhoRepository.save(carrinhoExistente);
	     }
        else {
          throw new CarrinhoNotFoundException("Carrinho não encontrado com o ID: " + id);
	        }
	}

	public List<Carrinho> getCarrinhoByUserId(Long id) throws CarrinhoNotFoundException {
        List<Carrinho> carrinho = carrinhoRepository.findByUserId(id);

        if (carrinho == null) {
            throw new CarrinhoNotFoundException("Carrinho não existe: " + id );
        }

        return carrinho;
    }
    	
 }
