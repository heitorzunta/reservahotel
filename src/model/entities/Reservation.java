package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation {

	private Integer roomNumber;
	private Date checkinDate;
	private Date checkoutDate;
	public static SimpleDateFormat simpleDate = new SimpleDateFormat("dd/MM/yyyy");
	public Reservation() {
		
	}

	public Reservation(Integer roomNumber, Date checkinDate, Date checkoutDate) throws DomainException{
		if(!checkoutDate.after(checkinDate)) 
			throw new DomainException("Error in reservation: Check-out date must be after check-in date");
		this.roomNumber = roomNumber;
		this.checkinDate = checkinDate;
		this.checkoutDate = checkoutDate;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckinDate() {
		return checkinDate;
	}

	public Date getCheckoutDate() {
		return checkoutDate;
	}

	public Integer duration() {
		long durationTime = checkoutDate.getTime() - checkinDate.getTime();
		return (int) TimeUnit.DAYS.convert(durationTime, TimeUnit.MILLISECONDS); //converter milissegundos em dia
	}
	
	public void updateDates(Date checkinDate, Date checkoutDate) throws DomainException{
		Date now = new Date();
		
		if(checkinDate.before(now) || checkoutDate.before(now))
			throw new DomainException("Error in reservation: Reservation dates for update must be future dates");
		
		if(!checkoutDate.after(checkinDate)) 
			throw new DomainException("Error in reservation: Check-out date must be after check-in date");
		
		this.checkinDate = checkinDate;
		this.checkoutDate = checkoutDate;
	}
	
	@Override
	public String toString() {
		return "Room " + roomNumber +
				", checkin: " + simpleDate.format(checkinDate) +
				", check-out: " +simpleDate.format(checkoutDate) + ", " +
				duration() + " nights";	
	}
	
}
