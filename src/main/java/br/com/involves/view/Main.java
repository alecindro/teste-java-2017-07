package br.com.involves.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import br.com.involves.dao.Dao;
import br.com.involves.dao.DaoException;
import br.com.involves.dao.DaoFactory;

public class Main {

	private static final String fileCSV = "cidades.csv";
	private List<?> list;
	private String command;
	private Dao dao;

	public void init(){
		try {
			loadData();
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		userprompt();
	}
	
	public void printError(String message){
		System.out.println("OOPS, ocorreu um erro!! ");
		System.out.println(message);
	}

	public void print(long value) {
		System.out.println("Resultado: " + value);
	}
	
	public void print(List values){
		System.out.println("Resultado: " );
		System.out.println(Arrays.toString(dao.getColumns()));
		for(Object o : values){
			System.out.println(o.toString());
		}
	}

	public List<?> getList() {
		return list;
	}

	private void loadData() throws DaoException {
		dao = DaoFactory.getDaoCSVCidade(getClass().getResource("/" + fileCSV));
		list = dao.list();
	}

	private void userprompt() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter your command:");
		command = input.nextLine();
		CommandFactory cf = new CommandFactory();
		cf.execute(this, command);
	}

	

	public static void main(String[] args) {
		Main main = new Main();
		main.init();
	}

}
