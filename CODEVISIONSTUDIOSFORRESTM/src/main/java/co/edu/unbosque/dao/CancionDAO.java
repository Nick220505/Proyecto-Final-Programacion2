package co.edu.unbosque.dao;

import java.util.ArrayList;

import co.edu.unbosque.dto.CancionDTO;
import co.edu.unbosque.persistence.MySQLDB;

public class CancionDAO implements ICrud<CancionDTO> {

	private MySQLDB<CancionDTO> ms;
	private static String cadena;

	public CancionDAO() {
		ms = new MySQLDB<>();
	}

	@Override
	public void guardar(CancionDTO cancion) throws Exception {
		
		cadena = "INSERT INTO `canciones` (`nombre`, `nombre_archivo`, `id_emisora`) "
			   + "VALUES "
			   + "("
			   + "'" + cancion.getNombre() + "', "
			   + "'" + cancion.getNombreArchivo() + "', "
			   + cancion.getIdEmisora()
			   + ");";

		ms.insertarDB(cadena);
	}

	@Override
	public ArrayList<CancionDTO> listar() throws Exception {
		
		cadena = "SELECT * FROM `canciones` JOIN `emisoras` ON `canciones`.`id_emisora` = `emisoras`.`id`;";
		
		return ms.consultarTablaDB(cadena, rs -> new CancionDTO(
				rs.getString("nombre"),
				rs.getString("nombre_archivo"),
				rs.getInt("id_emisora"),
				rs.getInt("id_genero_musical")
			)
		);
	}

}
