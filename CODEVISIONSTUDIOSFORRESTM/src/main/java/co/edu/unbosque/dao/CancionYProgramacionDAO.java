package co.edu.unbosque.dao;

import java.util.ArrayList;

import co.edu.unbosque.dto.CancionYProgramacionDTO;
import co.edu.unbosque.persistence.MySQLDB;

public class CancionYProgramacionDAO implements ICrud<CancionYProgramacionDTO> {

	private MySQLDB<CancionYProgramacionDTO> ms;
	private static String cadena;

	public CancionYProgramacionDAO() {
		ms = new MySQLDB<>();
	}

	@Override
	public void guardar(CancionYProgramacionDTO cancionYProgramacion) throws Exception {
		
		cadena = "INSERT INTO `canciones_y_programaciones` (`id_cancion`, `id_programacion`) "
			   + "VALUES "
			   + "("
			   + cancionYProgramacion.getIdCancion() + ", "
			   + cancionYProgramacion.getIdProgramacion()
			   + ");";

		ms.insertarDB(cadena);
	}

	@Override
	public ArrayList<CancionYProgramacionDTO> listar() throws Exception {
		
		cadena = "SELECT * FROM `canciones_y_programaciones`;";
		
		return ms.consultarTablaDB(cadena, rs -> new CancionYProgramacionDTO(
				rs.getInt("id_cancion"),
				rs.getInt("id_programacion")
			)
		);
	}

}
