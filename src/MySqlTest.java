import java.sql.*;
public class MySqlTest {

	/*
	 * @Author Kyle Smith
	 * @Version 1 10/08/13
	 * @Acknowledgments: Thank you to Morgan Benton for helping us get the skeleton draft
	 * 					 of our program working
	 */
	
	public static void main(String[] args)
	{
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		String url = "jdbc:mysql://localhost:3306/lightningUsers";
		String user = "Lightning";
		String password = "root";
		
		try
		{
			con = DriverManager.getConnection(url,user,password);
			st = con.prepareStatement("SELECT * FROM Users");
			rs  = st.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getInt("userID"));
				System.out.println(rs.getString("firstName"));
				System.out.println(rs.getString("lastName"));
			}
		}
		catch(SQLException ex)
		{
			System.out.println(ex.getMessage());
		}
	}
}
