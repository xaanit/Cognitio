package me.xaanit.cognitio.util;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class SimpleLogger {

    private LocalDateTime date;

    public SimpleLogger() {
        this.date = LocalDateTime.now();
    }

    public void debug(CharSequence str) {
        System.out.println("[Cognitio] [" + getCurrentTime() + "] DEBUG: " + str);
    }

    public void error(CharSequence str, LogLevel level) {
        System.out.println("[Cognitio] [" + getCurrentTime() + "] " + level.toString() + ":: " + str);

    }


    private String getCurrentTime() {
        LocalTime time = date.toLocalTime().now();
        return (date.getDayOfWeek().toString().charAt(0)
                + date.getDayOfWeek().toString().substring(1).toLowerCase())
                + ", "
                + (date.getMonth().toString().charAt(0)
                + date.getMonth().toString().substring(1).toLowerCase())
                + " " + date.getDayOfMonth() + " " + date.getYear() + " | "
                + (time.getHour() > 12 ? time.getHour() - 12 : time) + ":" + time.getMinute() + ":"
                + time.getSecond() + (time.getHour() > 12 ? " PM" : " AM");
    }

}

