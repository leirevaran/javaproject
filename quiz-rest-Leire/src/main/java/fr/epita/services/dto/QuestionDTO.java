package fr.epita.services.dto;

import java.util.List;

import fr.epita.datamodel.Question;

public class QuestionDTO {

	// ATTRIBUTES

	private Integer id;
	private String questionTitle;
	private List<MCQChoiceDTO> choices;

	// GETTERS

	public Integer getQuestionId() {
		return this.id;
	}

	public String getQuestionTitle() {
		return questionTitle;
	}

	public List<MCQChoiceDTO> getChoices() {
		return choices;
	}

	// SETTERS

	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}

	public void setChoices(List<MCQChoiceDTO> choices) {
		this.choices = choices;
	}

	public void setQuestionId(Integer questionId) {
		this.id = questionId;

	}

	// FUNCTIONS

	public Question toDataModel() {
		Question question = new Question();
		question.setQuestionId(id);
		question.setQuestionTitle(questionTitle);
		return question;
	}

	public QuestionDTO fromDataModel(Question question) {
		this.questionTitle = question.getQuestionTitle();
		this.id = question.getQuestionId();
		return this;
	}

	@Override
	public String toString() {
		return "QuestionDTO [id=" + id + ", questionTitle=" + questionTitle + "]";
	}

}