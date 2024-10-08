package BusRev;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
public class Booking {
	String passenderName;
	int busNo;
	Date date;

	Booking(){
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Name of Passenger:");
		passenderName=sc.next();
		System.out.println("Enter Bus No:");
		busNo=sc.nextInt();
		System.out.println("Enter the Date (dd-mm-yyyy):");
		String dateInput=sc.next();
		
		SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy");
		try {
			date=dateFormat.parse(dateInput);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public boolean isAvailable(ArrayList<Booking>bookings,ArrayList<Bus>buses) {
		int capacity=0;
		for(Bus bus:buses) {
			if(bus.getBusNO() ==busNo)
				capacity=bus.getCapacity();
		}
		int booked=0;
		for(Booking b:bookings) {
			if(b.busNo==busNo && b.date.equals(date)) {
				booked++;
			}
		}
		return booked<capacity?true:false;
	}
}





















