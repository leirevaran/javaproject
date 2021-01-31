package fr.epita.datamodel;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "EXAMS")
public class Exam {

	// ATTRIBUTES

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "EID")
	private Integer examId;

	@Column(name = "ANSWERS")
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	private ArrayList<MCQAnswer> answers = new ArrayList<MCQAnswer>();

	// CONSTRUCTORS

	public Exam() {

	}

	public Exam(ArrayList<MCQAnswer> answers) {
		this.answers = answers;
	}

	// GETTERS

	public Integer getExamId() {
		return examId;
	}

	public ArrayList<MCQAnswer> getAnswers() {
		return answers;
	}

	// SETTERS

	public void setExamId(Integer examId) {
		this.examId = examId;
	}

	public void setAnswers(ArrayList<MCQAnswer> answers) {
		this.answers = answers;
	}

	// FUNCTIONS

	@Override
	public String toString() {
		return "Exam [examId=" + examId + "]";
	}

}
