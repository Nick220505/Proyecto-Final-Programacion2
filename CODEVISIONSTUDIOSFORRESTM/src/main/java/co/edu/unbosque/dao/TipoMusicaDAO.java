package co.edu.unbosque.dao;

import java.util.List;
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
		String[] tipos = {"Rock", "De Planchar", "Reggaeton"};
		for (String tipo : tipos) {
			if (!listar().stream().map(TipoMusicaDTO::getTipo).collect(Collectors.toList()).contains(tipo)) {
				agregar(new TipoMusicaDTO(tipo));
			}
		}
	}

}
