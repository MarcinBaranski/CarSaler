package pl.javastart.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("")
public class HelloWorldMainPage extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private String query;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
//		out.println("<a href=\"http://localhost:8080/HelloWorld/test\">Link do servletu</a>");
		DBManager db = new DBManager();
		Connection conn = db.getConnection();
		query = "SELECT * FROM bazasamochodow.tbmarka;";
		try {
			Statement statement = conn.createStatement();
			statement.execute(query);
			ResultSet res = statement.getResultSet();
			while(res.next()) {
				out.println("Id marki: "+ res.getString("idMarka") +" "+ "Nazwa marki: "+ res.getString("NazwaMarki") );
				
			}
			conn.close();	
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		if(conn == null) {
//			out.println("\n Brak polaczenia do bazy danych");
//		}else {
//			out.println("\n Udane polaczenie do bazy danych");			
//		}
	}
	

}
