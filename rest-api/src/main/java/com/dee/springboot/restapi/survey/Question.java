package com.dee.springboot.restapi.survey;

import java.util.List;

public class Question {
	
	private String id;
	private String description;
	private List<String> option;
	private String correctAnswer;
	
	public Question(String id, String description, List<String> option, String correctAnswer) {
		super();
		this.id = id;
		this.description = description;
		this.option = option;
		this.correctAnswer = correctAnswer;
	}
	
	public Question() {
		
	}

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public List<String> getOption() {
		return option;
	}

	public String getCorrectAnswer() {
		return correctAnswer;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", description=" + description + ", option=" + option + ", correctAnswer="
				+ correctAnswer + "]";
	}

	
}
