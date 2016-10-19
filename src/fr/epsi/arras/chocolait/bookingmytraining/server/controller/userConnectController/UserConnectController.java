package fr.epsi.arras.chocolait.bookingmytraining.server.controller.userConnectController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import fr.epsi.arras.chocolait.bookingmytraining.server.controller.ControllerAbstract;
import fr.epsi.arras.chocolait.bookingmytraining.server.model.userconnect.FacadeUser;

public class UserConnectController extends ControllerAbstract {
	
	private static final FacadeUser FACADE_USER = FacadeUser.getInstance();

	@Override
	public String getURI() {
		return "/UserConnect.api";
	}

	@Override
	public String getResponse(HttpServletRequest request, HttpServletResponse response) {
		Gson gson = new Gson();
		String mail = request.getParameter("mail");
		String password = request.getParameter("password");
		if (FACADE_USER.isUserExisting(mail, password)) {
			return gson.toJson(true);
		}
		return gson.toJson(false);
	}

}
