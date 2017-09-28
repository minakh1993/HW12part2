package HW12Rest;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EntryManager entryManager=new EntryManager();
		//entryManager.showAllTickets();
		System.out.println(entryManager.showAllTickets().size());
		//entryManager.addTicket(new Ticket("sara","tehran", "shiraz", "2/7/63", 124, 48757));
        System.out.println(entryManager.updateTicket(new Ticket("mohammad","tehran", "shiraz", "2/7/63", 124, 48757), 890));
	}

}
