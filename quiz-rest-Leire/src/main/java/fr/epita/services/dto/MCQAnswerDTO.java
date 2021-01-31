package fr.epita.services.dto;

import fr.epita.datamodel.MCQAnswer;

public class MCQAnswerDTO {

	// ATTRIBUTES

	private Integer id;
	private StudentDTO student;
	private ExamDTO exam;
	private MCQChoiceDTO choice;

	// GETTERS

	public Integer getId() {
		return id;
	}

	public StudentDTO getStudent() {
		return student;
	}

	public ExamDTO getExam() {
		return exam;
	}

	public MCQChoiceDTO getChoice() {
		return choice;
	}

	// SETTERS

	public void setId(Integer id) {
		this.id = id;
	}

	public void setStudent(StudentDTO student) {
		this.student = student;
	}

	public void setExam(ExamDTO exam) {
		this.exam = exam;
	}

	public void setChoice(MCQChoiceDTO choice) {
		this.choice = choice;
	}

	// FUNCTIONS

	public MCQAnswer toDataModel() {
		MCQAnswer ans = new MCQAnswer();
		ans.setId(id);
		return ans;
	}

	public MCQAnswerDTO fromDataModel(MCQAnswer answer) {
		this.id = answer.getAnswerId();
		return this;
	}

	@Override
	public String toString() {
		return "MCQAnswerDTO [id=" + id + "]";
	}

}
