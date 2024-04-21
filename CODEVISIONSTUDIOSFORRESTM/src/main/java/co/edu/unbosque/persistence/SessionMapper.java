package co.edu.unbosque.persistence;

import org.hibernate.Session;

@FunctionalInterface
public interface SessionMapper {
	public abstract void mapSession(Session miSession) throws Exception;
}
