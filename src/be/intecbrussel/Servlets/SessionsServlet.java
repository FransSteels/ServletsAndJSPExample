package be.intecbrussel.Servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Sessions")
public class SessionsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String VIEW = "WEB-INF/JSP/sessions.jsp";
	
	private static final String REDIRECT_URL = "/Sessions";
	
	/* Met deze annotatie onderdruk je de waarschuwingen 
	 * die unchecked gelaten mogen worden. Dit omdat er in 
	 * deze methode een cast wordt gedaan die een waarschuwing
	 * geeft waar we niets aan kunnen doen. 
	 * (ArrayList<String>) session.getAttribute("lijst");
	 * Dit is geen cruciale annotatie dus haal hem eens weg
	 * om te testen wat het juist doet.
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher(VIEW);
		
		/* Om de session van de gebruiker op te vragen gebruik
		 * je het volgende statement. De boolean die je meegeeft
		 * aan de methode 'getSession()' bepaalt of je al dan niet
		 * een session wilt aanmaken als er nog geen zou bestaan.
		 * Dus bij de waarde 'true' zal er een nieuwe session aangemaakt
		 * worden indien er nog geen huidige session bestaat. Bij
		 * de waarde 'false' zal er geen nieuwe session worden aangemaakt
		 * en returned deze methode 'null' als er nog geen session zou bestaan.
		 */
		HttpSession session = request.getSession(true);
		
		/* Met dit statement vraag je een session attribuut op genaamd
		 * "lijst". Als dit attribuut niet bestaat zal de lijst-referentie
		 * null zijn. Je moet een session attribuut ook casten omdat session
		 * attributen altijd van het type Object zijn.
		 */
		ArrayList<String> lijst = (ArrayList<String>) session.getAttribute("lijst");
		
		/* Indien er nog geen session attribuut 'lijst' bestaat gaan we het in
		 * dit if-block aanmaken.
		 */
		if (lijst == null) {
			
			lijst = new ArrayList<String>();
			
			lijst.add("EersteString");
			
			lijst.add("TweedeString");
			
			// Met dit statement kan je een nieuw session attribuut aanmaken.
			session.setAttribute("lijst", lijst);
			
			session.setAttribute("eenSessionAttribuut", "waardeVanEenSessionAttribuut");
			
		}
		
		request.setAttribute("lijst", lijst);
		
		dispatcher.forward(request, response);
		
	}


	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if (request.getParameter("nieuweString") !=null){
			
			HttpSession session = request.getSession();
			
			ArrayList<String> lijst = (ArrayList<String>) session.getAttribute("lijst");
			
			lijst.add(request.getParameter("nieuweString"));
			
			session.setAttribute("nieuweString", lijst);
			
			session.removeAttribute("eenSessionAttribuut");
			
			}
		
		response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + REDIRECT_URL));
		
	}

}
