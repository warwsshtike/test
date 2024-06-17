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


@WebServlet("/edit")
public class EditBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public EditBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

 // find book equal code and then  edit book.jsp with found book data
    // edit book.jsp with found book
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code=request.getParameter("code");
		
		List<BookDTO> books=(ArrayList<BookDTO>)request.getServletContext().getAttribute("books");
		BookDTO foundbook=new BookDTO();
		for(var e:books) {
			if(e.getCode().equals(code)) {
				foundbook=e;
				break;
			}
		}
		request.setAttribute("book", foundbook);
		request.getRequestDispatcher("edit_book.jsp").forward(request, response);
		
	
	}
//update book 
	//update application scope 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BookDTO uibook=new BookDTO();
		uibook.setCode(request.getParameter("code"));
		uibook.setName(request.getParameter("name"));
		uibook.setAuthor(request.getParameter("author"));
		if(request.getParameter("price")!=null && !request.getParameter("price").equals("")) {
			uibook.setPrice(Double.parseDouble(request.getParameter("price")));
		}
		
		if(uibook.getCode().equals("") || uibook.getName().equals("") || uibook.getAuthor().equals("") || uibook.getPrice()==0) {
			String error="";
			if(uibook.getCode().equals("")) error+="code field is required<br>";
			if(uibook.getName().equals("")) error+="name field is required<br>";
			if(uibook.getPrice()==0) error+="price field is required<br>";
			if(uibook.getAuthor().equals("")) error+="Author field is required";
			
			request.setAttribute("error", error);
			request.setAttribute("book", uibook);
			request.getRequestDispatcher("add_book.jsp").forward(request, response);
		}else {
						
		List<BookDTO> books=(ArrayList<BookDTO>)request.getServletContext().getAttribute("books");
		
		for(var b:books) {
			if(b.getCode().equals(uibook.getCode())) {
		//		b.setCode("uiBook.getCode()");
				b.setName(uibook.getName());
				b.setPrice(uibook.getPrice());
				b.setAuthor(uibook.getAuthor());
				break;
			}
		}
		request.getServletContext().setAttribute("books",books);
		response.sendRedirect("books");
		}	
		
	}

}
