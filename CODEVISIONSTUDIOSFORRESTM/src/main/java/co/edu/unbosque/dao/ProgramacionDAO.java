package co.edu.unbosque.dao;

import java.util.ArrayList;

import co.edu.unbosque.dto.ProgramacionDTO;
import co.edu.unbosque.persistence.MySQLDB;

public class ProgramacionDAO implements ICrud<ProgramacionDTO> {

	private MySQLDB<ProgramacionDTO> ms;
	private static String cadena;
	
	public ProgramacionDAO() {
		ms = new MySQLDB<>();
	}

	@Override
	public void guardar(ProgramacionDTO programacion) throws Exception {

		cadena = "INSERT INTO `programaciones` (`fecha`) VALUES ('" + programacion.getFecha() + "');";

		ms.insertarDB(cadena);
	}

	@Override
	public ArrayList<ProgramacionDTO> listar() throws Exception {

		cadena = "SELECT * FROM `programaciones`;";

		return ms.consultarTablaDB(cadena, rs -> new ProgramacionDTO(rs.getDate("fecha")));
	}

}
