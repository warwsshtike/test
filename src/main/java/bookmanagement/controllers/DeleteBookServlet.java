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


@WebServlet("/delete")
public class DeleteBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public DeleteBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code=request.getParameter("code");
		
		// find book equal code and then  delete
	    // update all books update to application scope
		
		List<BookDTO> books=(ArrayList<BookDTO>)request.getServletContext().getAttribute("books");
	
		//BookDTO foundBook=new BookDTO();
		for(BookDTO b:books) {
			if(b.getCode().equals(code)) {
				//foundBook=b;
				books.remove(b);
				break;
			}
		}
		
		//books.remove(foundBook);
		
		request.getServletContext().setAttribute("books", books);
		response.sendRedirect("books");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
