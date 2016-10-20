package fr.epsi.arras.chocolait.bookingmytraining.server.model.userconnect;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import fr.epsi.arras.chocolait.bookingmytraining.server.controller.ControllerAbstract;
import fr.epsi.arras.chocolait.bookingmytraining.server.model.UserConnect;

public class UserUtilController extends ControllerAbstract {
	
	private static final FacadeUser FACADE_USER = FacadeUser.getInstance();

	@Override
	public String getURI() {
		return "/UserUtil.api";
	}

	@Override
	public String getResponse(HttpServletRequest request, HttpServletResponse response) {
		Gson gson = new Gson();
		UserConnect userConnect;
		final String idUserConnect = request.getParameter("isEmployee");
		final String idTrainee = request.getParameter("isTrainee");
		if (idUserConnect != null) {
			userConnect = FACADE_USER.getUserConnectById(Integer.parseInt(idUserConnect));
			if (userConnect != null) {
				return gson.toJson(FACADE_USER.isEmployee(userConnect));
			}
			return gson.toJson(false);
		}
		if (idTrainee != null) {
			userConnect = FACADE_USER.getUserConnectById(Integer.parseInt(idTrainee));
			if (userConnect != null) {
				return gson.toJson(FACADE_USER.isTrainee(userConnect));
			}
			return gson.toJson(false);
		}
		return gson.toJson(false);
	}

}
