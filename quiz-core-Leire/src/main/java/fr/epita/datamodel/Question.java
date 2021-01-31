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
@Table(name = "QUESTIONS")
public class Question {

	// ATTRIBUTES

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "QID")
	private Integer questionId;

	@Column(name = "QUES_TITLE")
	private String questionTitle;

	@Column(name = "TOPICS")
	private String[] topics;

	@Column(name = "DIFFICULTY")
	private Integer difficulty;

	@Column(name = "CHOICES")
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	private ArrayList<MCQChoice> choices; // 4 MAX

	// CONSTRUCTORS

	public Question() {

	}

	public Question(String questionTitle, Integer difficulty) {
		this.questionTitle = questionTitle;
		this.topics = new String[0];
		this.difficulty = difficulty;
		this.choices = new ArrayList<MCQChoice>();
	}

	public Question(String questionTitle, Integer difficulty, String[] topics) {
		this.questionTitle = questionTitle;
		this.topics = topics;
		this.difficulty = difficulty;
		this.choices = new ArrayList<MCQChoice>();
	}

	public Question(String questionTitle, String[] topics, Integer difficulty, ArrayList<MCQChoice> choices) {
		this.questionTitle = questionTitle;
		this.topics = topics;
		this.difficulty = difficulty;
		this.choices = choices;
	}

	// GETTERS

	public Integer getQuestionId() {
		return questionId;
	}

	public String getQuestionTitle() {
		return questionTitle;
	}

	public String[] getTopics() {
		return topics;
	}

	public Integer getDifficulty() {
		return difficulty;
	}

	public ArrayList<MCQChoice> getChoices() {
		return choices;
	}

	public MCQChoice getChoice(int i) {
		return choices.get(i);
	}

	// SETTERS

	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}

	public void setTopics(String[] topics) {
		this.topics = topics;
	}

	public void setDifficulty(Integer difficulty) {
		this.difficulty = difficulty;
	}

	public void setChoices(ArrayList<MCQChoice> choices) {
		this.choices = choices;
	}

	// FUNCTIONS

	public void addTopic(String t) {

		boolean b = true;
		String[] aux = new String[topics.length + 1];
		int i;

		if (topics.length < 4) {

			for (i = 0; i < topics.length; i++) {

				if (topics[i] == t) {
					b = false;
					i = topics.length;
				} else {
					aux[i] = topics[i];
				}

			}

			if (b) {

				aux[i] = t;
				setTopics(aux);

			}

		}

		// Not added

	}

	public void addChoiceCreate(String c, boolean b) {

		MCQChoice m = new MCQChoice(c, b, this);
		addChoice(m);

	}

	public void addChoice(MCQChoice m) {

		boolean b = true;

		if (choices.size() < 4) {

			for (int i = 0; i < choices.size(); i++) {

				if (choices.get(i).equals(m)) {
					b = false;
				}

			}

			if (b) {

				choices.add(m);

			}

		}

		// Not added

	}

	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", questionTitle=" + questionTitle + ", difficulty=" + difficulty
				+ "]";
	}

	public MCQChoice getAnswer() {

		for (int i = 0; i < choices.size(); i++) {

			if (choices.get(i).getIsValid()) {

				return choices.get(i);

			}

		}

		return null;

	}

	public Integer getAnswerIndex() {

		for (int i = 0; i < choices.size(); i++) {

			if (choices.get(i).getIsValid()) {

				return i;

			}

		}

		return -1;

	}

}
