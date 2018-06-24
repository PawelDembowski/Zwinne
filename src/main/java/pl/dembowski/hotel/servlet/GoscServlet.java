package pl.dembowski.hotel.servlet;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.dembowski.hotel.adapter.RequestAdapter;
import pl.dembowski.hotel.service.GoscService;

@WebServlet(urlPatterns = "/goscie/*")
public class GoscServlet extends HttpServlet {

	private static final String GOSCIE_JSP_PATH = "/goscie.jsp";
	private static final String GOSC_JSP_PATH = "/gosc.jsp";
	
	private static final String PESEL_PARAM = "pesel";

	private final GoscService goscService;

	public GoscServlet() {
		this.goscService = new GoscService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if ("/add".equals(request.getPathInfo())) {
			// GET add view
			request.setAttribute("action", "add");
			forwardToView(request, response, GOSC_JSP_PATH);
		} else if ("/edit".equals(request.getPathInfo())) {
			String pesel = request.getParameter(PESEL_PARAM);
			request.setAttribute("gosc", goscService.find(pesel));
			request.setAttribute("action", "edit");
			forwardToView(request, response, GOSC_JSP_PATH);
		} else {
			// default behavior: GET list view
			request.setAttribute("goscie", goscService.findAll());
			request.setAttribute("action", "view");
			forwardToView(request, response, GOSCIE_JSP_PATH);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if ("/save".equals(request.getPathInfo())) {
			try {
				goscService.save(RequestAdapter.toGosc(request));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		} else if ("/delete".equals(request.getPathInfo())) {
			goscService.delete(request.getParameter(PESEL_PARAM));
		}
		// go to list page
		doGet(request, response);
	}

	private void forwardToView(HttpServletRequest request, HttpServletResponse response, String path)
			throws ServletException, IOException {
		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}
	
}
