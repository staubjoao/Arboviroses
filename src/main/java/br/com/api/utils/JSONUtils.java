package br.com.api.utils;
import java.io.IOException;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.List;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONUtils {
    
    private static final ObjectMapper objectMapper = new ObjectMapper();
	
	static{
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		objectMapper.setDateFormat(new SimpleDateFormat("dd/MM/yyyy"));
	}

	public static String objectToJson(Object obj) {
		try {
			return objectMapper.writeValueAsString(obj);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static <T> T jsonToObject(String content, Class<T> value) {
		try {
			return objectMapper.readValue(content, value);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static <T> List<T> jsonArrayToObject(String content, Class<T> value) {
		try {
			return objectMapper.readValue(content, objectMapper.getTypeFactory().constructCollectionType(List.class, value));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static <T, E> T jsonToObjectWithGenericTypeArgument(String content, Class<T> value, String property, Class<E> genericClass) {
		try {
			JsonNode jsonNode = jsonToObject(content, JsonNode.class);
			T result = jsonToObject(jsonNode.toString(), value);

			if (jsonNode.get(property).isArray()) {
				List<E> list = jsonArrayToObject(jsonNode.get(property).toString(), genericClass);
				Field field = result.getClass().getDeclaredField(property);
				field.setAccessible(true);
				field.set(result, list);
			} else {
				E object = jsonToObject(jsonNode.get(property).toString(), genericClass);
				Field field = result.getClass().getDeclaredField(property);
				field.setAccessible(true);
				field.set(result, object);
			}
			
			return (T) result;
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}
		return null;
	}
}
