package br.com.involves.dao;

import java.io.File;
import java.io.Writer;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

import br.com.involves.csv.AlgoritimoCSV;
import br.com.involves.csv.DaoCsvCidade;
import br.com.involves.model.Cidade;
import br.com.involves.reflect.Reflections;

public class Teste {

	private static final char DEFAULT_SEPARATOR = ',';
	public static void main(String[] args) {
	
Teste teste = new Teste();
teste.teste();
	}
	
	public void teste(){
		Dao dao = DaoFactory.getDaoCSVCidade(getClass().getResource("/" + "cidades.csv"));
		try {

			URL url = new File("C:\\Users\\aleci\\OneDrive\\Documentos\\temp\\csv.csv").toURI().toURL();
			dao = new DaoCsvCidade(url);
			List<Cidade> cidades = dao.list();
			AlgoritimoCSV alg = new AlgoritimoCSV(cidades);
			String propery;
			//System.out.println(cidades.stream().filter(distinctByKey(p -> p.getCapital())).count());
			//System.out.println("Count "+ alg.count());
			//System.out.println("Distinct "+ alg.countDisctinct("uf"));
			List list = alg.filter("ibge_id", "1100049");
			for(Object o : list){
				System.out.println("Filter" +o.toString());
			}
			
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void writeLine(Writer writer, List<Cidade> values, char separators, char customQuote)
			throws Exception {
		boolean first = true;
		if (separators == ' ') {
			separators = DEFAULT_SEPARATOR;
		}
		StringBuilder sb = new StringBuilder();
		for (Cidade value : values) {
			
				sb.append(value.toString());
			
			first = false;
			sb.append("\n");
		}
		
	
			writer.append(sb.toString());
	}
	
	private static String followCVSformat(String value) {

		String result = value;
		if (result.contains("\"")) {
			result = result.replace("\"", "\"\"");
		}
		return result;

	}
	
	 public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) 
	    {
	        Map<Object, Boolean> map = new ConcurrentHashMap<>();
	        return t -> map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
	    }
	 
	 public static <T> Predicate<T> predicateFilter(Function<? super T, Object> keyExtractor) 
	    {
	        Map<Object, Boolean> map = new ConcurrentHashMap<>();
	        return t -> map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
	    }

}
