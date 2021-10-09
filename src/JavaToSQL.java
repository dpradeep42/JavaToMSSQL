import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JavaToSQL {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String url = "jdbc:sqlserver://localhost:1433;database=students";
		System.out.print("Enter the Login ID of database: ");
		String user = sc.next();
		System.out.print("Enter the Login password of database: ");
		String password = sc.next();
		int status = 0;

		try {
			Connection connection = DriverManager.getConnection(url, user, password);
			System.out.println("Connected");

			while (status == 0) {

				System.out.println("-----Operation-----");
				System.out.println("1. Insert");
				System.out.println("2. Delete");
				System.out.print("Enter your choice:");
				int choice = sc.nextInt();

				switch (choice) {
				case 1:
					String sql = "INSERT INTO student_details (name, marks) VALUES (?, ?)";
					PreparedStatement statement = connection.prepareStatement(sql);
					System.out.print("Enter the name of student: ");
					String st_name = sc.next();
					System.out.print("Enter the marks: ");
					int st_marks = sc.nextInt();
					statement.setString(1, st_name);
					statement.setInt(2, st_marks);
					// int count = statement.executeUpdate();
					statement.execute();
					System.out.println("Successfully added to table");
					break;
				case 2:
					System.out.print("Enter the ID of student need to be deleted: ");
					int del_id = sc.nextInt();
					String del = "DELETE FROM student_details WHERE id = ?";
					PreparedStatement del_statement = connection.prepareStatement(del);
					del_statement.setInt(1, del_id);
					del_statement.execute();
					System.out.println("Deleted");
				}
				System.out.println();
				System.out.println("To Continue press 0 else press any other key");
				try {
					status = sc.nextInt();
				} catch (Exception e) {
					status = 1;
				}
			}
			connection.close();
		} catch (SQLException e) {
			System.out.println("Invalid Credentials");
		}
		sc.close();
	}
}
