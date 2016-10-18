package fr.epsi.arras.chocolait.bookingmytraining.server.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * Classe abstraite pour les controleurs
 * 
 * @author Loulou
 *
 */
public abstract class ControllerAbstract {
	/**
	 * Renvoie l'uri du controleur
	 * 
	 * @return l'uri du controleur
	 */
	public String getURI() {
		return "/";
	}

	/**
	 * @param request
	 * @param response
	 * @return
	 */
	public String getResponse(final HttpServletRequest request, final HttpServletResponse response) {
		return null;
	}

}
