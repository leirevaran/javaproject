package fr.epita.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;

import fr.epita.datamodel.Exam;
import fr.epita.exception.CreationFailedException;

public class ExamJPADAO {
	
	@Inject
	@Named("datasourcePGSQL")
	private DataSource ds;
	
	private AnswerDAO answerDAO;
	
	public void create(Exam exam) throws CreationFailedException {
			try (Connection connection = ds.getConnection();
					PreparedStatement statement = connection.prepareStatement(
							"INSERT INTO EXAMS(ANSWERS) VALUES (?) ");) {

				answerDAO.create(exam.getAnswers());
				statement.execute();

			} catch (SQLException sqle) {
				CreationFailedException creationFailedException = new CreationFailedException(
						"the exam was not created");
				creationFailedException.initCause(sqle);
				throw creationFailedException;
			}
	}
	
	public void update(Exam exam) {

	}

	public void delete(Exam exam) {

	}

}
