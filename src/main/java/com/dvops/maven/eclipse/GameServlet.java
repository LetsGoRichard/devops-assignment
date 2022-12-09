package com.dvops.maven.eclipse;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
//import javax.servlet.RequestDispatcher;

/**
 * Servlet implementation class GameServlet
 */
@WebServlet("/GameServlet")
public class GameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Step 1: Prepare list of variables used for database connections
	private String jdbcURL = "jdbc:mysql://localhost:3308/userdetails";
	private String jdbcUsername = "root";
	private String jdbcPassword = "password";
	// Step 2: Prepare list of SQL prepared statements to perform CRUD to our
	// database
//	private static final String INSERT_USERS_SQL = "INSERT INTO UserDetails" + " (name, password, email, language) VALUES " + " (?, ?, ?);";
//	private static final String SELECT_USER_BY_ID = "select name,password,email,language from UserDetails where name =?";
	private static final String SELECT_ALL_GAMES = "select * from games ";
//	private static final String DELETE_USERS_SQL = "delete from UserDetails where name = ?;";
//	private static final String UPDATE_USERS_SQL = "update UserDetails set name = ?,password= ?, email =?,language =? where name = ?;";
	// Step 3: Implement the getConnection method which facilitates connection to
	// the database via JDBC

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GameServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());

		// Step 4: Depending on the request servlet path, determine the function to
		// invoke using the follow switch statement.
		String action = request.getServletPath();
		try {
			switch (action) {
			case "/insert":
				break;
			case "/delete":
				break;
			case "/edit":
				break;
			case "/update":
				break;
			default:
				listGames(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	// Step 5: listUsers function to connect to the database and retrieve all users
	// records
	private void listGames(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Games> games = new ArrayList<>();
		try (Connection connection = getConnection();
				// Step 5.1: Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_GAMES);) {
			// Step 5.2: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			// Step 5.3: Process the ResultSet object.
			while (rs.next()) {
				String name = rs.getString("name");
				String category = rs.getString("category");
				String image = rs.getString("image");
				String description = rs.getString("description");
				
				
				games.add(new Games(name, category, image, description));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		// Step 5.4: Set the users list into the listUsers attribute to be pass to the
		// userManagement.jsp
		request.setAttribute("listGames", games);
		request.getRequestDispatcher("/games.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}