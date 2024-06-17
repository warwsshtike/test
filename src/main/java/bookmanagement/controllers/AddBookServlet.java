
package bookmanagement.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookmanagement.models.BookDTO;

@WebServlet("/addbook")
public class AddBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public AddBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("add_book.jsp").forward(request, response);	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		BookDTO book=new BookDTO();
		book.setCode(request.getParameter("code"));
		book.setName(request.getParameter("name"));
		book.setAuthor(request.getParameter("author"));
		if(request.getParameter("price")!=null && !request.getParameter("price").equals("")) {
			book.setPrice(Double.parseDouble(request.getParameter("price")));
		}

		
		if(book.getCode().equals("") || book.getName().equals("") || book.getAuthor().equals("") || book.getPrice()==0) {
			String error="";
			if(book.getCode().equals("")) error+="code field is required<br>";
			if(book.getName().equals("")) error+="name field is required<br>";
			if(book.getPrice()==0) error+="price field is required<br>";
			if(book.getAuthor().equals("")) error+="Author field is required";
			
			request.setAttribute("error", error);
			request.setAttribute("book", book);
			request.getRequestDispatcher("add_book.jsp").forward(request, response);
		}else {
			List<BookDTO> allbooks=(ArrayList<BookDTO>)request.getServletContext().getAttribute("books");
			allbooks.add(book);
			request.getServletContext().setAttribute("books", allbooks);
	
			
			response.sendRedirect("books");
					
		}
			
	}
}
