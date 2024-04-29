package co.edu.unbosque.forrestmfront.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "pistaMusicalBean")
@SessionScoped
public class CreacionPistaMusicalBean extends BeanBase {

	private Map<String, Object> pistaMusical;

	public void onLoad() {
		pistaMusical = new HashMap<>();
	}

	public String enviar() {
		try {
			String trackId = super.getStringResponse("spotify/track/" + pistaMusical.get("nombre"));
			pistaMusical.put("idPista", trackId);
			super.postJSON(pistaMusical, "pistas/guardar");
			return "programacionDelDia.xhtml?faces-redirect=true";
		} catch (Exception e) {
			redirigirAPaginaError(e.getMessage());
			return null;
		}
	}

	public List<String> completeTrackName(String name) {
		try {
			return super.getStringListResponse("spotify/tracks/" + name);
		} catch (Exception e) {
			return new ArrayList<>();
		}
	}

	public List<String> completeArtistName(String name) {
		try {
			return super.getStringListResponse("spotify/artists/" + pistaMusical.get("nombre") + "/" + name);
		} catch (Exception e) {
			return new ArrayList<>();
		}
	}

	public void reiniciarEntradas() {
		pistaMusical.forEach((key, value) -> pistaMusical.put(key, ""));
	}

	public Map<String, Object> getPistaMusical() {
		return pistaMusical;
	}

	public void setPistaMusical(Map<String, Object> pistaMusical) {
		this.pistaMusical = pistaMusical;
	}

}
