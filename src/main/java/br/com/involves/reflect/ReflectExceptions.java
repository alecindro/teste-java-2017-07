package br.com.involves.reflect;

public class ReflectExceptions extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ReflectExceptions(String message) {
		super(message);
	}
	
	public ReflectExceptions(String message,Throwable cause) {
		super(message,cause);
	}
}
