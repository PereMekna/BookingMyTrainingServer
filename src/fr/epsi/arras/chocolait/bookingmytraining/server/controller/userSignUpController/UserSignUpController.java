package fr.epsi.arras.chocolait.bookingmytraining.server.controller.userSignUpController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;

import com.google.gson.Gson;

import fr.epsi.arras.chocolait.bookingmytraining.server.controller.ControllerAbstract;
import fr.epsi.arras.chocolait.bookingmytraining.server.model.Employee;
import fr.epsi.arras.chocolait.bookingmytraining.server.model.Trainee;
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
		Gson gson = new Gson();
		if (null != request.getParameter("mail") && null != request.getParameter("password")
				&& null != request.getParameter("name") && null != request.getParameter("surname")) {
			String mail = request.getParameter("mail");
			String password = request.getParameter("password");
			UserConnect userConnect = new UserConnect();
			userConnect.setMail(mail);
			userConnect.setHashpwd(DigestUtils.sha1Hex(password));
			FACADE_USER.signUpUserConnect(userConnect);
			if ("true".equals(request.getParameter("isTrainee"))) {
				Trainee trainee = new Trainee();
				trainee.setName(request.getParameter("name"));
				trainee.setSurname(request.getParameter("surname"));
				trainee.setCv(request.getParameter("cv"));
				trainee.setIduserconnect(userConnect.getIduserconnect());
				FACADE_USER.signUpTrainee(trainee);
				return gson.toJson(trainee);
			}
			if ("true".equals(request.getParameter("isEmployee"))) {
				Employee employee = new Employee();
				employee.setName(request.getParameter("name"));
				employee.setSurname(request.getParameter("surname"));
				employee.setStatus(request.getParameter("status"));
				employee.setIduserconnect(userConnect.getIduserconnect());
				FACADE_USER.signUpEmployee(employee);
				return gson.toJson(employee);
			}

			return gson.toJson(userConnect);
		}
		return gson.toJson(false);

	}

}
