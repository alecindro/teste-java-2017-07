package br.com.involves.algoritmo;

import java.util.List;

public interface Algoritimo {
	
	public long count();
	
	public long countDisctinct(String property);
	
	public List<?> filter(String property, Object value);
	
	
}
