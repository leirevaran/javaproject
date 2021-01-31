package fr.epita.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;

import fr.epita.datamodel.Student;
import fr.epita.exception.CreationFailedException;

public class StudentJPADAO {
	
	@Inject
	@Named("datasourcePGSQL")
	private DataSource ds;
	
	public void create(Student student) throws CreationFailedException {
			try (Connection connection = ds.getConnection();
					PreparedStatement statement = connection.prepareStatement(
							"INSERT INTO STUDENTS(STUDENT_NAME, STUDENT_EMAIL, SCORE) VALUES (?,?,?) ");) {

				statement.setString(1, student.getName());
				statement.setString(2, student.getEmail());
				statement.setInt(3, student.getScore());
				statement.execute();

			} catch (SQLException sqle) {
				CreationFailedException creationFailedException = new CreationFailedException(
						"the student was not created");
				creationFailedException.initCause(sqle);
				throw creationFailedException;
			}
	}
	
	public void update(Student student) {
	}

	public void delete(Student student) {
	}

}
