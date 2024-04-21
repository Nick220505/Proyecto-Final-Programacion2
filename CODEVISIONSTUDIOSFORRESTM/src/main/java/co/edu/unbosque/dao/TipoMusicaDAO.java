package co.edu.unbosque.dao;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import co.edu.unbosque.dto.TipoMusicaDTO;

public class TipoMusicaDAO extends Gestion<TipoMusicaDTO> {

	public TipoMusicaDAO() {
		super(TipoMusicaDTO.class);
	}

	public List<String> listarTiposDeMusica() throws Exception {
		asignarTiposDeMusica();
		return listar().stream().map(TipoMusicaDTO::getTipo).collect(Collectors.toList());
	}

	public void asignarTiposDeMusica() throws Exception {
		List<String> tiposExistentes = listar().stream().map(TipoMusicaDTO::getTipo).collect(Collectors.toList());
		Set<String> tiposAAgregar = new HashSet<>(Arrays.asList("Rock", "De Planchar", "Reggaeton"));
		tiposAAgregar.removeAll(tiposExistentes);

		for (String tipo : tiposAAgregar) {
			agregar(new TipoMusicaDTO(tipo));
		}
	}

	public int obtenerIdTipoDeMusica(String tipo) throws Exception {
		return listar().stream().filter(tm -> tm.getTipo().equals(tipo)).findFirst().orElseThrow().getId();
	}

}
