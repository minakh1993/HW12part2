package HW12Rest;

public class EntryValidation {
	
	private int ValidFlightNumberDigit=3;
	
	
	//date validation
	public boolean dateValidation(String date){
		Date d=new Date();
		return d.DateValidation(date);
		
	}
	
	
	
	//flight number validation
	public boolean flightNumberValidation(int flightNumber){
		//flight number must be a three digit number
		if(digitCounter(flightNumber)!=ValidFlightNumberDigit){
			return false;
		}else{
			return true;
		}
		
	}
	
	
	private int digitCounter(int number){
		int count=1;
		while(number>=10){
			number/=10;
			count++;
			
		}
		return count;
		
	}

}
