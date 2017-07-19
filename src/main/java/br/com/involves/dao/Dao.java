package br.com.involves.dao;

import java.util.List;

public interface Dao<T> {

	public List<T> list() throws DaoException;	
	
	public String[] getColumns();
}
