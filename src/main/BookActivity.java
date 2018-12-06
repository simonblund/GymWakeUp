package main;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class BookActivity {
    public static void showActivities(ArrayList<Activity> activities){
        System.out.println("Aktiviteter");
        System.out.println("ValNr"+"Aktivitet"+"\t"+"Datum"+"\t"+"Tid"+"\t"+"Duration");

        for(int i =0;i < activities.size(); i++){
            Activity activity = activities.get(i);
            String name = activity.getName();
            LocalDate date = activity.getDate();
            LocalTime time = activity.getTime();
            long duration = activity.getDuration();
            System.out.println(i+"\t"+name+"\t"+date+"\t"+time+"\t"+duration);
        }
        System.out.println("Alla aktiviteter");
    }
}
