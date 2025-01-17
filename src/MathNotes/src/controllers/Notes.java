package controllers;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jmarquezs.DAO.NoteDAOimpl;
import org.jmarquezs.DAO.UsuarioDAOimpl;
import org.jmarquezs.model.Note;
import org.jmarquezs.model.User;

public class Notes extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession(false);
		
	String owner = (String) session.getAttribute("Email");
	
		Set<Note> list = NoteDAOimpl.notesOfUser(owner);
		Set<String> subjects = NoteDAOimpl.subjectOfUser(owner);
	
		User user = UsuarioDAOimpl.bringBackUser(owner);
//		session.setAttribute("owner", user);
		 session.setAttribute("list", list);
		 session.setAttribute("subjects", subjects);
		 RequestDispatcher rd = null;
		 if(user.getBanned().contentEquals("yes")) {
			 rd = request.getRequestDispatcher("jsp/registrados/Baneado.jsp");
		 }else {
			 rd = request.getRequestDispatcher("jsp/registrados/notes.jsp");
		 }
	
		rd.forward(request, response);

	}
}
