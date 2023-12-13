package com.dee.springboot.restapi.survey;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;


public class JsonAssertTest {

	@Test
	void JsonAssert() throws JSONException {
		String expectedRespose = """
				{"id":"Question1",
				"description":"Most Popular Cloud Platform Today",
				"option":["AWS","Azure","Google Cloud","Oracle Cloud"],
				"correctAnswer":"AWS"}
				""";
		
		String actualResponse = """
				{"id":"Question1",
				"description":"Most Popular Cloud Platform Today",
				"option":["AWS","Azure","Google Cloud","Oracle Cloud"],
				"correctAnswer":"AWS"}
				""";
		
		JSONAssert.assertEquals(expectedRespose, actualResponse, true);
		
	}

}
