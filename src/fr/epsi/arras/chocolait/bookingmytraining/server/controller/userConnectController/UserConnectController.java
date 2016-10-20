package fr.epsi.arras.chocolait.bookingmytraining.server.controller.userConnectController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;

import com.google.gson.Gson;

import fr.epsi.arras.chocolait.bookingmytraining.server.controller.ControllerAbstract;
import fr.epsi.arras.chocolait.bookingmytraining.server.model.UserConnect;
import fr.epsi.arras.chocolait.bookingmytraining.server.model.userconnect.FacadeUser;

public class UserConnectController extends ControllerAbstract {
	
	private static final FacadeUser FACADE_USER = FacadeUser.getInstance();

	@Override
	public String getURI() {
		return "/UserConnect.api";
	}

	@Override
	public String getResponse(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		Gson gson = new Gson();
		final String mail = request.getParameter("mail");
		final String password = request.getParameter("password");
		final UserConnect userConnect = (UserConnect) session.getAttribute("userConnect");
		if (userConnect != null) {
			return gson.toJson(userConnect);
		}
		if (mail != null && password != null) {
			if (FACADE_USER.isUserExisting(mail, DigestUtils.sha1Hex(password))) {
				final UserConnect userConnectCreate = FACADE_USER.getUserConnectByMail(mail);
				session.setAttribute("userConnect", userConnectCreate);
				return gson.toJson(userConnectCreate);
			}
		}
		return gson.toJson(false);
	}

}
