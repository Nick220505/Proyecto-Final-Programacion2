package co.edu.unbosque.dao;

import co.edu.unbosque.dto.CancionDTO;

public class CancionDAO extends Gestion<CancionDTO> {

	public CancionDAO() {
		super(CancionDTO.class);
	}
	
	public int obtenerIdCancion(String url) throws Exception {
		return listar().stream().filter(c -> c.getUrl().equals(url)).findFirst().orElseThrow().getId();
	}

}
