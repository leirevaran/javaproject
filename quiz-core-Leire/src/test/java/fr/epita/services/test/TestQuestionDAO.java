package fr.epita.services.test;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.epita.datamodel.Question;
import fr.epita.datamodel.MCQChoice;
import fr.epita.services.QuestionJPADAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class TestQuestionDAO {

	@Inject
	QuestionJPADAO dao;

	@Test
	@Transactional
	public void testCreation() {
		// given
		dao = new QuestionJPADAO();

		Question question = new Question();
		question.setQuestionTitle("What is Java?");
		question.setDifficulty(2);

		MCQChoice m11 = new MCQChoice("An island", false, question);
		MCQChoice m12 = new MCQChoice("A dish", true, question);
		MCQChoice m13 = new MCQChoice("A programming language", false, question);
		MCQChoice m14 = new MCQChoice("An animal", false, question);
		question.addChoice(m11);
		question.addChoice(m12);
		question.addChoice(m13);
		question.addChoice(m14);
		question.addTopic("Java");
		question.addTopic("Programming");
		question.addTopic("EPITA");

		// when
		dao.create(question);

		// todo check result

	}

}
