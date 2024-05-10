package co.edu.unbosque.forrestmfront.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "emisoraBean")
@SessionScoped
public class ParametrizacionEmisoraBean extends BeanBase {

	private Map<String, Object> emisora;
	private List<Map<String, Object>> categorias;
	private String textoBotonEnviar;

	public void onLoad() {
		emisora = new HashMap<>();
		try {
			List<Map<String, Object>> emisoras = super.getJSONList("emisoras/listar");
			if (emisoras.size() > 0) {
				emisora = super.getJSONObject("emisoras/obtener/" + emisoras.get(0).get("id"));
				setTextoBotonEnviar("Actualizar");
			} else {
				setTextoBotonEnviar("Guardar");
			}
			categorias = super.getJSONList("spotify/categories");
		} catch (Exception e) {
			super.redirigirAPaginaError(e.getMessage());
		}
	}

	public String enviar() {
		try {
			if (super.getJSONList("emisoras/listar").size() > 0) {
				super.postJSON(emisora, "emisoras/guardar");
			} else {
				super.putJSON(emisora, "emisoras/actualizar");
			}
			return "index.xhtml?faces-redirect=true";
		} catch (Exception e) {
			super.redirigirAPaginaError(e.getMessage());
			return null;
		}
	}

	public void reiniciarEntradas() {
		emisora.forEach((key, value) -> {
			if (!key.equals("id")) {
				emisora.put(key, "");
			}
		});
	}

	public Map<String, Object> getEmisora() {
		return emisora;
	}

	public void setEmisora(Map<String, Object> emisora) {
		this.emisora = emisora;
	}

	public List<Map<String, Object>> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Map<String, Object>> categorias) {
		this.categorias = categorias;
	}

	public String getTextoBotonEnviar() {
		return textoBotonEnviar;
	}

	public void setTextoBotonEnviar(String textoBotonEnviar) {
		this.textoBotonEnviar = textoBotonEnviar;
	}

}
