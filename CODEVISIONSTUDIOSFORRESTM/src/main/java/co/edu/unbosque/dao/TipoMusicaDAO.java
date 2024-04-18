package co.edu.unbosque.dao;

import java.util.ArrayList;

import co.edu.unbosque.dto.TipoMusicaDTO;
import co.edu.unbosque.persistence.MySQLDB;

public class TipoMusicaDAO implements ICrud<TipoMusicaDTO> {

	private MySQLDB<TipoMusicaDTO> ms;
	private static String cadena;

	public TipoMusicaDAO() {
		ms = new MySQLDB<>();
	}

	@Override
	public void guardar(TipoMusicaDTO tipoMusica) throws Exception {

		cadena = "INSERT INTO `tipos_musica` (`tipo`) VALUES ('" + tipoMusica.getTipo() + "');";

		ms.insertarDB(cadena);
	}

	@Override
	public ArrayList<TipoMusicaDTO> listar() throws Exception {

		cadena = "SELECT * FROM `tipos_musica`;";

		return ms.consultarTablaDB(cadena, rs -> new TipoMusicaDTO(rs.getString("tipo")));
	}

}
