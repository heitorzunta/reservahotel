package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

	private Integer roomNumber;
	private Date checkinDate;
	private Date checkoutDate;
	public static SimpleDateFormat simpleDate = new SimpleDateFormat("dd/MM/yyyy");
	public Reservation() {
		
	}

	public Reservation(Integer roomNumber, Date checkinDate, Date checkoutDate) {
		super();
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
	
	public void updateDates(Date checkinDate, Date checkoutDate) {
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
