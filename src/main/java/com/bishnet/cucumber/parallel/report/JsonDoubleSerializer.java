package com.bishnet.cucumber.parallel.report;

import gherkin.deps.com.google.gson.JsonElement;
import gherkin.deps.com.google.gson.JsonPrimitive;
import gherkin.deps.com.google.gson.JsonSerializationContext;
import gherkin.deps.com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

public class JsonDoubleSerializer implements JsonSerializer<Double> {

	@Override
	public JsonElement serialize(Double src, Type typeOfSrc, JsonSerializationContext context) {
		if (src == src.longValue())
			return new JsonPrimitive(src.longValue());
		return new JsonPrimitive(src);
	}
}
