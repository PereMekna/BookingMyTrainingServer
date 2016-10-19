package fr.epsi.arras.chocolait.bookingmytraining.server.controller.internshipofferview;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import fr.epsi.arras.chocolait.bookingmytraining.server.controller.ControllerAbstract;
import fr.epsi.arras.chocolait.bookingmytraining.server.model.InternshipOfferView;
import fr.epsi.arras.chocolait.bookingmytraining.server.model.InternshipOfferViewPK;
import fr.epsi.arras.chocolait.bookingmytraining.server.model.internshipoffer.FacadeInternshipOffer;

public class InternshipOfferViewController extends ControllerAbstract {
	
	private static final FacadeInternshipOffer FACADE_INTERNSHIP_OFFER = FacadeInternshipOffer.getInstance();

	@Override
	public String getURI() {
		return "/OfferView.api";
	}

	@Override
	public String getResponse(HttpServletRequest request, HttpServletResponse response) {
		Gson gson = new Gson();
		final String idInternshipOffer = request.getParameter("idInternshipOffer");
		final String idTrainee = request.getParameter("idTrainee");
		if (idTrainee != null && idInternshipOffer != null) {
			InternshipOfferViewPK internshipOfferViewPK = new InternshipOfferViewPK();
			InternshipOfferView internshipOfferView = new InternshipOfferView();
			internshipOfferViewPK.setIdinternshipoffer(Integer.parseInt(idInternshipOffer));
			internshipOfferViewPK.setIdtrainee(Integer.parseInt(idTrainee));
			internshipOfferView.setId(internshipOfferViewPK);
			internshipOfferView.setDateview(new Date());
			FACADE_INTERNSHIP_OFFER.createOfferView(internshipOfferView);
			return gson.toJson(internshipOfferView);
		}
		return gson.toJson(FACADE_INTERNSHIP_OFFER.getAllOfferViews());
	}

}
