package main;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class BookActivity {

    public static void showActivities(ArrayList<Activity> activities, Member user){
        /*
    ShowActivities visar alla aktiviteter. Man kan välja en aktivitet och se lediga platser genom att välja aktivitetssiffran.
     */
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
        showActivity(act, user);

    }
    private static void showActivity(Activity act, Member user){

        /*
        showActivity visar aktivitetns lediga platser och låter användaren boka en plats på aktiviteten
        Platsvalsinputen kontrolleras
         */

        Scanner sc = new Scanner(System.in);
        System.out.println("Bokningsläget på "+ act.getName());
        System.out.println("Platser markerade med X är tagna, O är lediga");

        System.out.println(" |  1  |  2  |  3  |");
        System.out.println("A  " + (act.getSeats().get(0)!=null?"  X  ":"  O  ") +(act.getSeats().get(1)!=null?"  X  ":"  O  ") +(act.getSeats().get(2)!=null?"  X  ":"  O  "));
        System.out.println("B  " + (act.getSeats().get(3)!=null?"  X  ":"  O  ") +(act.getSeats().get(4)!=null?"  X  ":"  O  ") +(act.getSeats().get(5)!=null?"  X  ":"  O  "));
        System.out.println("C  " + (act.getSeats().get(6)!=null?"  X  ":"  O  ") +(act.getSeats().get(7)!=null?"  X  ":"  O  ") +(act.getSeats().get(8)!=null?"  X  ":"  O  "));

        System.out.println("Boka en plats:");
        System.out.println("Välj rad (A B C):");
        int rad = sc.next().toLowerCase().charAt(0);
        if (rad >96 && rad <100){
            rad-=96;
        }else {
            System.out.println("Välj A B eller C");
            showActivity(act, user);
            return;
        }
        System.out.println("Välj plats på raden 1-3");
        int plats = sc.nextInt();
        if (plats <=0 | plats >=4){
            System.out.println("Välj 1 2 eller 3");
            showActivity(act, user);
            return;
        }
        if(rad == 2){
            plats = 3+plats;
        } else if (rad == 3){
            plats = 6+plats;
        }
        plats-=1; // Pga array inleds med 0

        if(act.getSeats().get(plats) == null){
            act.getSeats().add(plats,user);
            System.out.println("Du har nu bokat en plats på passet!");
            GymWakeUp.showMenu();
        } else {
            System.out.println("Platsen du försökte boka är upptagen, försök med en annan plats.");
            showActivity(act, user);
        }

    }
}
