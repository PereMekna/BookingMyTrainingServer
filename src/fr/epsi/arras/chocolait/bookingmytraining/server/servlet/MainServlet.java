package fr.epsi.arras.chocolait.bookingmytraining.server.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.epsi.arras.chocolait.bookingmytraining.server.controller.ControllerAbstract;
import fr.epsi.arras.chocolait.bookingmytraining.server.controller.helloworld.HelloWorldController;
import fr.epsi.arras.chocolait.bookingmytraining.server.controller.internshipOfferController.InternshipOfferController;
import fr.epsi.arras.chocolait.bookingmytraining.server.controller.userConnectController.UserConnectController;
import fr.epsi.arras.chocolait.bookingmytraining.server.controller.userSignUpController.UserSignUpController;
import fr.epsi.arras.chocolait.bookingmytraining.server.model.InternshipOffer;

/**
 * Servlet implementation class MainServlet
 */
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static List<ControllerAbstract> listController;

	@Override
	public void init() throws ServletException {
		listController = new ArrayList<ControllerAbstract>();
		listController.add(new HelloWorldController());
		listController.add(new UserConnectController());
		listController.add(new UserSignUpController());
		listController.add(new InternshipOfferController());
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MainServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(final HttpServletRequest request, final HttpServletResponse response)
			throws ServletException, IOException {
		for (final ControllerAbstract controller : listController) {
			if ((request.getContextPath() + controller.getURI()).equals(request.getRequestURI())) {
				response.setContentType("application/json");
				PrintWriter out = response.getWriter();

				out.println(controller.getResponse(request, response));
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
