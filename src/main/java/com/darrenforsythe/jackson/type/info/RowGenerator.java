package com.darrenforsythe.jackson.type.info;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

@JsonTypeInfo(use = Id.NAME, include = As.PROPERTY, property = RowGenerator.PROPERTY, defaultImpl = StandardRowGenerator.class)
@JsonSubTypes(value = { @Type(StandardRowGenerator.class), @Type(TotalSizeGeneartor.class) })
@JsonRootName(value = "data")
public abstract interface RowGenerator {

	public static final String PROPERTY = "type";

	Config getConfig();
}
