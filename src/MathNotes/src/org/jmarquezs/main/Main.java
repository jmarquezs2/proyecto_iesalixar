package org.jmarquezs.main;

import java.io.File;

import org.jmarquezs.DAO.ContentDAOimpl;
import org.jmarquezs.DAO.NoteDAOimpl;
import org.jmarquezs.DAO.UsuarioDAOimpl;
import org.jmarquezs.model.Content;

public class Main {

	public static void main(String[] args) {


		UsuarioDAOimpl.register("pepito@gmail.com", "pepito", "Pepe");
		UsuarioDAOimpl.register("root@gmail.com", "root", "root");
		UsuarioDAOimpl.register("juan@gmail.com", "juan12", "Juan");
		UsuarioDAOimpl.changePassword("juan@gmail.com", "juan123",  "juan123");
		System.out.println(UsuarioDAOimpl.readRol("pepito@gmail.com"));
		
		
		Content cont = ContentDAOimpl.createContent("x=2*3", "formula");
		Content cont2 = ContentDAOimpl.createContent("https://www.filmaffinity.com/es/main.html", "link");
		NoteDAOimpl.createNote(1, "Prueba", "F�sica", "Leyes", "hola hola", cont, cont2,null, "pepito@gmail.com");
		
		Content cont3 = ContentDAOimpl.createContent("V=ab*h", "formula");
		NoteDAOimpl.createNote(1, "Volumen", "Matem�ticas", "Volumenes", "hola hola", cont3, null,null, "pepito@gmail.com");
		
		Content cont4 = ContentDAOimpl.createContent("g=9,8", "formula");
		NoteDAOimpl.createNote(1, "Gravedad", "F�sica", "Fuerzas", "hola hola", cont4, null, null, "pepito@gmail.com");
		
		Content cont5 = ContentDAOimpl.createContent("v=e/t", "formula");
		NoteDAOimpl.createNote(1, "Velocidad", "F�sica", "Movimiento", "La velocidad", cont5, null,null, "pepito@gmail.com");
		
		Content cont6 = ContentDAOimpl.createContent("v=e/t", "formula");
		NoteDAOimpl.createNote(1, "prueba2", "F�sica", "hola", "La velocidad 3", cont6, null,null, "pepito@gmail.com");
		
		Content cont7 = ContentDAOimpl.createContent("v=e/t", "formula");
		Content cont8 = ContentDAOimpl.createContent("/MathNotes/img/notesImage/" +"madera.jpg", "img");
		NoteDAOimpl.createNote(2, "Imagen", "Qu�mica", "hola", "La velocidad 3", cont7, null,cont8, "juan@gmail.com");
		//System.out.println(NoteDAOimpl.subjectOfUser("pepito@gmail.com").toString());
		
	}

}
