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
	private List<String> generosMusicales;

	public void onLoad() {
		pistaMusical = new HashMap<>();
		pistaMusical.put("nombre", "");
		pistaMusical.put("nombreDelArtista", "");
		pistaMusical.put("generoMusical", "");
		try {
			generosMusicales = super.getStringListResponse("spotify/genres");
		} catch (Exception e) {
			generosMusicales = new ArrayList<>();
		} finally {
			generosMusicales.add("vallenato");
			generosMusicales.add("corrido");
			generosMusicales.add("merengue");
			generosMusicales.add("cumbia");
		}
	}

	public String enviar() {
		try {
			String trackId = super.getStringResponse(
					"spotify/track/" + pistaMusical.get("nombre") + "/" + pistaMusical.get("nombreDelArtista"));
			pistaMusical.put("idPista", trackId);
			super.postJSON(pistaMusical, "pistas/guardar");
			return "programacionDelDia.xhtml?faces-redirect=true";
		} catch (Exception e) {
			redirigirAPaginaError(e.getMessage());
			return null;
		}
	}

	public List<String> completeTrackName(String query) {
		pistaMusical.put("nombre", query);
		if (query == null || query.isEmpty()) {
			return new ArrayList<>();
		}
		try {
			if (!pistaMusical.get("nombreDelArtista").toString().isEmpty()) {
				return super.getStringListResponse(
						"spotify/tracks/" + query + "/" + pistaMusical.get("nombreDelArtista"));
			}
			return super.getStringListResponse("spotify/tracks/" + query);
		} catch (Exception e) {
			return new ArrayList<>();
		}
	}

	public List<String> completeArtistName(String query) {
		pistaMusical.put("nombreDelArtista", query);
		if (query == null || query.isEmpty()) {
			return new ArrayList<>();
		}
		try {
			if (pistaMusical.get("nombre").toString().isEmpty()) {
				return super.getStringListResponse("spotify/artists/" + query);
			}
			return super.getStringListResponse("spotify/artists/" + pistaMusical.get("nombre") + "/" + query);
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

	public List<String> getGenerosMusicales() {
		return generosMusicales;
	}

	public void setGenerosMusicales(List<String> generosMusicales) {
		this.generosMusicales = generosMusicales;
	}

}
