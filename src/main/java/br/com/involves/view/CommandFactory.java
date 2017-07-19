package br.com.involves.view;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.involves.csv.AlgoritimoCSV;

public class CommandFactory {

	private final static String countALL = "count_*";
	private final static String countDistinct = "count_distinct";
	private final static String filter = "filter";
	private Main main;
	
	public void execute(Main main ,String command){
		this.main = main;
		command = command.trim().replaceAll("\\s", "_");
		Pattern teste = Pattern.compile(countALL,Pattern.CASE_INSENSITIVE);
		Matcher matcher = teste.matcher(command);
		if(matcher.matches()){
			processCountAll();
			return;
		}
		teste = Pattern.compile(countDistinct);
		matcher = teste.matcher(command);
		if(matcher.find()){
			
			String[] inputs = command.split("_");
			if(inputs.length < 3){
				main.printError("Count Distinct not recognized.");
			}
			processCountDistinct(inputs[2]);
			return;
		}
		
		teste = Pattern.compile(filter);
		matcher = teste.matcher(command);
		if(matcher.find()){
			String[] inputs = command.split("_");
			if(inputs.length < 3){
				main.printError("Count Distinct not recognized.");
			}
			filter(inputs[1],inputs[2]);
			return;
		}
		
		
	}
	
	private void processCountAll(){
		AlgoritimoCSV algoritmo = new AlgoritimoCSV(main.getList());
		main.print(algoritmo.count());
	}
	
	private void processCountDistinct(String property){
		AlgoritimoCSV algoritmo = new AlgoritimoCSV(main.getList());
		main.print(algoritmo.countDisctinct(property));
	}
	
	private void filter(String property, Object value){
		AlgoritimoCSV algoritmo = new AlgoritimoCSV(main.getList());
		main.print(algoritmo.filter(property, value));
	}
	
}
