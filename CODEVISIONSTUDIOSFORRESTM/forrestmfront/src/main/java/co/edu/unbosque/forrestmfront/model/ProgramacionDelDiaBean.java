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

	private List<Map<String, Object>> pistasMusicales;

	private List<Map<String, Object>> pistasMusicalesAgregadas;

	public void onLoad() {
		try {
			obtenerPistasMusicales();
			obtenerPistasMusicalesAgregadas();
		} catch (Exception e) {
			super.redirigirAPaginaError(e.getMessage());
		}
	}

	public void onDrop(DragDropEvent<Map<String, Object>> ddEvent) {
		Map<String, Object> pistaMusicalAgregada = ddEvent.getData();
		try {
			super.deleteJSON("pistas/eliminar/" + pistaMusicalAgregada.get("id"));
			pistaMusicalAgregada.remove("id");
			super.postJSON(pistaMusicalAgregada, "pistas-agregadas/guardar");
			obtenerPistasMusicales();
			obtenerPistasMusicalesAgregadas();
		} catch (Exception e) {
			super.redirigirAPaginaError(e.getMessage());
		}
	}

	private void obtenerPistasMusicales() throws Exception {
		pistasMusicales = new ArrayList<>();
		JSONArray arrayPistasMusicales = super.getJSON("pistas/listar");
		for (int i = 0; i < arrayPistasMusicales.length(); i++) {
			JSONObject pistaMusicalJson = arrayPistasMusicales.getJSONObject(i);
			Map<String, Object> pistaMusical = new HashMap<>();
			pistaMusical.put("id", pistaMusicalJson.getInt("id"));
			pistaMusical.put("nombre", pistaMusicalJson.getString("nombre"));
			pistaMusical.put("nombreDelArtista", pistaMusicalJson.getString("nombreDelArtista"));
			pistaMusical.put("generoMusical", pistaMusicalJson.getString("generoMusical"));
			pistaMusical.put("url", pistaMusicalJson.getString("url"));
			pistasMusicales.add(pistaMusical);
		}
	}

	private void obtenerPistasMusicalesAgregadas() throws Exception {
		pistasMusicalesAgregadas = new ArrayList<>();
		JSONArray arrayPistasMusicalesAgregadas = super.getJSON("pistas-agregadas/listar");
		for (int i = 0; i < arrayPistasMusicalesAgregadas.length(); i++) {
			JSONObject pistaMusicalAgregadaJson = arrayPistasMusicalesAgregadas.getJSONObject(i);
			Map<String, Object> pistaMusicalAgregada = new HashMap<>();
			pistaMusicalAgregada.put("id", pistaMusicalAgregadaJson.getInt("id"));
			pistaMusicalAgregada.put("nombre", pistaMusicalAgregadaJson.getString("nombre"));
			pistaMusicalAgregada.put("nombreDelArtista", pistaMusicalAgregadaJson.getString("nombreDelArtista"));
			pistaMusicalAgregada.put("generoMusical", pistaMusicalAgregadaJson.getString("generoMusical"));
			pistaMusicalAgregada.put("url", pistaMusicalAgregadaJson.getString("url"));
			pistasMusicalesAgregadas.add(pistaMusicalAgregada);
		}
	}

	public List<Map<String, Object>> getPistasMusicales() {
		return pistasMusicales;
	}

	public void setPistasMusicales(List<Map<String, Object>> pistasMusicales) {
		this.pistasMusicales = pistasMusicales;
	}

	public List<Map<String, Object>> getPistasMusicalesAgregadas() {
		return pistasMusicalesAgregadas;
	}

	public void setPistasMusicalesAgregadas(List<Map<String, Object>> pistasMusicalesAgregadas) {
		this.pistasMusicalesAgregadas = pistasMusicalesAgregadas;
	}

}
