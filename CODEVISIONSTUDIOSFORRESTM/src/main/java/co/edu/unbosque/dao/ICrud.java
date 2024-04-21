package co.edu.unbosque.dao;

import java.util.List;

public interface ICrud<T> {

	public abstract void agregar(T objeto) throws Exception;

	public abstract List<T> listar() throws Exception;

	public abstract void actualizar(int id, T objeto) throws Exception;

	public abstract void eliminar(int id) throws Exception;
}
