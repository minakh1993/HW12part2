package HW12Rest;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EntryManager entryManager=new EntryManager();
		entryManager.showAllTickets();
		System.out.println(entryManager.showAllTickets().get(0).getCustomerName());

	}

}
