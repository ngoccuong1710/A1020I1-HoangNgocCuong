package _04_Lop_va_doi_tuong_trong_Java.bai_tap.xay_dung_lop_stopwatch;

import java.time.LocalTime;

public class StopWatch {
    private LocalTime startTime, endTime;

    public StopWatch(){
        startTime = LocalTime.now();
    }

    public StopWatch(LocalTime startTime, LocalTime endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public LocalTime getStartTime(){
        return startTime;
    }

    public LocalTime getEndTime(){
        return endTime;
    }

    public void stop(){
        startTime = LocalTime.now();
    }

    public void start(){
        endTime = LocalTime.now();
    }

    public int getElapsedTime(){
        int miliSecond = ((endTime.getHour() - startTime.getHour()) * 3600 +
                        (endTime.getMinute() - startTime.getMinute()) * 60 +
                        (endTime.getSecond() - startTime.getSecond()) * 1000);
        return miliSecond;
    }
}
