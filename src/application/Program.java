package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {


	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat simpleDate = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room number: ");
		int roomNumber = sc.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		Date checkinDate = simpleDate.parse(sc.next());
		System.out.print("Check-out date (dd/MM/yyyy): ");
		Date checkoutDate = simpleDate.parse(sc.next());
		
		if(!checkoutDate.after(checkinDate)) {
			 System.err.println("Error in reservation: Check-out date must be after check-in date");
		}
		else {
			Reservation reservation = new Reservation(roomNumber, checkinDate, checkoutDate);
			System.out.println("Reservation: " +reservation);
		
			System.out.println();
			System.out.println("Enter data to update the reservation:");
			System.out.print("Check-in date (dd/MM/yyyy): " );
			checkinDate = simpleDate.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): " );
			checkoutDate = simpleDate.parse(sc.next());
			
			String error =reservation.updateDates(checkinDate, checkoutDate);
			if(error != null) {
				System.err.println(error);
			}
			
			else System.out.println(reservation);
		}

		sc.close();
	}
}
