package br.com.involves.csv;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import br.com.involves.algoritmo.AlgoritimoFilter;
import br.com.involves.reflect.Reflections;

public class AlgoritimoCSV extends AlgoritimoFilter {

	private List list;

	public <T> AlgoritimoCSV(List<T> list) {
		this.list = list;
	}

	@Override
	public long count() {
		if (list != null) {
			return list.size();
		}
		return 0;
	}

	@Override
	public long countDisctinct(String property) {
		try {
			String method = Reflections.getMethod(list.get(0), property).concat("()");
			Function function = fromString("function(x) x.".concat(method));
			return list.stream().filter(distinctByKey(function)).count();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return 0;
	}

	@Override
	public List<?> filter(String property, Object value) {
		try {
			List result = new ArrayList();
			String method = Reflections.getMethod(list.get(0), property).concat("()");
			Function function = fromString("function(x) {if (x.".concat(method).concat(".equals('".concat(String.valueOf(value).concat("')) return x; return null;}"))));
			for(Object o : list){
				Object object = function.apply(o);
				if (object != null){
				result.add(object);
				}
			}
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
