package main;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class BookActivity {
    public static void showActivities(ArrayList<Activity> activities){
        Scanner sc = new Scanner(System.in);
        System.out.println("Aktiviteter");
        System.out.println("ValNr  "+"  Aktivitet"+"\t"+"  Datum"+"\t"+"    Tid"+"\t"+"  Duration");

        for(int i =0;i < activities.size(); i++){
            Activity activity = activities.get(i);
            String name = activity.getName();
            LocalDate date = activity.getDate();
            LocalTime time = activity.getTime();
            long duration = activity.getDuration();
            System.out.println(i+"\t    "+name+"\t    "+date+"\t    "+time+"\t    "+duration);
        }
        System.out.println("Välj aktivitet med nummer.");
        Activity act = activities.get(sc.nextInt());
        showActivity(act);

    }
    private static void showActivity(Activity act){
        Scanner sc = new Scanner(System.in);
        System.out.println("Bokningsläget på "+ act.getName());
        System.out.println("Platser markerade med X är tagna, O är lediga");

        System.out.println(" |  1  |  2  |  3  |");
        System.out.println("A  " + (act.getSeats()[0][0]!=null?"  X  ":"  O  ") +(act.getSeats()[0][1]!=null?"  X  ":"  O  ") +(act.getSeats()[0][2]!=null?"  X  ":"  O  "));
        System.out.println("B  " + (act.getSeats()[1][0]!=null?"  X  ":"  O  ") +(act.getSeats()[1][1]!=null?"  X  ":"  O  ") +(act.getSeats()[1][2]!=null?"  X  ":"  O  "));
        System.out.println("C  " + (act.getSeats()[2][0]!=null?"  X  ":"  O  ") +(act.getSeats()[2][1]!=null?"  X  ":"  O  ") +(act.getSeats()[2][2]!=null?"  X  ":"  O  "));

        System.out.println("Boka en plats:");
        System.out.println("Välj rad (A B C):");
        int rad = sc.next().charAt(0);
        System.out.println(rad);

    }
}
