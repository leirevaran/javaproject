package fr.epita.services;

import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;

import fr.epita.datamodel.Question;
import fr.epita.exception.CreationFailedException;

public class QuestionDAO {

	@Inject
	@Named("datasourcePGSQL")
	private DataSource ds;
	
	private MCQChoiceJPADAO choiceJPADAO;

	public QuestionDAO() {

	}

	public void create(Question question) throws CreationFailedException {
		// Connection connection = DriverManager.getConnection("jdbc://..", "username",
		// "password");
		// connection.prepareStatement(sql);
		try (Connection connection = ds.getConnection();
				PreparedStatement statement = connection.prepareStatement(
						"INSERT INTO QUESTIONS(QUES_TITLE, TOPICS, DIFFICULTY, CHOICES) VALUES (?,?,?,?) ");) {

			statement.setString(1, question.getQuestionTitle());
			statement.setArray(2, connection.createArrayOf("VARCHAR", question.getTopics()));
			statement.setInt(3, question.getDifficulty());
			choiceJPADAO.create(question.getChoices());
			statement.execute();

		} catch (SQLException sqle) {
			CreationFailedException creationFailedException = new CreationFailedException(
					"the question was not created");
			creationFailedException.initCause(sqle);
			throw creationFailedException;
		}
	}

	public void update(Question question) {

	}

	public void delete(Question question) {

	}

}
