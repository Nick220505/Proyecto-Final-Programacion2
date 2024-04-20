package co.edu.unbosque.dao;

import java.util.ArrayList;

import co.edu.unbosque.dto.GeneroMusicalDTO;
import co.edu.unbosque.persistence.MySQLDB;

public class GeneroMusicalDAO implements ICrud<GeneroMusicalDTO> {

	private MySQLDB<GeneroMusicalDTO> ms;
	private static String cadena;

	public GeneroMusicalDAO() {
		ms = new MySQLDB<>();
	}

	@Override
	public void agregar(GeneroMusicalDTO generoMusical) throws Exception {

		cadena = "INSERT INTO `generos_musicales` (`genero`) VALUES ('" + generoMusical.getGenero() + "');";

		ms.insertarDB(cadena);
	}

	@Override
	public ArrayList<GeneroMusicalDTO> listar() throws Exception {

		cadena = "SELECT * FROM `generos_musicales`;";

		return ms.consultarTablaDB(cadena, rs -> new GeneroMusicalDTO(rs.getString("genero")));
	}

}
