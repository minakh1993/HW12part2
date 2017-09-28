package HW12Rest;

public class Date {

	private int year = -1;
	private int month = -1;
	private int day = -1;
	private int[] kabiseh = { 1, 5, 9, 13, 17, 22, 26, 30 };;

	// *********************************************************************
	// constructor
	public Date() {
		year = -1;
	}

	public Date(int[] kabiseh1) {
		kabiseh = new int[8];

		this.kabiseh = kabiseh1;
	}

	public Date(int year1, int month1, int day1) {
		setyear(year1);
		setmonth(month1);
		setday(day1);

	}

	// ****************************************************************************

	boolean setyear(int a) {
		if (a > 1200 && a < 1400) {
			year = a;
			return true;
		} else {
			System.out.println("wrong year number, please enter year again");
			return false;
		}

	}

	// ****************************************************************************
	boolean setmonth(int b) {
		if (b <= 12 && b > 0) {
			month = b;
			return true;
		} else {
			System.out.println("number of month shouldn't be more than12, please enter again");
			return false;
		}
	}

	// *******************************************************************************
	// IS YEAR KABISEH CODE
	boolean iskabiseh() {
		int res = year % 33;
		for (int i = 0; i < 8; i++) {
			System.out.println(kabiseh[i] + " " + res);
			if (res == kabiseh[i]) {
				return true;

			}
		}
		return false;

	}

	// ********************************************************************************************
	// DATE VALIDATION CODE

	boolean setday(int c) {
		boolean temp = iskabiseh();
		if (temp = true) {
			if (month <= 6) {
				if (c > 0 && c <= 31) {
					day = c;
					return true;
				} else {
					System.out.println("wrong number of day you should enter a number between 1 to 31");

					return true;
				}

			} else {
				if (c > 0 && c <= 30) {
					day = c;
					return true;
				} else {
					System.out.println("wrong number of day you should enter a number between 1 to 30 ");
					return false;

				}

			}

		} else {
			if (month <= 6) {
				if (c > 0 && c <= 31) {
					day = c;
					return true;

				} else {
					System.out.println("wrong number of day you should enter a number between 1 to 31");
					return false;

				}

			} else if (month <= 11) {

				if (c > 0 && c <= 30) {
					day = c;
					return true;

				} else {
					System.out.println("wrong number of day you should enter a number between 1 to 30");
					return false;

				}

			} else {
				if (c > 0 && c <= 29) {
					day = c;
					return true;

				} else {
					System.out.println("wrong number of day you should enter a number between 1 to 29");
					return false;

				}

			}

		}

	}

	// ************************************************************************************************************
	// get date
	int getday() {
		return day;

	}

	int getmonth() {
		return month;
	}

	int getyear() {
		return year;
	}

	// **************************************************************************************************************
	// a function to validate a date in format of string
	public boolean DateValidation(String s){
		String str[]=new String[3];
		str=s.split("/");
		if(str[0].matches("[0-9]*")&& str[1].matches("[0-9]*") && str[2].matches("[0-9]*")){
			int y1=Integer.parseInt(str[0]);
			int m1=Integer.parseInt(str[1]);
			int d1=Integer.parseInt(str[2]);
			boolean state1=setyear(y1);
			boolean state2=setmonth(m1);
			boolean state3=setday(d1);

			if(state1 && state2 && state3){
				//means the date inserted right
				return true;
			}else{
				return false;
			}

		}else{
			System.out.println("your date is not in right format please enter it again");
			return false;

			
		}

	}
}
