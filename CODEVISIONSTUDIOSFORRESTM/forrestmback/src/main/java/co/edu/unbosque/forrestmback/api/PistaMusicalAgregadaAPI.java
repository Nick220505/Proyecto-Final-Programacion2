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

import co.edu.unbosque.forrestmback.dao.PistaMusicalAgregadaDAO;
import co.edu.unbosque.forrestmback.model.PistaMusicalAgregada;

@RestController
@RequestMapping("/pistas-agregadas")
public class PistaMusicalAgregadaAPI {

	private final PistaMusicalAgregadaDAO pistaMusicalAgregadaDAO;

	public PistaMusicalAgregadaAPI(PistaMusicalAgregadaDAO pistaMusicalAgregadaDAO) {
		this.pistaMusicalAgregadaDAO = pistaMusicalAgregadaDAO;
	}

	@PostMapping("/guardar")
	public void guardar(@RequestBody PistaMusicalAgregada pistaMusicalAgregada) {
		pistaMusicalAgregadaDAO.save(pistaMusicalAgregada);
	}

	@GetMapping("/listar")
	public List<PistaMusicalAgregada> listar() {
		return pistaMusicalAgregadaDAO.findAll();
	}

	@PutMapping("/actualizar")
	public void actualizar(@RequestBody PistaMusicalAgregada pistaMusicalAgregada) {
		pistaMusicalAgregadaDAO.save(pistaMusicalAgregada);
	}

	@DeleteMapping("/eliminar/{id}")
	public void eliminar(@PathVariable Integer id) {
		pistaMusicalAgregadaDAO.deleteById(id);
	}

}