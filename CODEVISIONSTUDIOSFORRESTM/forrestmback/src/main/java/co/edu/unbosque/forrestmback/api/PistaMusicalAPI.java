package co.edu.unbosque.forrestmback.api;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.forrestmback.dao.PistaMusicalDAO;
import co.edu.unbosque.forrestmback.model.PistaMusical;

@RestController
@RequestMapping("/pistas")
public class PistaMusicalAPI {

	private final PistaMusicalDAO pistaMusicalDAO;

	public PistaMusicalAPI(PistaMusicalDAO pistaMusicalDAO) {
		this.pistaMusicalDAO = pistaMusicalDAO;
	}

	@PostMapping("/guardar")
	public void guardar(@RequestBody PistaMusical pistaMusical) {
		pistaMusicalDAO.save(pistaMusical);
	}

	@GetMapping("/listar")
	public List<PistaMusical> listar() {
		return pistaMusicalDAO.findAll();
	}

	@PutMapping("/actualizar")
	public void actualizar(@RequestBody PistaMusical pistaMusical) {
		pistaMusicalDAO.save(pistaMusical);
	}

	@DeleteMapping("/eliminar/{id}")
	public void eliminar(@PathVariable Integer id) {
		pistaMusicalDAO.deleteById(id);
	}

}