package fr.epita.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import fr.epita.datamodel.MCQChoice;
import fr.epita.datamodel.Question;
import fr.epita.exception.CreationFailedException;
import fr.epita.services.dto.MCQChoiceDTO;
import fr.epita.services.dto.QuestionDTO;

public class QuizCreationDataService {

	@Inject
	MCQChoiceJPADAO mcqChoiceDAO;

	@Inject
	QuestionJPADAO questionDAO;

	@PersistenceContext
	EntityManager em;

	/**
	 * this method is transactional
	 * 
	 * @param question
	 * @param choices
	 * @throws CreationFailedException
	 */
	@Transactional(value = TxType.REQUIRED)
	public void createMCQQuestion(QuestionDTO dto) throws CreationFailedException {

		Question dataModel = dto.toDataModel();
		List<MCQChoiceDTO> DTOChoices = dto.getChoices();
		List<MCQChoice> choices = DTOChoices.stream().map(MCQChoiceDTO::toDataModel).collect(Collectors.toList());

		questionDAO.create(dataModel);
		for (MCQChoice choice : choices) {
			choice.setQuestion(dataModel);
			mcqChoiceDAO.create(choice);
		}
		dto.setQuestionId(dataModel.getQuestionId()); //?
	}

	public QuestionDTO getById(String questionId) {
		QuestionDTO dto = new QuestionDTO();
		MCQChoice mcqChoiceCriteria = new MCQChoice();
		Question mcqQuestionCriteria = new Question();
		mcqQuestionCriteria.setQuestionId(Integer.valueOf(questionId));
		mcqChoiceCriteria.setQuestion(mcqQuestionCriteria);

		List<MCQChoice> choices = mcqChoiceDAO.search(mcqChoiceCriteria);
		Question question = choices.get(0).getQuestion();

		dto.fromDataModel(question);
		List<MCQChoiceDTO> choicesDTO = choices.stream().map(choice -> {
			MCQChoiceDTO mcqChoiceDTO = new MCQChoiceDTO();
			mcqChoiceDTO.fromDataModel(choice);
			return mcqChoiceDTO;
		}).collect(Collectors.toList());

		dto.setChoices(choicesDTO);
		return dto;

	}
}
