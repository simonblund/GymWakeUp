package main;


import test.ActivityTest;
import test.MemberTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/*
GymWakeUp-klassen är den klass som startar programmet.
Här finns funktioner för meny och kanske även autentisering.

 */
public class GymWakeUp {
    private static Member user; // Håller den aktiva användaren.
    private static ArrayList<Member> members = new ArrayList<Member>(); // Håller alla medlemsobjekt.
    private static ArrayList<Activity> activities = new ArrayList<Activity>();

    public static void main(String[] args){
        // Initierar programmet.
        // testa angivet personnummer
        MemberTest.createTestMembers();
        ActivityTest.createActivities();
        showMenu();
    }
    public static void showMenu(){
        System.out.print("Välkommen till WakeUpGym \nVälj ett av alternativen nedan:\n\n");
        if(user==null){
            System.out.print("Kund: UTLOGGAD\n\n");
        } else {
            System.out.print("Kund:"+user.getFornamn()+" "+user.getEfternamn() +"\n\n");
        }

        System.out.println("1. Bli medlem");
        System.out.println("2. Logga in");
        System.out.println("3. Boka plats på aktivitet");
        System.out.println("4. Logga ut");
        System.out.println("5. Avsluta");

        Scanner sc = new Scanner(System.in);
        while (true){
            int choice = sc.nextInt();
            switch(choice){
                case 1: {
                    newMembership();
                    break;
                }
                case 2: {
                    signIn();
                    break;
                }
                case 3: {
                    joinActivity();
                    break;
                }
                case 4:{
                    logOut();
                    break;
                }
                case 5: {
                    System.exit(0);
                }
                default:{
                    System.out.println("Ogiltigt menyval, försök igen.");
                }
            }
        }
    }

    private static void newMembership(){
        // Create a new member-object
        // Set that member object to be used to complete other actions.

        Member member = new Member();
        Scanner sc = new Scanner(System.in);

        System.out.println("Skapa medlemskap\n");
        setMemberPnr(member, sc); // Separat funktion för att... rekursivitet är skönt.

        System.out.println("Skriv ditt förnamn");
        String fnamn = sc.next(); // Jag vet, jag borde validera detta..
        member.setFornamn(fnamn);

        System.out.println("Skriv ditt efternamn");
        String enamn = sc.next(); // Jag vet, jag borde validera detta...
        member.setEfternamn(enamn);

        setMemberPassword(member, sc);

        setMemberEndDate(member, sc);

        members.add(member);

        user = member; // Aktiv användare är nu den nya användaren.

        System.out.println("Grattis du är nu användare!");
        showMenu();


    }


    private static void setMemberPnr(Member member, Scanner sc){
        System.out.println("Skriv in ditt personnummer");
        String pnr = sc.next();
        if(PnrCheck.personnummerChecker(pnr)){
            member.setPersonnummer(pnr);
        } else{
            System.out.println("Ditt personnummer är ogiltigt!\nSkriv in ditt personnummer på nytt");
            setMemberPnr(member, sc);
        }
    }


    private static void setMemberPassword(Member member, Scanner sc){
        System.out.println("Skriv in ett lösenord");
        String password1 = sc.next();

        System.out.println("Bekräfta lösenordet genom att skriva det igen");
        String password2 = sc.next();

        if(password1.equals(password2)){ // Kontrollera att lösenorden överensstämmer
            String hashed = BCrypt.hashpw(password1, BCrypt.gensalt()); //Hasha lösenordet
            password1 = null;
            password2 = null;
            member.setPassword(hashed); // Spara det hashade lösenordet
            System.gc();
        } else {
            System.out.println("Lösenorden stämde inte, försök igen.");
            setMemberPassword(member, sc);
        }

    }
    private static void setMemberEndDate(Member member, Scanner sc){
        System.out.println("Ange hur många månader ditt medlemsskap ska vara:");
        long months = sc.nextLong();
        LocalDate date = LocalDate.now().plusMonths(months);
        System.out.println("Det betyder att ditt medlemskap tar slut den " + date);
        System.out.println("Det skulle kosta: "+ CostCalculator.calculate((int)months));
        System.out.println("Är det okej? J / N eller avbryt, A");
        switch (sc.next()){
            case "J":{
                member.setMembershipenddate(date);
                System.out.println("Sparat.");
                break;
            }
            case "N":{
                System.out.println("Okej, försök på nytt.");
                setMemberEndDate(member, sc);
                break;
            }
            default: {
                System.out.println("Okej, din användare sparas inte");
                member = null;
                System.gc();
                System.exit(0);
                break;
            }
        }

    }

    private static void signIn() {

        // Find an existing member-object and use that to complete other actions.
        // input personnummer
        // kolla om det finns en medlem i members arraylisten med det personnummret
        // Om ja -> skicka memberobjektet som har personnummret till authenticate klassens checkpassword metod

        // returneras true eller false
        // om false återgå till huvudmeny
        // om true återgå till huvudmeny men sätt user variabeln till memberobjektet vars personnummer överensstämmde ovan.

        System.out.println("Ange personnummer");
        Scanner sc = new Scanner(System.in);
        String angettPersonnummer = sc.next();
        for (int counter = 0; counter < members.size(); counter++) {

            if (members.get(counter).getPersonnummer().equals(angettPersonnummer)) {
                if (Authenticate.checkPassword(members.get(counter))) {
                    user = members.get(counter);
                    break;
                }
            }
        }
        showMenu();
    }


    private static void joinActivity(){
        // Use previously selected or created member-object and join existing activity.
        if (user == null){
            System.out.println("Ni måste logga in för att ha åtkomst till funktionen.");
            showMenu();
        } else if(user.getMembershipenddate().isAfter(LocalDate.now())){
            BookActivity.showActivities(activities, user);
        } else {
            System.out.println("Ert medlemskap har gått ut och ni kan inte boka aktiviteter.");
            showMenu();
        }
    }

    private static void logOut(){
        user = null;
    }

    public static void testmember(Member testmember){ // Inserts testmembers to array
        members.add(testmember);
    }

    public static void testActivity(Activity testactivity){
        activities.add(testactivity);
    }

}
