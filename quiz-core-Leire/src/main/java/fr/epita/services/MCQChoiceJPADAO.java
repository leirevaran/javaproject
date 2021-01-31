package fr.epita.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;

import fr.epita.datamodel.MCQChoice;
import fr.epita.exception.CreationFailedException;

public class MCQChoiceJPADAO extends GenericDAO<MCQChoice> {

	@Inject
	@Named("datasourcePGSQL")
	private DataSource ds;
	
	private QuestionDAO questionDAO;

	@Override
	protected Map<String, Object> getParams(MCQChoice criteria) {
		Map<String, Object> parameters = new HashMap<String, Object>();

		parameters.put("question", criteria.getQuestion());
		parameters.put("valid", criteria.getIsValid());
		return parameters;
	}

	@Override
	protected String getQueryString() {
		return "from MCQChoice where (:valid is not null and valid=:valid) and question=:question";
	}

	public List<MCQChoice> specificSearch(MCQChoice criteria) {
		Function<MCQChoice, Map<String, Object>> getParamsFunction = choice -> {
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("question", criteria.getQuestion());
			parameters.put("valid", criteria.getIsValid());
			return parameters;
		};
		return super.search(criteria, getParamsFunction, "from MCQChoice where valid=:valid and question=:question");

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<MCQChoice> searchAll() {

		return super.search(null, choice -> new HashMap(), "FROM MCQChoice");

	}

	// create function?
	public void create(ArrayList<MCQChoice> choices) throws CreationFailedException {
		for (MCQChoice choice : choices) {

			try (Connection connection = ds.getConnection();
					PreparedStatement statement = connection.prepareStatement(
							"INSERT INTO MCQCHOICES(CHOICE, ISVALID, QUESTION) VALUES (?,?,?) ");) {

				statement.setString(1, choice.getChoice());
				statement.setBoolean(2, choice.getIsValid());
				questionDAO.create(choice.getQuestion());
				statement.execute();

			} catch (SQLException sqle) {
				CreationFailedException creationFailedException = new CreationFailedException(
						"the choice was not created");
				creationFailedException.initCause(sqle);
				throw creationFailedException;
			}
		}
	}

}
