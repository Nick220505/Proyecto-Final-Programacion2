package co.edu.unbosque.dao;

import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import co.edu.unbosque.persistence.MySQLDB;

public class Gestion<T extends Object> implements ICrud<T> {

	private MySQLDB<T> ms;
	private Class<T> clase;

	public Gestion(Class<T> clase) {
		this.clase = clase;
		ms = new MySQLDB<>(clase);
	}

	@Override
	public void agregar(T objeto) throws Exception {
		ms.ejecutarTransaccion(sm -> sm.save(objeto));
	}

	@Override
	public List<T> listar() throws Exception {
		return ms.ejecutarConsulta("from " + clase.getSimpleName());
	}

	@Override
	public void actualizar(int id, T objeto) throws Exception {
		ms.ejecutarTransaccion(sm -> {
			T objetoActual = sm.get(clase, id);
			BeanUtils.copyProperties(objetoActual, objeto);
		});
	}

	@Override
	public void eliminar(int id) throws Exception {
		ms.ejecutarTransaccion(sm -> {
			sm.createQuery("delete from " + clase.getSimpleName() + " where id = " + id).executeUpdate();
		});
	}

}
