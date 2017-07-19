package br.com.involves.algoritmo;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public abstract class AlgoritimoFilter implements Algoritimo {

	protected <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
		Map<Object, Boolean> seen = new ConcurrentHashMap<>();
		return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
	}
	
	protected <T> Predicate<T> predicateFilter(Function<? super T, ?> keyExtractor) {
		Map<Object, Boolean> seen = new ConcurrentHashMap<>();
		return t -> seen.put(keyExtractor.apply(t),Boolean.TRUE) == null;
	}

	protected Function fromString(String expression) throws ScriptException {
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
		return (Function<Object, Object>) engine.eval(String.format("new java.util.function.Function(%s)", expression));

	}

}
