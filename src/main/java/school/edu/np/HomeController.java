package school.edu.np;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping("/")
	public String home(Model model) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school_ss", "root", "3030");
			String SQL = "INSERT INTO Persons(PersonID,LastName,FirstName,Address ,City) VALUES('2','pokharel','sujan','tokyo','japan') ";
			PreparedStatement preparedStatement = con.prepareStatement(SQL);
			preparedStatement.executeUpdate();
//			while (rs.next())
//				System.out.println("connect sucesfully");
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		return "home";
	}
}
