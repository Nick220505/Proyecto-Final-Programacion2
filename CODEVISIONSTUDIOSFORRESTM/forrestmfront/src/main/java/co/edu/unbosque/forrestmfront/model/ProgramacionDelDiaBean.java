package co.edu.unbosque.forrestmfront.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.json.JSONArray;
import org.json.JSONObject;
import org.primefaces.event.DragDropEvent;

@ManagedBean(name = "programacionBean")
@SessionScoped
public class ProgramacionDelDiaBean extends BeanBase {

	private List<Map<String, Object>> pistasMusicalesDisponibles;

	private List<Map<String, Object>> pistasMusicalesAgregadas;

	public void onLoad() {
		try {
			obtenerPistasMusicalesDisponibles();
			obtenerPistasMusicalesAgregadas();
		} catch (Exception e) {
			super.redirigirAPaginaError(e.getMessage());
		}
	}

	public void onDrop(DragDropEvent<Map<String, Object>> ddEvent) {
		Map<String, Object> pistaMusicalAgregada = ddEvent.getData();
		try {
			pistaMusicalAgregada.put("agregada", true);
			super.putJSON(pistaMusicalAgregada, "pistas/actualizar");
			obtenerPistasMusicalesDisponibles();
			obtenerPistasMusicalesAgregadas();
		} catch (Exception e) {
			super.redirigirAPaginaError(e.getMessage());
		}
	}

	private void obtenerPistasMusicalesDisponibles() throws Exception {
		pistasMusicalesDisponibles = new ArrayList<>();
		JSONArray arrayPistasMusicales = super.getJSON("pistas/listar-disponibles");
		for (int i = 0; i < arrayPistasMusicales.length(); i++) {
			JSONObject pistaMusicalJson = arrayPistasMusicales.getJSONObject(i);
			Map<String, Object> pistaMusical = new HashMap<>();
			for (String key : pistaMusicalJson.keySet()) {
				pistaMusical.put(key, pistaMusicalJson.get(key));
			}
			pistasMusicalesDisponibles.add(pistaMusical);
		}
	}

	private void obtenerPistasMusicalesAgregadas() throws Exception {
		pistasMusicalesAgregadas = new ArrayList<>();
		JSONArray arrayPistasMusicalesAgregadas = super.getJSON("pistas/listar-agregadas");
		for (int i = 0; i < arrayPistasMusicalesAgregadas.length(); i++) {
			JSONObject pistaMusicalAgregadaJson = arrayPistasMusicalesAgregadas.getJSONObject(i);
			Map<String, Object> pistaMusicalAgregada = new HashMap<>();
			for (String key : pistaMusicalAgregadaJson.keySet()) {
				pistaMusicalAgregada.put(key, pistaMusicalAgregadaJson.get(key));
			}
			pistasMusicalesAgregadas.add(pistaMusicalAgregada);
		}
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
