package co.edu.unbosque.forrestmfront.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
	
	public List<Map<String, Object>> getJSONList(String mapping) throws Exception {
		List<Map<String, Object>> objectList = new ArrayList<>();
		JSONArray jsonArray = getJSON(mapping);
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject jsonObject = jsonArray.getJSONObject(i);
			Map<String, Object> object = new HashMap<>();
			for (String key : jsonObject.keySet()) {
				object.put(key, jsonObject.get(key));
			}
			objectList.add(object);
		}
		return objectList;
	} 

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

}
