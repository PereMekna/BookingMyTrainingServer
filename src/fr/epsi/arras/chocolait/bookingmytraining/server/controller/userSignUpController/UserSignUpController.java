package fr.epsi.arras.chocolait.bookingmytraining.server.controller.userSignUpController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;

import com.google.gson.Gson;

import fr.epsi.arras.chocolait.bookingmytraining.server.controller.ControllerAbstract;
import fr.epsi.arras.chocolait.bookingmytraining.server.model.UserConnect;
import fr.epsi.arras.chocolait.bookingmytraining.server.model.userconnect.FacadeUser;

public class UserSignUpController extends ControllerAbstract {
	
	private static final FacadeUser FACADE_USER = FacadeUser.getInstance();

	@Override
	public String getURI() {
		return "/UserSignUp.api";
	}

	@Override
	public String getResponse(HttpServletRequest request, HttpServletResponse response) {
		if (null != request.getParameter("mail") && null != request.getParameter("password")) {
			Gson gson = new Gson();
			String mail = request.getParameter("mail");
			String password = request.getParameter("password");
			UserConnect userConnect = new UserConnect();
			userConnect.setMail(mail);
			userConnect.setHashpwd(DigestUtils.sha1Hex(password));
			FACADE_USER.signUpTrainee(userConnect);
			
			
			return gson.toJson(userConnect);
		}
		return "OLIVIER";

	}

}
