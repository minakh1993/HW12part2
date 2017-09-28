package HW12Rest;

import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.*;

@Path("/tickets")
public class RestTicket {
	EntryManager entryManager = new EntryManager();

	// inserting a ticket
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response creatTicket(Ticket ticket) throws SQLException {
		try {
			entryManager.addTicket(ticket);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return Response.status(200).entity("saved successfully").build();
	}

	// showing all tickets
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Ticket> showAllTickets() {
		ArrayList<Ticket> tickets = new ArrayList<Ticket>();
		try {
			tickets = entryManager.showAllTickets();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return tickets;
	}

	// delete all tickets
	@DELETE
	@Path("/deleteAll")
	public Response deleteALLTickets() {
		entryManager.deleteAllTickets();
		return Response.status(200).entity("deleted successfully").build();

	}

	// show ticket with ID
	@GET
	@Path("/{ticketNumber}")
	@Produces(MediaType.APPLICATION_JSON)
	public Ticket showTicketByNumber(@PathParam("ticketNumber") int ticketNumber) {
		try {

			return entryManager.showTicketByNumber(ticketNumber);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	//update ticket with ID



}

