package co.edu.unbosque.forrestmfront.model;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

@ManagedBean(name = "programacionBean")
@SessionScoped
public class ProgramacionDelDiaBean extends BeanBase {

	private List<Map<String, Object>> pistasMusicalesDisponibles;
	private List<Map<String, Object>> pistasMusicalesAgregadas;

	@SuppressWarnings("unchecked")
	public void onLoad() {
		try {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			ExternalContext externalContext = facesContext.getExternalContext();
			if (externalContext.getSessionMap().get("pistaCreada") != null) {
				Map<String, Object> pistaMusicalCreada = (Map<String, Object>) externalContext.getSessionMap().get("pistaCreada");
				super.addMessage(FacesMessage.SEVERITY_INFO, "Mensaje de Información",
						"La pista musical \"" + pistaMusicalCreada.get("nombre") + "\" de \""
								+ pistaMusicalCreada.get("nombreDelArtista") + "\" ha sido creada correctamente.");
				externalContext.getSessionMap().remove("pistaCreada");
			}
			obtenerPistasMusicales();
		} catch (Exception e) {
			super.redirigirAPaginaError(e.getMessage());
		}
	}

	public void agregarALista(Map<String, Object> pistaMusicalDisponible) {
		try {
			pistaMusicalDisponible.put("agregada", true);
			super.putJSON(pistaMusicalDisponible, "pistas/actualizar");
			obtenerPistasMusicales();
			super.addMessage(FacesMessage.SEVERITY_INFO, "Mensaje de Información",
					"La pista musical \"" + pistaMusicalDisponible.get("nombre") + "\" de \""
							+ pistaMusicalDisponible.get("nombreDelArtista") + "\" ha sido agregada correctamente.");
		} catch (Exception e) {
			super.redirigirAPaginaError(e.getMessage());
		}
	}

	private void obtenerPistasMusicales() throws Exception {
		pistasMusicalesDisponibles = super.getJSONList("pistas/listar-disponibles");
		pistasMusicalesAgregadas = super.getJSONList("pistas/listar-agregadas");
	}

	public void moverArriba(Map<String, Object> pistaMusical) {
		int index = pistasMusicalesAgregadas.indexOf(pistaMusical);
		if (index > 0) {
			Collections.swap(pistasMusicalesAgregadas, index, index - 1);
		}
	}

	public void moverAbajo(Map<String, Object> pistaMusical) {
		int index = pistasMusicalesAgregadas.indexOf(pistaMusical);
		if (index < pistasMusicalesAgregadas.size() - 1) {
			Collections.swap(pistasMusicalesAgregadas, index, index + 1);
		}
	}

	public void eliminarPistaAgregada(Map<String, Object> pistaMusical) {
		try {
			pistaMusical.put("agregada", false);
			super.putJSON(pistaMusical, "pistas/actualizar");
			obtenerPistasMusicales();
			super.addMessage(FacesMessage.SEVERITY_ERROR, "Mensaje de Eliminación",
					"La pista musical \"" + pistaMusical.get("nombre") + "\" de \""
							+ pistaMusical.get("nombreDelArtista") + "\" ha sido quitada de la lista correctamente.");
		} catch (Exception e) {
			super.redirigirAPaginaError(e.getMessage());
		}
	}

	public void eliminarPista(Map<String, Object> pistaMusical) {
		try {
			super.deleteJSON("pistas/eliminar/" + pistaMusical.get("id"));
			obtenerPistasMusicales();
			super.addMessage(FacesMessage.SEVERITY_ERROR, "Mensaje de Eliminación",
					"La pista musical \"" + pistaMusical.get("nombre") + "\" de \""
							+ pistaMusical.get("nombreDelArtista") + "\" ha sido eliminada correctamente.");
		} catch (Exception e) {
			super.redirigirAPaginaError(e.getMessage());
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
