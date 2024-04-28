package co.edu.unbosque.forrestmfront.model;

import java.util.Map;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

public abstract class BeanBase {

	private static final String url = "http://localhost:8088/";
	private static final RestTemplate restTemplate = new RestTemplate();
	private static final HttpHeaders headers = new HttpHeaders();
	private static HttpEntity<String> entity;

	protected void redirigirAPaginaError(String mensaje) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext externalContext = facesContext.getExternalContext();
		externalContext.getSessionMap().put("mensajeError", mensaje);
		try {
			externalContext.redirect("error.xhtml");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected JSONArray getJSON(String mapping) throws Exception {
		String json = restTemplate.getForObject(url + mapping, String.class);
		return new JSONArray(json);
	}

	protected void postJSON(Map<String, Object> data, String mapping) throws Exception {
		prepareHttpEntity(data);
		restTemplate.postForObject(url + mapping, entity, String.class);
	}

	protected void putJSON(Map<String, Object> data, String mapping) throws Exception {
		prepareHttpEntity(data);
		restTemplate.put(url + mapping, entity, String.class);
	}

	protected void deleteJSON(String mapping) throws Exception {
		restTemplate.delete(url + mapping);
	}

	private void prepareHttpEntity(Map<String, Object> data) throws Exception {
		JSONObject jsonObject = new JSONObject(data);
		headers.setContentType(MediaType.APPLICATION_JSON);
		entity = new HttpEntity<>(jsonObject.toString(), headers);
	}
}
