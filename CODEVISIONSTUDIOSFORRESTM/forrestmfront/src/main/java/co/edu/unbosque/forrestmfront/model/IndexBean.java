package co.edu.unbosque.forrestmfront.model;

import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "indexBean")
@SessionScoped
public class IndexBean extends BeanBase {

	private Map<String, Object> emisora;
	private List<String> idsPlaylists;

	public void onLoad() {
		try {
			List<Map<String, Object>> emisoras = super.getJSONList("emisoras/listar");
			if (emisoras.size() > 0) {
				emisora = emisoras.get(0);
				idsPlaylists = super.getStringListResponse("spotify/playlists/" + emisora.get("tipoDeMusica"));
			} else {
				idsPlaylists = super.getStringListResponse("spotify/playlists");
			}
		} catch (Exception e) {
			super.redirigirAPaginaError(e.getMessage());
		}
	}

	public List<String> getIdsPlaylists() {
		return idsPlaylists;
	}

	public void setIdsPlaylists(List<String> idsPlayLists) {
		this.idsPlaylists = idsPlayLists;
	}

}
