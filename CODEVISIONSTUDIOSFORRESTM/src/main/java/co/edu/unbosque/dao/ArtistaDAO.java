package co.edu.unbosque.dao;

import java.util.ArrayList;

import co.edu.unbosque.dto.ArtistaDTO;
import co.edu.unbosque.persistence.MySQLDB;

public class ArtistaDAO implements ICrud<ArtistaDTO> {

	private MySQLDB<ArtistaDTO> ms;
	private static String cadena;
	
	public ArtistaDAO() {
		ms = new MySQLDB<>();
	}

	@Override
	public void agregar(ArtistaDTO artista) throws Exception {

		cadena = "INSERT INTO `artistas` ('nombre') VALUES ('" + artista.getNombre() + "');";

		ms.insertarDB(cadena);
	}

	@Override
	public ArrayList<ArtistaDTO> listar() throws Exception {

		cadena = "SELECT * FROM `artistas`;";

		return ms.consultarTablaDB(cadena, rs -> new ArtistaDTO(rs.getString("nombre")));
	}

}
