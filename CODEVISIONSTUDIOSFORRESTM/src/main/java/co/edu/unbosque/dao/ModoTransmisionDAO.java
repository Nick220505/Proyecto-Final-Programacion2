package co.edu.unbosque.dao;

import java.util.ArrayList;

import co.edu.unbosque.dto.ModoTransmisionDTO;
import co.edu.unbosque.persistence.MySQLDB;

public class ModoTransmisionDAO implements ICrud<ModoTransmisionDTO> {

	private MySQLDB<ModoTransmisionDTO> ms;
	private static String cadena;

	public ModoTransmisionDAO() {
		ms = new MySQLDB<>();
	}

	@Override
	public void agregar(ModoTransmisionDTO modoTransmision) throws Exception {

		cadena = "INSERT INTO `modos_transmision` (`modo`) VALUES ('" + modoTransmision.getModo() + "');";

		ms.insertarDB(cadena);
	}

	@Override
	public ArrayList<ModoTransmisionDTO> listar() throws Exception {

		cadena = "SELECT * FROM `modos_transmision`;";

		return ms.consultarTablaDB(cadena, rs -> new ModoTransmisionDTO(rs.getString("modo")));
	}

}
