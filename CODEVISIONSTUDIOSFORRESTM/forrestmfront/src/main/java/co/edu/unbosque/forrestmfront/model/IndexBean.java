package co.edu.unbosque.forrestmfront.model;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "indexBean")
@SessionScoped
public class IndexBean extends BeanBase {

	private List<String> idsPlaylists;

	public void onLoad() {
		try {
			idsPlaylists = super.getStringListResponse("spotify/playlists");
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
