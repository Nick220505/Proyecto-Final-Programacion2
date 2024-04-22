package co.edu.unbosque.dao;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import co.edu.unbosque.dto.GeneroMusicalDTO;

public class GeneroMusicalDAO extends Gestion<GeneroMusicalDTO> {

	public GeneroMusicalDAO() {
		super(GeneroMusicalDTO.class);
	}

	public List<String> listarGenerosMusicales() throws Exception {
		asignarGenerosMusicales();
		return listar().stream().map(GeneroMusicalDTO::getGenero).collect(Collectors.toList());
	}

	public void asignarGenerosMusicales() throws Exception {
		List<String> generosExistentes = listar().stream().map(GeneroMusicalDTO::getGenero).collect(Collectors.toList());
		Set<String> generosAAgregar = new HashSet<>(Arrays.asList("Rock", "Reggaeton", "Pop"));
		generosAAgregar.removeAll(generosExistentes);

		for (String genero : generosAAgregar) {
			agregar(new GeneroMusicalDTO(genero));
		}
	}

}
