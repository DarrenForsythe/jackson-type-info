package com.darrenforsythe.jackson.type.info;

import com.fasterxml.jackson.annotation.JsonTypeName;

import lombok.Data;

@JsonTypeName(value = StandardRowGenerator.TYPE)
@Data

public class StandardRowGenerator implements RowGenerator {

	public static final String TYPE = "standard";

	private StandardConfig config;

	@Data
	public static class StandardConfig implements Config {
		private int rows;
		private int columns;
	}
}