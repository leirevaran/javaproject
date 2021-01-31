package fr.epita.datamodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "MCQANSWERS")
public class MCQAnswer {

	// ATTRIBUTES

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "AID")
	private Integer answerId;

	@Column(name = "STUDENT")
	@ManyToOne
	private Student student;

	@Column(name = "EXAM")
	@ManyToOne
	private Exam exam;

	@Column(name = "CHOICE")
	@ManyToOne
	private MCQChoice choice;

	// CONSTRUCTORS

	public MCQAnswer() {

	}

	public MCQAnswer(Student student) {
		this.student = student;
	}

	public MCQAnswer(Exam exam) {
		this.exam = exam;
	}

	public MCQAnswer(MCQChoice choice) {
		this.choice = choice;
	}

	public MCQAnswer(Student student, Exam exam) {
		this.student = student;
		this.exam = exam;
	}

	public MCQAnswer(Student student, MCQChoice choice) {
		this.student = student;
		this.choice = choice;
	}

	public MCQAnswer(Exam exam, MCQChoice choice) {
		this.exam = exam;
		this.choice = choice;
	}

	public MCQAnswer(Student student, Exam exam, MCQChoice choice) {
		this.student = student;
		this.exam = exam;
		this.choice = choice;
	}

	// GETTERS

	public Integer getAnswerId() {
		return answerId;
	}

	public Student getStudent() {
		return student;
	}

	public Exam getExam() {
		return exam;
	}

	public MCQChoice getChoice() {
		return choice;
	}

	// SETTERS

	public void setId(Integer answerId) {
		this.answerId = answerId;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

	public void setChoice(MCQChoice choice) {
		this.choice = choice;
	}

	// FUNCTIONS

	@Override
	public String toString() {
		return "MCQAnswer [answerId=" + answerId + ", student=" + getStudent().getName() + ", choice="
				+ getChoice().getChoice() + "]";
	}

}
