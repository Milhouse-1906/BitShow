package bitshow.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bitshow.exception.CategoriaNotFoundException;
import bitshow.model.entidade.Categoria;
import bitshow.model.repository.CategoriaRepository;
import ch.qos.logback.classic.Logger;

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

	private final Logger logger = (Logger) LoggerFactory.getLogger(CategoriaService.class);

	public Categoria atualizarCategoria(Long id, Categoria categoria) throws CategoriaNotFoundException {
		logger.info("Iniciando atualização da categoria com ID: {}", id);

		Optional<Categoria> categoriaOptional = categoriaRepository.findById(id);

		if (categoriaOptional.isPresent()) {
			Categoria categoriaExistente = categoriaOptional.get();
			categoriaExistente.setNome(categoria.getNome());

			Categoria categoriaAtualizada = categoriaRepository.save(categoriaExistente);

			logger.info("Categoria atualizada com sucesso: {}", categoriaAtualizada);

			return categoriaAtualizada;
		} else {
			logger.error("Categoria não encontrada com o ID: {}", id);
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

	public List<Categoria> listarCategorias() {
		return categoriaRepository.findAll();

	}

}
