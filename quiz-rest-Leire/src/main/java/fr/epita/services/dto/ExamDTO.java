package fr.epita.services.dto;

import java.util.List;
import fr.epita.datamodel.Exam;

public class ExamDTO {

	// ATTRIBUTES

	private int id;
	private List<MCQAnswerDTO> answers;

	// GETTERS

	public int getId() {
		return id;
	}

	public List<MCQAnswerDTO> getAnswers() {
		return answers;
	}

	// SETTERS

	public void setId(int id) {
		this.id = id;
	}

	public void setName(List<MCQAnswerDTO> answers) {
		this.answers = answers;
	}

	// FUNCTIONS

	public Exam toDataModel() {
		Exam stu = new Exam();
		stu.setExamId(this.id);
		return stu;
	}

	public ExamDTO fromDataModel(Exam exam) {
		this.id = exam.getExamId();
		return this;
	}

	@Override
	public String toString() {
		return "ExamDTO [id=" + id + "]";
	}

}
