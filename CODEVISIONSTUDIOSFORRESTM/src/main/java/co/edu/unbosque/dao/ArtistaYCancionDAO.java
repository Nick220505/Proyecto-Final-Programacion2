package co.edu.unbosque.dao;

import java.util.ArrayList;

import co.edu.unbosque.dto.ArtistaYCancionDTO;
import co.edu.unbosque.persistence.MySQLDB;

public class ArtistaYCancionDAO implements ICrud<ArtistaYCancionDTO> {
	
	private MySQLDB<ArtistaYCancionDTO> ms;
	private static String cadena;
	
	public ArtistaYCancionDAO() {
		ms = new MySQLDB<>();
	}

	@Override
	public void guardar(ArtistaYCancionDTO artistaYCancion) throws Exception {
		
		cadena = "INSERT INTO `artistas_y_canciones` (`id_artista`, `id_cancion`) "
			   + "VALUES "
			   + "("
			   + artistaYCancion.getIdArtista() + ", "
			   + artistaYCancion.getIdCancion()
			   + ");";
		
		ms.insertarDB(cadena);
	}

	@Override
	public ArrayList<ArtistaYCancionDTO> listar() throws Exception {
		
		cadena = "SELECT * FROM `artistas_y_canciones`;";

		return ms.consultarTablaDB(cadena, rs -> new ArtistaYCancionDTO(
				rs.getInt("id_artista"),
				rs.getInt("id_cancion")
			)
		);
	}

}
