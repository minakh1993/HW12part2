package HW12Rest;

import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.ArrayList;

import javax.ws.rs.*;

@Path("/tickets")
public class RestTicket {
	EntryManager entryManager = new EntryManager();

	@GET
	@Path("/AllTickets")
	@Produces(MediaType.APPLICATION_JSON)
		public ArrayList<Ticket> showAllusers() {

		ArrayList<Ticket> tickets = entryManager.showAllTickets();
		System.out.println(tickets.size());
		/*ArrayList<String> test=new ArrayList<String>();
		test.add("alaki");
		test.add("bikhodi");*/

		return tickets;
	}

	
	
	@GET
	@Path("/test")
	public Response test(){
		ArrayList<Ticket> tickets = entryManager.showAllTickets();
		return Response.status(200).entity("mina").build();
	}
}
