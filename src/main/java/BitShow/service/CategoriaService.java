package BitShow.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import BitShow.excepition.CategoriaNotFoundException;
import BitShow.model.DTO.CategoriaDTO;
import BitShow.model.ntidade.Categoria;
import BitShow.model.repository.CategoriaRepository;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria criarCategoria(Categoria categoria) {
        if (categoria.getNome() == null || categoria.getNome().isEmpty()) {
            throw new IllegalArgumentException("Nome da categoria não pode ser nulo ou vazio");
        }
        return categoriaRepository.save(categoria);
    }
    public Categoria getCategoriaById(Long id) {
        return categoriaRepository.findById(id).orElse(null);
    
    }
	
    public Categoria atualizarCategoria(Long id, CategoriaDTO categoriaDTO) throws CategoriaNotFoundException {
		Optional<Categoria> categoriaOptional = categoriaRepository.findById(id);

        if (categoriaOptional.isPresent()) {
            Categoria categoriaExistente = categoriaOptional.get();
            categoriaExistente.setNome(categoriaDTO.getNome());

            // Salve as alterações no banco de dados
            return categoriaRepository.save(categoriaExistente);
        } else {
            throw new CategoriaNotFoundException("Categoria não encontrada com o ID: " + id);
        }
	}
	public void excluirCategoria(Long id) throws CategoriaNotFoundException {
	
		Optional<Categoria> categoriaOptional = categoriaRepository.findById(id);

        if (categoriaOptional.isPresent()) {
            Categoria categoria = categoriaOptional.get();
            categoriaRepository.delete(categoria);
        } else {
            throw new CategoriaNotFoundException("Categoria não encontrada com o ID: " + id);
        }
	}

    
}
