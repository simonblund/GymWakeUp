/*tar in 'användarnamnnamn' och 'lösenord' som parametrar, och returnar
en boolean. Villkoret för true är att användarnamn equals ett namnet på ett
 skapat member-objekt, och att lösenord matchar 'password', som är en variabel
 i samma member-objekt.
*/

public class authenticate {
/*
    private String username;
    private String password;
    private boolean result;

    public boolean checkUsernamePassword(String username, String password){

        this.username = username;
        this.password = password;

        if (this.password equals this.username.getPassword() ) {
            result = true;
        }
        else {
            result = false;
        }

        return result;
    } */
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

}
