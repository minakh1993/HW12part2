package HW12Rest;



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
public class RestTicket {
	EntryManager entryManager = new EntryManager();
	
	
	@GET
	@Path("/showAllTickets")
	@Produces(MediaType.APPLICATION_JSON)
		public Ticket showAllusers() {
		
		Ticket ticket=new Ticket("sara","tehran", "shiraz", "2/7/63", 124, 48757);
		ArrayList<Ticket> tickets=new ArrayList<Ticket>();
		tickets.add(ticket);
		//not ok with getting the array from entry manager
		//tickets = entryManager.showAllTickets();
		//System.out.println(tickets.size());
		System.out.println("new");

		return ticket;
	}

	
	
	@POST
	@Path("/creatTicket")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response creatTicket(Ticket ticket){
		//entryManager.addTicket(ticket);
		
		
		return Response.status(200).entity("saved successfully").build();
	}
}
