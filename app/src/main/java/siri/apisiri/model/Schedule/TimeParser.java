package siri.apisiri.model.Schedule;

import android.content.Context;

import java.util.StringTokenizer;

public class TimeParser {
    private String timeData;
    private int hour;
    private int minute;

    private TimeParser() {

    }

    private static TimeParser mTimeParser;

    public static TimeParser getInstance(Context context) {
        if (mTimeParser == null) {
            mTimeParser = new TimeParser();
        }
        return mTimeParser;
    }

    public void setTimeData(String timeData) {
        this.timeData = timeData;
    }

    public void parseExecute() {
        StringTokenizer tokenizer = new StringTokenizer(timeData, ":");
        while(tokenizer.hasMoreTokens()) {
            hour = Integer.parseInt(tokenizer.nextToken());
            minute = Integer.parseInt(tokenizer.nextToken());
        }
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }
}
