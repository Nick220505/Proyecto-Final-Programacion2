package co.edu.unbosque.dao;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
		List<String> existingModos = listar().stream().map(ModoTransmisionDTO::getModo).collect(Collectors.toList());
		Set<String> modosToAdd = new HashSet<>(Arrays.asList("AM", "FM", "Streaming"));
		modosToAdd.removeAll(existingModos);

		for (String modo : modosToAdd) {
			agregar(new ModoTransmisionDTO(modo));
		}
	}

	public int obtenerIdModoDeTransmision(String modo) throws Exception {
		return listar().stream().filter(mt -> mt.getModo().equals(modo)).findFirst().orElseThrow().getId();
	}
	
	public String obtenerModo(int id) throws Exception {
		return listar().stream().filter(mt -> mt.getId() == id).findFirst().orElseThrow().getModo();
	}

}
