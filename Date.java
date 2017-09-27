package HW12Rest;

public class Date {

	private int year=-1;
	private int month=-1;
	private int day=-1;
	private int[] kabiseh={1,5,9,13,17,22,26,30};;
	
	
	//*********************************************************************
	//constructor
    public Date(){
		year=-1;
	}
	public Date(int[] kabiseh1){
		kabiseh=new int[8];
		
		this.kabiseh=kabiseh1;
	}
	public Date(int year1, int month1, int day1){
		setyear(year1);
		setmonth(month1);
		setday(day1);
		
	}
	
	
	//****************************************************************************

	void setyear(int a){
		if(a>1200 && a<1400){
			year=a;

		}else{
			System.out.println("wrong year number, please enter year again");

		}

	}
	//****************************************************************************
	void setmonth(int b){
		if(b<=12&& b>0){
			month=b;
		}else{
			System.out.println("number of month shouldn't be more than12, please enter again");

		}
	}
	//*******************************************************************************
	//IS YEAR KABISEH CODE
	boolean iskabiseh(){
		int res=year%33;
		for(int i=0; i<8; i++){
			System.out.println(kabiseh[i]+" "+res);
			if(res==kabiseh[i]){
				return true;	

			}
		}
		return false;

	}


	//********************************************************************************************
	//DATE VALIDATION CODE

	void setday(int c){
		boolean temp=iskabiseh();
		if(temp=true){
			if(month<=6){
				if(c>0&& c<=31){
					day=c;
				}else{
					System.out.println("wrong number of day you should enter a number between 1 to 31");

				}

			}else{
				if(c>0&& c<=30){
					day=c;
				}else{
					System.out.println("wrong number of day you should enter a number between 1 to 30 ");

				}


			}


		}else{
			if(month<=6){
				if(c>0&& c<=31){
					day=c;
				}else{
					System.out.println("wrong number of day you should enter a number between 1 to 31");


				}

			}else if(month<=11){

				if(c>0&& c<=30){
					day=c;
				}else{
					System.out.println("wrong number of day you should enter a number between 1 to 30");


				}


			}else{
				if(c>0&& c<=29){
					day=c;
				}else{
					System.out.println("wrong number of day you should enter a number between 1 to 29");


				}


			}

		}



	}
	//************************************************************************************************************
	//get date
	int getday(){
		return day;

	}
	int getmonth(){
		return month;
	}
	int getyear(){
		return year;
	}

	//**************************************************************************************************************
	//show date
	void show(){
		String month_array[]=new String[12];
		month_array[0]="farvardin ";
		month_array[1]="ordibehesht ";
		month_array[2]=" khordad";
		month_array[3]="tir";
		month_array[4]=" mordad";
		month_array[5]=" shahrivar";
		month_array[6]="mehr ";
		month_array[7]="aban ";
		month_array[8]="azar ";
		month_array[9]=" dey";
		month_array[10]="bahman ";
		month_array[11]="esfand ";
		System.out.println("date :" + year+"/"+month+"/"+day);
		System.out.println("date : "+year+" "+month_array[month-1]+" "+day);


	}

}
