package HW12Rest;

import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.*;

@Path("/tickets")
public class RestTicket {
	EntryManager entryManager = new EntryManager();
	EntryValidation entryValidation= new EntryValidation();

	// inserting a ticket
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response creatTicket(Ticket ticket) throws SQLException {
		boolean status=false;
		try {
			if(!entryValidation.dateValidation(ticket.getDate())){
				//means the date is incorrect
				return Response.status(200).entity("wrong date entry").build();
			}
			
			if(!entryValidation.flightNumberValidation(ticket.getFlightNumber())){
				//means the flight number is not 3 digits
				return Response.status(200).entity("wrong filght number").build();
			}
			//if these two entry is correct
			status=entryManager.addTicket(ticket);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(status){
			return Response.status(200).entity("saved successfully").build();
		}else{
			return Response.status(200).entity("wrong information").build();
		}

		
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
	@PUT
	@Path("/{ticketNumber}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateTicketByCode(Ticket ticket, @PathParam("ticketNumber") int ticketNumber){
		if(!entryValidation.dateValidation(ticket.getDate())){
			//means the date is incorrect
			return Response.status(200).entity("wrong date entry").build();
		}
		
		if(!entryValidation.flightNumberValidation(ticket.getFlightNumber())){
			//means the flight number is not 3 digits
			return Response.status(200).entity("wrong filght number").build();
		}
		
		boolean status=entryManager.updateTicket(ticket, ticketNumber);
		
		if(status){
			return Response.status(200).entity("updated successfully").build();
		}else{
			return Response.status(200).entity("wrong information. enter again").build();
		}
		
	}
	
	//delete a ticket with ID
	@DELETE
	@Path("/{ticketNumber}")
	public Response deleteTicketByCode(@PathParam("ticketNumber") int ticketNumber){
		boolean status=entryManager.DeleteTicketByCode(ticketNumber);
		if(status){
			return Response.status(200).entity("deleted successfully").build();
		}else{
			return Response.status(200).entity("wrong ticket code").build();
		}
	}
	


}

