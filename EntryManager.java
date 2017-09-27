package HW12Rest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class EntryManager {
	

	static Connection conn;

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = ProjectConnection.getConnection();

		} catch (Exception e) {
			System.out.println("Exception:" + e);
		}
	}
	
	
	
	public ArrayList<Ticket> showAllTickets(){
		ArrayList<Ticket> tickets=new ArrayList<Ticket>();
		try{
			
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery("select * from ticket.ticket");
			while(rs.next()){
				//inserting each row in a ticket object
				Ticket ticket=new Ticket(rs.getString(6), rs.getString(2), rs.getString(3),
						rs.getString(5), rs.getInt(4), rs.getInt(1));
				System.out.println("first ticket");
				System.out.println(ticket);
				tickets.add(ticket);			
			}
			
			
		}catch(Exception e){
			
		}
		
		
		
		
		
		
		return tickets;
	}
	
	

}
