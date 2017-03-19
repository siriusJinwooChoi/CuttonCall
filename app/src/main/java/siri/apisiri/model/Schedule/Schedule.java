package siri.apisiri.model.Schedule;

public class Schedule {
    private int year, month, date, day;
    private int startHour;
    private int startMinute;
    private int endHour;
    private int endMinute;
    private int duration;

    public Schedule(int year, int month, int date, int day, int startHour, int startMinute, int duration) {
        this.year = year;
        this.month = month;
        this.date = date;
        this.day = day;
        this.startHour = startHour;
        this.startMinute = startMinute;
        this.duration = duration;
    }

    public String getDate() {
        return year + "-" + month + "-" + date;
    }

    public int getDay() {
        return day;
    }

    public int getStartHour() {
        return startHour;
    }

    public int getStartMinute() {
        return startMinute;
    }
}
