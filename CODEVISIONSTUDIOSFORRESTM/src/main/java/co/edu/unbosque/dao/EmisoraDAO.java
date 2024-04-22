package co.edu.unbosque.dao;

import co.edu.unbosque.dto.EmisoraDTO;

public class EmisoraDAO extends Gestion<EmisoraDTO> {

	public EmisoraDAO() {
		super(EmisoraDTO.class);
	}
	
	public boolean existeEmisora() throws Exception {
		return listar().size() > 0;
	}
	
	public int obtenerIdEmisoraActual() throws Exception {
		return listar().get(0).getId();
	}
	
	public EmisoraDTO obtenerEmisoraActual() throws Exception {
		return listar().get(0);
	}

}
