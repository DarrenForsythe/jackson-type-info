package com.darrenforsythe.jackson.type.info;

import static org.assertj.core.api.Assertions.assertThat;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;

import com.darrenforsythe.jackson.type.info.StandardRowGenerator.StandardConfig;
import com.darrenforsythe.jackson.type.info.TotalSizeGeneartor.TotalSizeConfig;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import lombok.extern.slf4j.Slf4j;

public class JacksonTest {

	private ObjectMapper mapper;
	private String json;

	@Before
	public void setup() throws Exception {
		mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, true);
		mapper.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true);
	}

	@Test
	public void testDeserStandard() throws Exception {
		json = StringUtils.deleteWhitespace(
				new String(Files.readAllBytes(Paths.get("src/main/resources/standard.json")), StandardCharsets.UTF_8));

		RowGenerator generator = mapper.readValue(json, RowGenerator.class);
		assertThat(generator).hasNoNullFieldsOrProperties().isExactlyInstanceOf(StandardRowGenerator.class);
		assertThat(generator.getConfig()).hasNoNullFieldsOrProperties().isExactlyInstanceOf(StandardConfig.class);
		assertThat(json).isEqualTo(mapper.writeValueAsString(generator));
		System.out.println(generator);
	}

	@Test
	public void testDeserTotalsize() throws Exception {
		json = StringUtils.deleteWhitespace(
				new String(Files.readAllBytes(Paths.get("src/main/resources/totalsize.json")), StandardCharsets.UTF_8));

		RowGenerator generator = mapper.readValue(json, RowGenerator.class);
		assertThat(generator).hasNoNullFieldsOrProperties().isExactlyInstanceOf(TotalSizeGeneartor.class);
		assertThat(generator.getConfig()).hasNoNullFieldsOrProperties().isExactlyInstanceOf(TotalSizeConfig.class);
		assertThat(json).isEqualTo(mapper.writeValueAsString(generator));
		System.out.println(generator);

	}

}
