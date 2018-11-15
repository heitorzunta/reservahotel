package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {


	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat simpleDate = new SimpleDateFormat("dd/MM/yyyy");
		
		
		try {
		System.out.print("Room number: ");
		int roomNumber = sc.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		Date checkinDate = simpleDate.parse(sc.next());
		System.out.print("Check-out date (dd/MM/yyyy): ");
		Date checkoutDate = simpleDate.parse(sc.next());
		
	
			Reservation reservation = new Reservation(roomNumber, checkinDate, checkoutDate);
			System.out.println("Reservation: " +reservation);
		
			System.out.println();
			System.out.println("Enter data to update the reservation:");
			System.out.print("Check-in date (dd/MM/yyyy): " );
			checkinDate = simpleDate.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): " );
			checkoutDate = simpleDate.parse(sc.next());
			
			reservation.updateDates(checkinDate, checkoutDate);
			
			System.out.println(reservation);
		}
		catch (DomainException error) {
			System.err.println(error.getMessage());
		}
		catch(ParseException illegalFormat) {
			System.err.println("Illegal format date!");
		}
		catch(RuntimeException allExceptions) {
			System.err.println("Unknow error!");
		}
		
		sc.close();
	}
}
