package fr.epsi.arras.chocolait.bookingmytraining.server.controller.tinderforcompany;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import fr.epsi.arras.chocolait.bookingmytraining.server.controller.ControllerAbstract;
import fr.epsi.arras.chocolait.bookingmytraining.server.model.userconnect.FacadeUser;

public class TraineeController extends ControllerAbstract {
	
	private static final FacadeUser SERVICE_USER = FacadeUser.getInstance();
	
	@Override
	public String getURI() {
		return "/Trainee.api";
	}

	@Override
	public String getResponse(final HttpServletRequest request, final HttpServletResponse response) {
		Gson gson = new Gson();
		final String idTrainee = request.getParameter("idTrainee");
		if (idTrainee != null) {
			return gson.toJson(SERVICE_USER.getTraineeById(Integer.parseInt(idTrainee)));
		}
		return gson.toJson(SERVICE_USER.getAllTrainees());
	}
	
}
