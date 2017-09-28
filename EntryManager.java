package HW12Rest;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

	public ArrayList<Ticket> showAllTickets() {
		ArrayList<Ticket> tickets = new ArrayList<Ticket>();
		try {

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from ticket.ticket");
			while (rs.next()) {
				// inserting each row in a ticket object
				Ticket ticket = new Ticket(rs.getString(6), rs.getString(2), rs.getString(3), rs.getString(5),
						rs.getInt(4), rs.getInt(1));
				tickets.add(ticket);
			}

		} catch (Exception e) {

		}

		return tickets;
	}

	public void addTicket(Ticket ticket){
		try{
			//first validate date then enter it...this function should return true or false
			
			
			PreparedStatement pre=conn.prepareStatement("insert into ticket.ticket(orgin,destination,flight_number,date,clinet_name) values(?,?,?,?,?)");
			pre.setString(1,ticket.getOrigin());
			pre.setString(2, ticket.getDestination());
			pre.setInt(3, ticket.getFlightNumber());
			pre.setString(4, ticket.getDate());
			pre.setString(5, ticket.getCustomerName());
			pre.executeUpdate();
		}catch(Exception e){
			System.out.println("erorr in inserting ticket");
			e.printStackTrace();
			
		}
	}

    public void deleteAllTickets(){
    	try{
    		Statement stmt=conn.createStatement();
    		stmt.executeUpdate("delete  from ticket.ticket");
    		
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    }

    public Ticket showTicketByNumber(int id){
    	Ticket ticket = null;
    	try{
    		Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from ticket.ticket where ticket.ticket_code='"+id+"'");
    		if(rs.next()){
    			//means we have found that ticket
    			ticket=new Ticket(rs.getString(6), rs.getString(2), rs.getString(3), rs.getString(5), rs.getInt(4), rs.getInt(1));
    		}
    		
    	}catch(Exception e){
    		
    	}
    	
    	return ticket;
    }


}
