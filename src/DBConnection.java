import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {
	   
		private String BDD = "nomBD";
		private String url = "jdbc:mysql://localhost:3306/" + BDD;
		private String user = "root";
		private String passwd = "";
	    private Connection conn;
	  

	   
	    public DBConnection() throws SQLException {
	    	try {
	    		conn=DriverManager.getConnection(url, user,passwd);
	    	}catch (SQLException ex) {
	    		Logger.getLogger(BDD).log(Level.SEVERE, null, ex);
	    	}
	    
		}

	    
    public  synchronized Connection getConn() throws SQLException {
		if (conn == null) {
		     new DBConnection();
		}
    	return conn;
		}


		
	
}
