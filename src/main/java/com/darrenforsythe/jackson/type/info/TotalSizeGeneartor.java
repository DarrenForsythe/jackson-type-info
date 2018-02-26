package com.darrenforsythe.jackson.type.info;

import com.fasterxml.jackson.annotation.JsonTypeName;

import lombok.Data;

@JsonTypeName(value = TotalSizeGeneartor.TYPE)
@Data
public class TotalSizeGeneartor implements RowGenerator {

	public static final String TYPE = "totalSize";

	private TotalSizeConfig config;

	@Data
	public static class TotalSizeConfig implements Config {
		private long sizeInBytes;
		private int cellDensityInBytes;
		private int columns;
	}
}