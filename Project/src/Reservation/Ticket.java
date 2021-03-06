package Reservation;

import java.time.LocalDateTime;

public class Ticket {

    private String movieName;
    private int seat;
    private LocalDateTime showTime;
    private int room;
    private double price;
	private int reservationId;

    public Ticket(String movieName, int seat, LocalDateTime showTime, int room, double price, int reservationId) {
        setMovieName(movieName);
        setSeat(seat);
        setShowTime(showTime);
        setRoom(room);
        setPrice(price);
        setReservationId(reservationId);
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }
    
    public void setSeat(int seat) {
        this.seat = seat;
    }
    
    public void setRoom(int room) {
        this.room = room;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }
    
    public void setShowTime(LocalDateTime showTime) {
    	this.showTime = showTime;
    }
    
    public void setPrice(double price) {
		this.price = price;
	}
    
    public double getPrice() {
		return price;
	}

    public String getMovieName() {
		return movieName;
	}

	public int getSeat() {
		return seat;
	}

	public int getRoom() {
		return room;
	}

    public LocalDateTime getShowTime() {
        return showTime;
    }
    
    public int getReservationId() {
        return reservationId;
    }
    
    @Override
    public String toString() {
    	return "Movie " + movieName + " - "+
    			"Seat " + seat + " - "+
    			"showTime " + showTime + " - "+
    			"Room " + room + " - "+
    			"Price " + price + " - "+
    			"Id " + reservationId;
    }
}
