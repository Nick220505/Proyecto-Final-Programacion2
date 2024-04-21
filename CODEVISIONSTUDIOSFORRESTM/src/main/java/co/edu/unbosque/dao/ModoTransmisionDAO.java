package co.edu.unbosque.dao;

import java.util.List;
import java.util.stream.Collectors;

import co.edu.unbosque.dto.ModoTransmisionDTO;

public class ModoTransmisionDAO extends Gestion<ModoTransmisionDTO> {

	public ModoTransmisionDAO() {
		super(ModoTransmisionDTO.class);
	}

	public List<String> listarModosDeTransmision() throws Exception {
		asignarModosDeTransmision();
		return listar().stream().map(ModoTransmisionDTO::getModo).collect(Collectors.toList());
	}

	public void asignarModosDeTransmision() throws Exception {
		String[] modos = { "AM", "FM", "Streaming" };
		for (String modo : modos) {
			if (!listar().stream().map(ModoTransmisionDTO::getModo).collect(Collectors.toList()).contains(modo)) {
				agregar(new ModoTransmisionDTO(modo));
			}
		}
	}

	public int obtenerIdModoDeTransmision(String modo) throws Exception {
		return listar().stream().filter(mt -> mt.getModo().equals(modo)).findFirst().orElseThrow().getId();
	}

}
