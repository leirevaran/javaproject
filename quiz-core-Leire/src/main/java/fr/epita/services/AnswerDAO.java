package fr.epita.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;

import fr.epita.datamodel.MCQAnswer;
import fr.epita.exception.CreationFailedException;

public class AnswerDAO {
	
	@Inject
	@Named("datasourcePGSQL")
	private DataSource ds;
	
	private StudentJPADAO studentJPADAO;
	private ExamJPADAO examJPADAO;
	private MCQChoiceJPADAO choiceJPADAO;
	
	public AnswerDAO() {
		
	}
	
	public void create(ArrayList<MCQAnswer> answers) throws CreationFailedException {
		for (MCQAnswer answer : answers) {
			try (Connection connection = ds.getConnection();
					PreparedStatement statement = connection.prepareStatement(
							"INSERT INTO MCQCHOICES(STUDENT, EXAM, CHOICE) VALUES (?,?,?) ");) {

				studentJPADAO.create(answer.getStudent());
				examJPADAO.create(answer.getExam());
				choiceJPADAO.create(answer.getChoice());
				statement.execute();

			} catch (SQLException sqle) {
				CreationFailedException creationFailedException = new CreationFailedException(
						"the answer was not created");
				creationFailedException.initCause(sqle);
				throw creationFailedException;
			}
		}
	}
	
	public void update(ArrayList<MCQAnswer> answers) {

	}

	public void delete(ArrayList<MCQAnswer> answers) {

	}

}
