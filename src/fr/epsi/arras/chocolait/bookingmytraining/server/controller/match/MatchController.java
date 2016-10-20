package fr.epsi.arras.chocolait.bookingmytraining.server.controller.match;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import fr.epsi.arras.chocolait.bookingmytraining.server.controller.ControllerAbstract;
import fr.epsi.arras.chocolait.bookingmytraining.server.model.Match;
import fr.epsi.arras.chocolait.bookingmytraining.server.model.MatchPK;
import fr.epsi.arras.chocolait.bookingmytraining.server.model.internshipoffer.FacadeMatch;

public class MatchController extends ControllerAbstract {
	
	private static final FacadeMatch FACADE_MATCH = FacadeMatch.getInstance();

	@Override
	public String getURI() {
		return "/Match.api";
	}

	@Override
	public String getResponse(HttpServletRequest request, HttpServletResponse response) {
		Gson gson = new Gson();
		final String isEmployeeOk = request.getParameter("isEmployeeOk");
		final String isTraineeOk = request.getParameter("isTraineeOk");
		final String idInternshipOffer = request.getParameter("idInternshipOffer");
		final String idTrainee = request.getParameter("idTrainee");
		
		if (idInternshipOffer != null && idTrainee != null) {
			MatchPK matchPK = new MatchPK();
			Match match = new Match();
			matchPK.setIdinternshipoffer(Integer.parseInt(idInternshipOffer));
			matchPK.setIdtrainee(Integer.parseInt(idTrainee));
			match.setId(matchPK);
			if ("true".equals(isEmployeeOk)) {
				match.setEmployeeok(true);
			}
			if ("true".equals(isTraineeOk)) {
				match.setTraineeshipok(true);
			}
			if (FACADE_MATCH.isMatchExisting(match)) {
				return gson.toJson(FACADE_MATCH.updateMatch(match));
			} else {
				FACADE_MATCH.createMatch(match);
			}
			return gson.toJson(match);
		}
		
		return gson.toJson(FACADE_MATCH.getAllMatches());
	}
	
}
