package fr.epita.services;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.epita.datamodel.MCQAnswer;

public class AnswerJPADAO {
	
	@PersistenceContext
	EntityManager em;

	public void create(MCQAnswer answer) {
		em.persist(answer);
	}
	
	public void update(MCQAnswer answer) {
		em.merge(answer);
	}

	public void delete(MCQAnswer answer) {
		em.remove(answer);
	}

}
