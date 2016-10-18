package fr.epsi.arras.chocolait.bookingmytraining.server.controller.helloworld;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import fr.epsi.arras.chocolait.bookingmytraining.server.controller.ControllerAbstract;
import fr.epsi.arras.chocolait.bookingmytraining.server.model.helloworld.HelloWorldFacade;

public class HelloWorldController extends ControllerAbstract {
	
	private HelloWorldFacade helloWorldFacade = new HelloWorldFacade();
	
	@Override
	public String getURI() {
		return "/BookingMyTraining/HelloWorld.api";
	}

	@Override
	public String getResponse(final HttpServletRequest request, final HttpServletResponse response) {
		final String id = request.getParameter("id");
		Gson gson = new Gson();
		if (null != id) {
			return gson.toJson(helloWorldFacade.getNewHelloWorld());
		}
		return gson.toJson(helloWorldFacade.getAllHelloWorld());
	}

}
