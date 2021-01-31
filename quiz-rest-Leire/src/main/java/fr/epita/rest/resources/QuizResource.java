package fr.epita.rest.resources;

import java.net.URI;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import fr.epita.exception.CreationFailedException;
import fr.epita.services.QuizCreationDataService;
import fr.epita.services.dto.QuestionDTO;

@Path("/quizzes")
public class QuizResource {

	@Inject
	QuizCreationDataService service;

	@POST
	@Path("/{id}/questions")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createQuestionForQuiz(@PathParam("id") String id, QuestionDTO dto) {
		if (dto == null) {
			return Response.status(400, "no question was provided").entity("bad request").build();
		}

		try {
			service.createMCQQuestion(dto);
		} catch (CreationFailedException cfe) {
			return Response.notModified().build();
		}

		return Response.created(URI.create(String.valueOf("quiz/" + id + "/question/" + dto.getQuestionId()))).build();
	}

	@GET
	@Path("/questions/{questionId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getQuestion(@PathParam("questionId") String questionId) {
		System.out.println(questionId);
		QuestionDTO dto = service.getById(questionId);
		return Response.ok().entity(dto).build();
	}

}
