package co.edu.unbosque.forrestmfront.model;

import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.event.DragDropEvent;

@ManagedBean(name = "programacionBean")
@SessionScoped
public class ProgramacionDelDiaBean extends BeanBase {

	private List<Map<String, Object>> pistasMusicalesDisponibles;
	private List<Map<String, Object>> pistasMusicalesAgregadas;

	public void onLoad() {
		try {
			obtenerPistasMusicales();
		} catch (Exception e) {
			super.redirigirAPaginaError(e.getMessage());
		}
	}

	public void onDrop(DragDropEvent<Map<String, Object>> ddEvent) {
		Map<String, Object> pistaMusicalAgregada = ddEvent.getData();
		try {
			pistaMusicalAgregada.put("agregada", true);
			super.putJSON(pistaMusicalAgregada, "pistas/actualizar");
			obtenerPistasMusicales();
		} catch (Exception e) {
			super.redirigirAPaginaError(e.getMessage());
		}
	}

	private void obtenerPistasMusicales() throws Exception {
		pistasMusicalesDisponibles = super.getJSONList("pistas/listar-disponibles");
		pistasMusicalesAgregadas = super.getJSONList("pistas/listar-agregadas");
	}

	public List<Map<String, Object>> getPistasMusicalesDisponibles() {
		return pistasMusicalesDisponibles;
	}

	public void setPistasMusicalesDisponibles(List<Map<String, Object>> pistasMusicalesDisponibles) {
		this.pistasMusicalesDisponibles = pistasMusicalesDisponibles;
	}

	public List<Map<String, Object>> getPistasMusicalesAgregadas() {
		return pistasMusicalesAgregadas;
	}

	public void setPistasMusicalesAgregadas(List<Map<String, Object>> pistasMusicalesAgregadas) {
		this.pistasMusicalesAgregadas = pistasMusicalesAgregadas;
	}

}
