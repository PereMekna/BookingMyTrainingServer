package fr.epsi.arras.chocolait.bookingmytraining.server.controller.internshipOfferController;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import fr.epsi.arras.chocolait.bookingmytraining.server.controller.ControllerAbstract;
import fr.epsi.arras.chocolait.bookingmytraining.server.model.InternshipOffer;
import fr.epsi.arras.chocolait.bookingmytraining.server.model.internshipoffer.FacadeInternshipOffer;

public class InternshipOfferController extends ControllerAbstract {

	private static final FacadeInternshipOffer FACADE_INTERNSHIP_OFFER = FacadeInternshipOffer.getInstance();

	@Override
	public String getURI() {
		return "/InternshipOffer.api";
	}

	@Override
	public String getResponse(final HttpServletRequest request, final HttpServletResponse response) {
		Gson gson = new Gson();
		final String address = request.getParameter("address");
		final String jobTitle = request.getParameter("jobTitle");
		final String description = request.getParameter("description");
		final String profile = request.getParameter("profile");
		final String mission = request.getParameter("mission");
		final Date datePublication = new Date();
		final Integer traineeNb = 0;
		Integer level = 0;
		Integer idInternshipOffer = 0;
		if (request.getParameter("level") != null) {
			level = Integer.parseInt(request.getParameter("level"));
		}
		if (request.getParameter("idInternshipOffer") != null) {
			idInternshipOffer = Integer.parseInt(request.getParameter("idInternshipOffer"));
			return gson.toJson(FACADE_INTERNSHIP_OFFER.getOfferById(idInternshipOffer));
		}

		if (null != address && null != jobTitle && null != level && null != description && null != profile
				&& null != profile && null != mission) {
			InternshipOffer internshipOffer = new InternshipOffer();
			internshipOffer.setAddress(address);
			internshipOffer.setJobtitle(jobTitle);
			internshipOffer.setLevel(level);
			internshipOffer.setDescription(description);
			internshipOffer.setProfile(profile);
			internshipOffer.setMission(mission);
			internshipOffer.setPublication(datePublication);
			internshipOffer.setTraineenb(traineeNb);
			
			FACADE_INTERNSHIP_OFFER.createOffer(internshipOffer);
			return gson.toJson(internshipOffer);
		}

		return gson.toJson(FACADE_INTERNSHIP_OFFER.getAllOffers());
	}

}
