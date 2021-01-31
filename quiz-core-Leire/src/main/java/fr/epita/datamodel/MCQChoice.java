package fr.epita.datamodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "MCQCHOICES")
public class MCQChoice {

	// ATTRIBUTES

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CID")
	private Integer id;

	@Column(name = "CHOICE")
	private String choice;

	@Column(name = "ISVALID")
	private boolean isValid;

	@Column(name = "QUESTION")
	@ManyToOne
	private Question question;

	// CONSTRUCTORS

	public MCQChoice() {

	}

	public MCQChoice(String choice, boolean isValid) {
		this.choice = choice;
		this.isValid = isValid;
	}

	public MCQChoice(String choice, boolean isValid, Question question) {
		this.choice = choice;
		this.isValid = isValid;
		this.question = question;
	}

	// GETTERS

	public int getId() {
		return id;
	}

	public String getChoice() {
		return choice;
	}

	public boolean getIsValid() {
		return isValid;
	}

	public Question getQuestion() {
		return question;
	}

	// SETTERS

	public void setId(Integer id) {
		this.id = id;
	}

	public void setChoice(String choice) {
		this.choice = choice;
	}

	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	// FUNCTIONS

	@Override
	public String toString() {
		return "MCQChoice [id=" + id + ", choice=" + choice + ", valid=" + isValid + ", question=" + question + "]";
	}

}
