package pl.javastart.servlets;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class DBManager {
	
	public Connection getConnection() {
		try {
			 //Okreœlenie jaki driver bêdzie u¿yty do po³¹czenia z baz¹ danych
			Class.forName("com.mysql.jdbc.Driver");
			
			//otwieramy po³¹czenie poprzez driver Managera
			
			//Pierwszy argument okreœla miejsce w którym znajduje sie baza danych:   jdbc:mysql://localhost:3306:nazwaBazyDanych
			//Drugi parametr to nazwa u¿ytkownika do bazy danych
			//Trzeci parametr to haslo uzytkownika do bazy danych
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306?verifyServerCertificate=false"
					+ "&useSSL=true", "root", "praktyki");
			
			return connection;
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
