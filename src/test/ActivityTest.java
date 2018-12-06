package test;

import main.Activity;
import main.GymWakeUp;

import java.time.LocalDate;
import java.time.LocalTime;

public class ActivityTest {
    private static void createTestActivity(String name, LocalDate date, LocalTime time){
        Activity act = new Activity();
        act.setName(name);
        act.setDate(date);
        act.setTime(time);
        act.setDuration(1);

        GymWakeUp.testActivity(act);
    }
    public static void createActivities(){
        LocalDate today = LocalDate.now();

        createTestActivity("Yoga", today, LocalTime.parse("12:00:00"));
        createTestActivity("Yoga", today, LocalTime.parse("13:00:00"));
        createTestActivity("Spinning", today, LocalTime.parse("14:00:00"));
        createTestActivity("Aerobics", today, LocalTime.parse("15:00:00"));
    }

}
