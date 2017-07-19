package br.com.involves.dao;

public class DaoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DaoException(String message) {
		super(message);
	}
	
	public DaoException(String message,Throwable cause) {
		super(message,cause);
	}
	
	
}
