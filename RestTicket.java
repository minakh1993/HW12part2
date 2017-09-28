package HW12Rest;



import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.ArrayList;


import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.*;





@Path("/tickets")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RestTicket {
	EntryManager entryManager = new EntryManager();
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response creatTicket(Ticket ticket) throws SQLException{
		try{
		entryManager.addTicket(ticket);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return Response.status(200).entity("saved successfully").build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
		public ArrayList<Ticket> showAllusers()  {
		ArrayList<Ticket> tickets=new ArrayList<Ticket>();
		try{
		tickets = entryManager.showAllTickets();
		}catch(Exception e){
			e.printStackTrace();	
		}
		
		return tickets;
	}

	
	
	
}
