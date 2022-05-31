package it.prova.gestionebiglietti.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.math.NumberUtils;

import it.prova.gestionebiglietti.service.MyServiceFactory;

@WebServlet("/ExecuteVisualizzaBigliettoServlet")
public class ExecuteVisualizzaBigliettoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idArticoloParam=request.getParameter("idBiglietto");
		
		if(!NumberUtils.isCreatable(idArticoloParam)) {
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}
		
		try {
			request.setAttribute("visualizza_biglietto_attr", MyServiceFactory.getBigliettoServiceInstance().caricaSingoloElemento(Long.parseLong(idArticoloParam)));
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}
		
		request.getRequestDispatcher("/biglietto/show.jsp").forward(request, response);
	}
}


//<a class="btn  btn-sm btn-outline-primary ml-2 mr-2" href="PrepareUpdateArticoloServlet?idDaInviareComeParametro=<%=item.getId() %>">Edit</a>
//<a class="btn btn-outline-danger btn-sm" href="PrepareDeleteArticoloServlet?idDaInviareComeParametro=<%=item.getId() %>">Delete</a>