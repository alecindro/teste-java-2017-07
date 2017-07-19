package br.com.involves.csv;

import java.net.URL;

import br.com.involves.dao.DaoCSV;
import br.com.involves.model.Cidade;

public class DaoCsvCidade extends DaoCSV<Cidade>{

	private URL url;
	
	public DaoCsvCidade(URL url) {
		this.url = url;
	}
	
	@Override
	protected URL getURL() {
		return url;
	}
	
	
	
}
