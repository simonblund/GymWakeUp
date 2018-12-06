package main;

import java.time.LocalDate;
import java.time.LocalTime;

public class Activity {
    private String name;
    private Member[][] seats = new Member[2][2];
    private LocalDate date;
    private LocalTime time;
    private long duration;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Member[][] getSeats() {
        return seats;
    }

    public void setSeats(Member[][] seats) {
        this.seats = seats;
    }

}
