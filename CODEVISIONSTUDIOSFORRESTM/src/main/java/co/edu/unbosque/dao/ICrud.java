package co.edu.unbosque.dao;

import java.util.ArrayList;

public interface ICrud<T extends Object> {

	public abstract void guardar(T objeto) throws Exception;

	public abstract ArrayList<T> listar() throws Exception;
}
