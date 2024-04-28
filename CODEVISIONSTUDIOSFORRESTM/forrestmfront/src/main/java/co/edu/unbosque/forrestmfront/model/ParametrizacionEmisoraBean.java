package co.edu.unbosque.forrestmfront.model;

import java.util.HashMap;
import java.util.Map;

import javax.faces.bean.ManagedBean;

import org.json.JSONArray;
import org.json.JSONObject;

@ManagedBean(name = "emisoraBean")
public class ParametrizacionEmisoraBean extends BeanBase {

	private int id;
	private String nombre;
	private String modoDeTransmision;
	private String tipoDeMusica;

	private String textoBotonEnviar;

	public void onLoad() {
		try {
			JSONArray arrayEmisoras = super.getJSON("emisoras/listar");
			if (arrayEmisoras.length() > 0) {
				JSONObject emisoraExistente = arrayEmisoras.getJSONObject(0);
				setId(emisoraExistente.getInt("id"));
				setNombre(emisoraExistente.getString("nombre"));
				setModoDeTransmision(emisoraExistente.getString("modoDeTransmision"));
				setTipoDeMusica(emisoraExistente.getString("tipoDeMusica"));
				setTextoBotonEnviar("Actualizar");
			} else {
				setTextoBotonEnviar("Guardar");
			}
		} catch (Exception e) {
			super.redirigirAPaginaError(e.getMessage());
		}
	}

	public String enviar() {
		try {
			Map<String, Object> datosEmisora = new HashMap<>();
			datosEmisora.put("nombre", getNombre());
			datosEmisora.put("modoDeTransmision", getModoDeTransmision());
			datosEmisora.put("tipoDeMusica", getTipoDeMusica());
			if (super.getJSON("emisoras/listar").length() > 0) {
				datosEmisora.put("id", getId());
				super.putJSON(datosEmisora, "emisoras/actualizar");
			} else {
				super.postJSON(datosEmisora, "emisoras/guardar");
			}
			return "index.xhtml?faces-redirect=true";
		} catch (Exception e) {
			super.redirigirAPaginaError(e.getMessage());
			return null;
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getModoDeTransmision() {
		return modoDeTransmision;
	}

	public void setModoDeTransmision(String modoDeTransmision) {
		this.modoDeTransmision = modoDeTransmision;
	}

	public String getTipoDeMusica() {
		return tipoDeMusica;
	}

	public void setTipoDeMusica(String tipoDeMusica) {
		this.tipoDeMusica = tipoDeMusica;
	}

	public String getTextoBotonEnviar() {
		return textoBotonEnviar;
	}

	public void setTextoBotonEnviar(String textoBotonEnviar) {
		this.textoBotonEnviar = textoBotonEnviar;
	}

}
