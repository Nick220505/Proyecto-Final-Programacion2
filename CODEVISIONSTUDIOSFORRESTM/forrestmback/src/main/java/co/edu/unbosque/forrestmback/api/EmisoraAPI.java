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

import co.edu.unbosque.forrestmback.dao.EmisoraDAO;
import co.edu.unbosque.forrestmback.model.Emisora;

@RestController
@RequestMapping("/emisoras")
public class EmisoraAPI {

	private final EmisoraDAO emisoraDAO;

	public EmisoraAPI(EmisoraDAO emisoraDAO) {
		this.emisoraDAO = emisoraDAO;
	}

	@PostMapping("/guardar")
	public void guardar(@RequestBody Emisora emisora) {
		emisoraDAO.save(emisora);
	}

	@GetMapping("/listar")
	public List<Emisora> listar() {
		return emisoraDAO.findAll();
	}

	@PutMapping("/actualizar")
	public void actualizar(@RequestBody Emisora emisora) {
		emisoraDAO.save(emisora);
	}

	@DeleteMapping("/eliminar/{id}")
	public void eliminar(@PathVariable Integer id) {
		emisoraDAO.deleteById(id);
	}

}
