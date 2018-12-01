/*tar in 'användarnamnnamn' och 'lösenord' som parametrar, och returnar
en boolean. Villkoret för true är att användarnamn equals ett namnet på ett
 skapat member-objekt, och att lösenord matchar 'password', som är en variabel
 i samma member-objekt.
*/

public class authenticate {

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
    }
}
