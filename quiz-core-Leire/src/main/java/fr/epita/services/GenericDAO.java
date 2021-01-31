package fr.epita.services;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.epita.exception.CreationFailedException;

public abstract class GenericDAO<T> {

	@PersistenceContext
	private EntityManager em;

	public void create(T o) throws CreationFailedException {
		em.persist(o);
	}

	public void update(T o) {
		em.merge(o);
	}

	public void delete(T o) {
		em.remove(o);
	}

	public List<T> search(T criteria) {
		Query query = em.createQuery(getQueryString());

		Map<String, Object> params = getParams(criteria);
		for (Map.Entry<String, Object> param : params.entrySet()) {
			query.setParameter(param.getKey(), param.getValue());
		}

		@SuppressWarnings("unchecked")
		List<T> resultList = query.getResultList();
		return resultList;

	}

	public List<T> search(T criteria, Function<T, Map<String, Object>> getParamsFunction, String queryString) {
		Query query = em.createQuery(queryString);

		Map<String, Object> params = getParamsFunction.apply(criteria);
		for (Map.Entry<String, Object> param : params.entrySet()) {
			query.setParameter(param.getKey(), param.getValue());
		}

		@SuppressWarnings("unchecked")
		List<T> resultList = query.getResultList();
		return resultList;

	}

	protected abstract Map<String, Object> getParams(T criteria);

	protected abstract String getQueryString();

}
