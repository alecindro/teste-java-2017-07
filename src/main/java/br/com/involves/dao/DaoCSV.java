package br.com.involves.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import br.com.involves.reflect.Reflections;

public abstract class DaoCSV<T> implements Dao<T> {

	private static final char DEFAULT_SEPARATOR = ',';
	private String[] colunas;

	protected abstract URL getURL();
	
	public List<T> list() throws DaoException {
		Reader reader = loadCSV();
		return readObject(reader);
	}

	private Reader loadCSV() throws DaoException {
		URL url = getURL();
		try {
			URLConnection uc = url.openConnection();
			return new InputStreamReader(uc.getInputStream());
		} catch (IOException e) {
			throw new DaoException("Erro ao carregar o arquivo: " + url.toString(), e);
		}
	}
	
	public String[] getColumns(){
		return colunas;
	}

	
	protected List<T> readObject(Reader reader) throws DaoException {
		List<T> csvList = new ArrayList<T>();
		BufferedReader br = new BufferedReader(reader);
		String line = "";
		boolean first = true;
		try {
				while ((line = br.readLine()) != null) {
					try {
						if(first){
							colunas = line.split(String.valueOf(DEFAULT_SEPARATOR));
							first = false;
							continue;
						}
						T t = Reflections.newInstance(getClass());
						String[] data = line.split(String.valueOf(DEFAULT_SEPARATOR));
						int i = 0;
						for (String _data : data) {
							Reflections.setValue(t, _data, colunas[i]);
							
						    i = i+1;
						}
						csvList.add(t);
					} catch (Exception e) {
						throw new DaoException("Erro no parser do csv", e);
					}
				}
			
		} catch (IOException e) {
			throw new DaoException(e.getMessage(), e);
		} finally{
			try {
				br.close();
			} catch (IOException e) {
				
			}
		}
		return csvList;
	}

	
}
