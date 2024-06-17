package bookmanagement.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookmanagement.models.BookDTO;


@WebServlet("/books")
public class DisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public DisplayServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//List<BookDTO> books;
		List<BookDTO> books=(ArrayList<BookDTO>)request.getServletContext().getAttribute("books");
		if(books==null) {
			books=new ArrayList<BookDTO>();
		}
		
		request.getServletContext().setAttribute("books",books);
		
		request.getRequestDispatcher("display.jsp").forward(request, response);
		
		
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("display.jsp").forward(request, response);
	
	}

}
