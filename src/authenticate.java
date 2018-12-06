/*tar in 'lösenord' som parameter, och returnar
en boolean. Villkoret för true är att det lösenord som användaren skrivit interface
matchar lösenordet som lagrats i user objektet
*/

public class Authenticate {

    private boolean result;
    private String realPassword = user.getPassword();

    public boolean checkPassword(String enteredPassword){

        if (enteredPassword.equals(realPassword)) {
            result = true;
        }
        else {
            result = false;
        }

        return result;
    }

}
