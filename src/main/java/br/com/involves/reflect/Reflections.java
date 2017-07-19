package br.com.involves.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import br.com.involves.model.Propriedade;

public class Reflections {

	
	public static <T> T newInstance(Class<?> clazz) throws ReflectExceptions {
		try {
			Type sooper = clazz.getGenericSuperclass();
			Type t = ((ParameterizedType) sooper).getActualTypeArguments()[0];
			return (T) Class.forName(t.getTypeName()).newInstance();
		} catch (Exception e) {
			throw new ReflectExceptions(e.getMessage(), e);
		}
	}

	public static  <T> void setValue(T t, String data, String coluna) throws ReflectExceptions {
		for (Field field : t.getClass().getDeclaredFields()) {
			field.setAccessible(true);
			if (field.isAnnotationPresent(Propriedade.class)) {
				Propriedade anotacao = field.getAnnotation(Propriedade.class);
				if (anotacao.name().equals(coluna)) {
					try {
						field.set(t, data);
					} catch (IllegalAccessException | IllegalArgumentException e) {
						throw new ReflectExceptions(e.getMessage(), e);
					}
				}
			}
		}
	}
	
	public static  <T> Object getValue(T t, String coluna) throws ReflectExceptions {
		for (Field field : t.getClass().getDeclaredFields()) {
			field.setAccessible(true);
			if (field.isAnnotationPresent(Propriedade.class)) {
				Propriedade anotacao = field.getAnnotation(Propriedade.class);
				if (anotacao.name().equals(coluna)) {
					try {
						return field.get(t);
					} catch (IllegalAccessException | IllegalArgumentException e) {
						throw new ReflectExceptions(e.getMessage(), e);
					}
				}
			}
		}
		return null;
	}
	
	public static  <T> String getMethod(T t, String coluna) throws ReflectExceptions {
		for (Field field : t.getClass().getDeclaredFields()) {
			field.setAccessible(true);
			if (field.isAnnotationPresent(Propriedade.class)) {
				Propriedade anotacao = field.getAnnotation(Propriedade.class);
				if (anotacao.name().equals(coluna)) {
					try {
						String fieldName = field.getName();
						String name = "get".concat(fieldName.substring(0,1).toUpperCase());
						name = name.concat(fieldName.substring(1, fieldName.length()));
						return name;
					} catch (IllegalArgumentException e) {
						throw new ReflectExceptions(e.getMessage(), e);
					}  catch (SecurityException e) {
						throw new ReflectExceptions(e.getMessage(), e);
					}
				}
			}
		}
		return null;
	}
	
	
}
