package HW12Rest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
		Statement stmt = null;
		ResultSet rs=null;
		try {

			 stmt = conn.createStatement();
			 rs = stmt.executeQuery("select * from ticket.ticket");
			while (rs.next()) {
				// inserting each row in a ticket object
				Ticket ticket = new Ticket(rs.getString(6), rs.getString(2), rs.getString(3), rs.getString(5),
						rs.getInt(4), rs.getInt(1));
				tickets.add(ticket);
			}

			
		} catch (Exception e) {
			e.printStackTrace();

		}finally{
			try{
			stmt.close();
			rs.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}

		return tickets;
	}

	public boolean addTicket(Ticket ticket)  {
		PreparedStatement pre=null;
		try{
			//first validate date then enter it...this function should return true or false
			
			
			pre=conn.prepareStatement("insert into ticket.ticket(orgin,destination,flight_number,date,clinet_name) values(?,?,?,?,?)");
			pre.setString(1,ticket.getOrigin());
			pre.setString(2, ticket.getDestination());
			pre.setInt(3, ticket.getFlightNumber());
			pre.setString(4, ticket.getDate());
			pre.setString(5, ticket.getCustomerName());
			pre.executeUpdate();
			pre.close();
			return true;
		}catch(Exception e){
			if(pre!=null){
				try {
					pre.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			System.out.println("erorr in inserting ticket");
			e.printStackTrace();
			return false;
		}
	}

    public void deleteAllTickets(){
    	try{
    		Statement stmt=conn.createStatement();
    		stmt.executeUpdate("delete  from ticket.ticket");
    		stmt.close();
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    }

    public Ticket showTicketByNumber(int id){
    	Ticket ticket = null;
    	Statement stmt=null;
    	ResultSet rs=null;
    	try{
    		stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from ticket.ticket where ticket.ticket_code='"+id+"'");
    		if(rs.next()){
    			//means we have found that ticket
    			ticket=new Ticket(rs.getString(6), rs.getString(2), rs.getString(3), rs.getString(5), rs.getInt(4), rs.getInt(1));
    		}
    		
    	}catch(Exception e){
    		e.printStackTrace();
    	}finally{
    		if(stmt!=null){
    			try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    		}if(rs!=null){
    			try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    		}
    	}
    	
    	return ticket;
    }

    public boolean updateTicket(Ticket ticket, int id){
    	try{
    		Statement stmt=conn.createStatement();
    		int temp=stmt.executeUpdate("update ticket.ticket set `ticket_code` "
    				+ "= '"+ticket.getTicketCode()+"', `orgin` ="
    						+ " '"+ticket.getOrigin()+"', `destination` ="
    								+ " '"+ticket.getDestination()+"',"
    										+ " `flight_number` = '"+ticket.getFlightNumber()+"'"
    												+ ", `date` = '"+ticket.getDate()+"', `clinet_name` ="
    														+ " '"+ticket.getCustomerName()+"' "
    																+ "where ticket_code='"+id+"' ");
    		stmt.close();
    		if(temp==1){
    			return true;
    		}else{
    			return false;
    		}
    		
    	}catch(Exception e){
    		e.printStackTrace();
    		return false;
    	}
    	
    }

    public boolean DeleteTicketByCode(int id){
    	Statement stmt=null;
    	try{
    		stmt=conn.createStatement();
    		int a=stmt.executeUpdate("delete from ticket.ticket where ticket.ticket_code='"+id+"'");
    		if(a==1){
    			return true;
    		}else{
    			return false;
    		}
    		
    		
    	}catch(Exception e){
    		e.printStackTrace();
    		return false;
    	}finally{
    		if(stmt!=null){
    			try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    		}
    	}
    	
    	
    }
}
