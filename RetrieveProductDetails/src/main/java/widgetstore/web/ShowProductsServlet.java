package widgetstore.web;

import desserts.DessertDAOImpl;
import desserts.DessertDTO;
import desserts.GenericDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ShowProductsServlet extends HttpServlet {

    GenericDAO<DessertDTO> dessertDTO;

    public ShowProductsServlet() {
        dessertDTO = new DessertDAOImpl();
    }
	
	public void doGet(HttpServletRequest request,
	          			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		out.println("<form action='' method='POST'>");
		out.println("<label>Enter Product (Dessert) ID: <input type='text' name='dessert-id'></input></label>");
		out.println("<input type='submit'>Get Details</input>");
		out.println("</form>");
		
		out.println("<h2>Desserts</h2>");
        for (DessertDTO dessert: dessertDTO.getAll()) {
            out.println("<p>" + dessert.getId() + ": " + dessert.getName() + " It is good:" + dessert.isGood() + "</p>");
        }
	}
	
	public void doPost(HttpServletRequest request,
						HttpServletResponse response) throws ServletException, IOException {
		String dessertId = request.getParameter("dessert-id");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		boolean foundId = false;
		for (DessertDTO dessert: dessertDTO.getAll()) {
            //out.println("<p>" + dessert.getId() + ": " + dessert.getName() + " It is good:" + dessert.isGood() + "</p>");
			String realId = dessert.getId().toString();
			if(realId.equals(dessertId)) {
				foundId = true;
				out.println("<p> The dessert was found; here are the details of the requested entry: </p>");
				out.println("<p>" + dessert.getId() + ": " + dessert.getName() + " It is good:" + dessert.isGood() + "</p>");
			}
        }
		if(!foundId) {
			out.println("<p> Your desired dessert was not found </p>");
		}
	
	}
	
}
