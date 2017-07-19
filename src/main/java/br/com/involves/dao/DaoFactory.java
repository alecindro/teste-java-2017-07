package br.com.involves.dao;

import java.net.URL;

import br.com.involves.csv.DaoCsvCidade;

public class DaoFactory {
	
	public static Dao getDaoCSVCidade(URL url){
		return new DaoCsvCidade(url);
	}

}
