import java.util.Scanner;

/*
GymWakeUp-klassen är den klass som startar programmet.

Här finns funktioner för meny och kanske även autentisering.

 */
public class GymWakeUp {
    private Member user;

    public static void main(String[] args){
        // Initierar programmet.
        // testa angivet personnummer
    }
    private void showMenu(){
        System.out.print("Välkommen till WakeUpGym \nVälj ett av alternativen nedan:");
        System.out.println("1. Bli medlem");
        System.out.println("2. Logga in");
        System.out.println("3. Boka plats på aktivitet");
        System.out.println("4. Avsluta");

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
                case 4: {
                    System.exit(0);
                }
                default:{
                    System.out.println("Ogiltigt menyval, försök igen.");
                }
            }
        }
    }

    private void newMembership(){
        // Create a new member-object
        // Set that member object to be used to complete other actions.

        Member member = new Member();
        Scanner sc = new Scanner(System.in);

        System.out.println("Skapa medlemskap\n");

        System.out.println("Skriv in ditt personnummer");
        try{

            member.setPersonnummer(sc.next());
        }
        catch (Exception e){

        }

        System.out.println("Skriv ditt förnamn");
        System.out.println("Skriv ditt efternamn");
        System.out.println(" ");


    }

    private void signIn(){
        // Find an existing member-object and use that to complete other actions.

    }

    private void joinActivity(){
        // Use previously selected or created member-object and join existing activity.

    }

}
