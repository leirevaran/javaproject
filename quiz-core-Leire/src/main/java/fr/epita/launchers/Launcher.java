package fr.epita.launchers;

import fr.epita.datamodel.MCQChoice;
import fr.epita.datamodel.Question;
import fr.epita.exception.CreationFailedException;
import fr.epita.services.QuestionDAO;

public class Launcher {

	public static void main(String[] args) {

		QuestionDAO dao = new QuestionDAO();
		initializeDB(dao);

		System.out.println("hello");
	}

	private static void initializeDB(QuestionDAO dao) {

		String isl = "An island";
		String dish = "A dish";
		String animal = "An animal";
		String prog = "Programming";
		String tool = "An automation and management tool";
		String java = "Java";
		String epita = "EPITA";
		String code = "Code";
		String fre = "French";
		String geo = "Geography";

		Question q1 = new Question("What is Java?", 2);
		MCQChoice m11 = new MCQChoice(isl, false, q1);
		MCQChoice m12 = new MCQChoice(dish, false, q1);
		MCQChoice m13 = new MCQChoice("A programming language", true, q1);
		MCQChoice m14 = new MCQChoice(animal, false, q1);
		q1.addChoice(m11);
		q1.addChoice(m12);
		q1.addChoice(m13);
		q1.addChoice(m14);
		q1.addTopic(java);
		q1.addTopic(prog);
		q1.addTopic(epita);

		Question q2 = new Question("What is DAO?", 5);
		q2.addChoiceCreate(isl, false);
		q2.addChoiceCreate("Data Access Object", true);
		q2.addChoiceCreate("Data Atribute Object", false);
		q2.addChoiceCreate("Duck Access Object", false);
		q2.addTopic(java);
		q2.addTopic(prog);
		q2.addTopic(code);

		Question q3 = new Question("What is Maven?", 7);
		q3.addChoiceCreate(isl, false);
		q3.addChoiceCreate(tool, true);
		q3.addChoiceCreate(dish, false);
		q3.addChoiceCreate(animal, false);
		q3.addTopic(java);
		q3.addTopic(prog);
		q3.addTopic(code);

		Question q4 = new Question("What is Spring?", 7);
		q4.addChoiceCreate(isl, false);
		q4.addChoiceCreate(tool, true);
		q4.addChoiceCreate(dish, false);
		q4.addChoiceCreate(animal, false);
		q4.addTopic(java);
		q4.addTopic(prog);
		q4.addTopic(code);

		Question q5 = new Question("What is Le Mont Saint Michelle?", 8);
		q5.addChoiceCreate(isl, true);
		q5.addChoiceCreate(tool, false);
		q5.addChoiceCreate(dish, false);
		q5.addChoiceCreate(animal, false);
		q5.addTopic("France");
		q5.addTopic(geo);
		q5.addTopic("Normandie");

		Question q6 = new Question("What is ratatouille?", 6);
		q6.addChoiceCreate(isl, false);
		q6.addChoiceCreate(tool, false);
		q6.addChoiceCreate(dish, true);
		q6.addChoiceCreate(animal, false);
		q6.addTopic("Gastronomy");
		q6.addTopic("Healthy");
		q6.addTopic("Food");

		Question q7 = new Question("What is JPADAO?", 5);
		MCQChoice m71 = new MCQChoice(isl, false, q7);
		MCQChoice m72 = new MCQChoice("Java Persistence API DAO", true, q7);
		MCQChoice m73 = new MCQChoice(animal, false, q7);
		q7.addChoice(m71);
		q7.addChoice(m72);
		q7.addChoice(m73);
		q7.addChoiceCreate("d", false);
		q7.addTopic(java);
		q7.addTopic(prog);
		q7.addTopic(epita);

		Question q8 = new Question("What is a lapin?", 4);
		q8.addChoiceCreate(isl, false);
		q8.addChoiceCreate(tool, false);
		q8.addChoiceCreate(dish, false);
		q8.addChoiceCreate(animal, true);
		q8.addTopic(fre);
		q8.addTopic("Vocabulary");
		q8.addTopic("Animals");

		Question q9 = new Question("Paris is the capital of...", 1);
		q9.addChoiceCreate("Spain", false);
		q9.addChoiceCreate("Belgium", false);
		q9.addChoiceCreate("Luxemburg", false);
		q9.addChoiceCreate("France", true);
		q9.addTopic(fre);
		q9.addTopic(geo);
		q9.addTopic("Capitals");

		Question q10 = new Question("Which of the following is a french movie?", 9);
		q10.addChoiceCreate("Amelie", false);
		q10.addChoiceCreate("Intouchables", false);
		q10.addChoiceCreate("Les Choristes", false);
		q10.addChoiceCreate("All the above are correct", true);
		q9.addTopic(fre);
		q9.addTopic("Cinema");
		q9.addTopic("Movies");

		// Hay que hacer los persist
		try {

			dao.create(q1);
			dao.create(q2);
			dao.create(q3);
			dao.create(q4);
			dao.create(q5);
			dao.create(q6);
			dao.create(q7);
			dao.create(q8);
			dao.create(q9);
			dao.create(q10);

		} catch (CreationFailedException e) {
			e.printStackTrace();
		}

	}

}
