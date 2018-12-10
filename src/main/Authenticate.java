package main;
import java.util.Scanner;
/*tar in member-objektet som har det personnummer som angetts i inloggningen.
Frågar efter lösenord.
Kontrollerar om den inskrivna lösenordet matchar det hashade lösenordet som finns i member objektet.
Om det matchar så returnas boolean result med värde true
om ej matchar så returnas boolean result med värde false
*/

public class Authenticate
{

    public static boolean checkPassword(Member candidate)
    {

        Scanner input = new Scanner(System.in);
        System.out.println("Ange lösenord:");
        String angettLosenord = input.nextLine();

        if (BCrypt.checkpw(angettLosenord, candidate.getPassword()))
  	       {
              boolean result = true;
              return result;
           }

        else
            {
                boolean result = false;
                return result;
            }

    } // end method checkPassword()
} //end class Authenticate
/*
    Jag lånar en funktion från ett bibliotek för att hasha lösenord i vårt program så de inte sparas i plantext,
    egentligen onödigt för detta program men best-practice i riktiga program. Så man kan inte längre kontrollera lösenord med
    equals utan måste använda nedanstående kontrollmekanism. Implementera den på ett passligt ställe :)
    Pst. hashed variabeln är alltså getPassword() från member och candidate är det användaren matat in.
// Check that an unencrypted password matches one that has
// previously been hashed
if (BCrypt.checkpw(candidate, hashed))
	System.out.println("It matches");
else
	System.out.println("It does not match");

     */
