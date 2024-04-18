package co.edu.unbosque.dao;

import java.util.ArrayList;

import co.edu.unbosque.dto.EmisoraDTO;
import co.edu.unbosque.persistence.MySQLDB;

public class EmisoraDAO implements ICrud<EmisoraDTO> {
	
	private MySQLDB<EmisoraDTO> ms;
	private static String cadena;
	
	public EmisoraDAO() {
		ms = new MySQLDB<>();
	}

	@Override
	public void guardar(EmisoraDTO emisora) throws Exception {
		
		cadena = "INSERT INTO `emisoras` (`nombre`, `id_modo_transmision`, `id_tipo_musica`) "
			   + "VALUES "
			   + "("
			   + "'" + emisora.getNombre() + "', "
			   + emisora.getIdModoTransmision() + ", "
			   + emisora.getIdTipoMusica()
			   + ");";
		
		ms.insertarDB(cadena);
	}

	@Override
	public ArrayList<EmisoraDTO> listar() throws Exception {
		
		cadena = "SELECT * FROM `emisoras`;";
		
		return ms.consultarTablaDB(cadena, rs -> new EmisoraDTO(
				rs.getString("nombre"),
				rs.getInt("id_modo_transmision"),
				rs.getInt("id_tipo_musica")
			)
		);
	}

}
