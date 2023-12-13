package com.dee.springboot.restapi.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class SurveyResourceTest {
	
	private static String SPECIFIC_QUESTION_URL = "/surveys/survey1/questions/question1";
		
	private static String GENERIC_QUESTION_URL = "/surveys/survey1/questions/";
	
	@Autowired
	private TestRestTemplate template;
	
	@Test
	void retrieveSurveyById_basicScenario() throws JSONException {
		
		ResponseEntity<String> responseEntity = template.getForEntity(SPECIFIC_QUESTION_URL, String.class);
		
		String expectedRespose = """
				{"id":"Question1",
				"description":"Most Popular Cloud Platform Today",
				"option":["AWS","Azure","Google Cloud","Oracle Cloud"],
				"correctAnswer":"AWS"}
				""";
		
		assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
		assertEquals("application/json", responseEntity.getHeaders().get("Content-Type").get(0));
		
		JSONAssert.assertEquals(expectedRespose, responseEntity.getBody(), true);
		
	}
	
	@Test
	void retrieveAllSurveyQuestionTest() throws JSONException, AssertionError {
		
		ResponseEntity<String> responseEntity = template.getForEntity(GENERIC_QUESTION_URL, String.class);
		
		String expectedResult = """
				[{"id":"Question1","description":"Most Popular Cloud Platform Today","option":["AWS","Azure","Google Cloud","Oracle Cloud"],"correctAnswer":"AWS"},
				{"id":"Question2","description":"Fastest Growing Cloud Platform","option":["AWS","Azure","Google Cloud","Oracle Cloud"],"correctAnswer":"Google Cloud"},
				{"id":"Question3","description":"Most Popular DevOps Tool","option":["Kubernetes","Docker","Terraform","Azure DevOps"],"correctAnswer":"Kubernetes"}]
				""";
		
		JSONAssert.assertEquals(expectedResult, responseEntity.getBody(), true);
		
	}
	
}













