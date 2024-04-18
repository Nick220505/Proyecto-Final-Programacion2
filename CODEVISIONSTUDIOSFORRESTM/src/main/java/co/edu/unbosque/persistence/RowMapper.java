package co.edu.unbosque.persistence;

import java.sql.ResultSet;

@FunctionalInterface
public interface RowMapper<T extends Object> {
	public abstract T mapRow(ResultSet rs) throws Exception;
}
