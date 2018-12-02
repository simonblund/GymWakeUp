import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
This checks that the Swedish Personnummer called is correct, it checks length, structure and Luhn-compatibility, in
 that order. Call the function personnummerChecker with the personnummer as a string and you'll be returned a boolean.
 */

// TODO remove System out fails.

public class PnrCheck {

    public boolean personnummerChecker(String pn){
        //PN är 11 tecken långt
        if(pn.length()!=11){
            System.out.println("Fail length");
            return false;
        }
        //PN har strukturen nnnnnn-nnnn
        if (! pnrStructureCheck(pn)) {
            System.out.println("Fail structure");
            return false;
        }
        // PN följer Luhn-algoritmen
        if(! pnrLuhnCheck(pn)){
            System.out.println("Fail luhn");
            return false;
        }

        return true;
    }
    private boolean pnrStructureCheck(String pnr){
        String patternString = "\\d{6}-\\d{4}"; // 6 siffror - 4 siffror
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(pnr);

        return matcher.matches(); // Om pnr stämmer med struktur upplagd, returnera true, annars false.

    }
    private boolean pnrLuhnCheck(String pnr){
        String birth_and_count = pnr.replace("-", "").substring(0,10); // Ta bort strecket

        int[] c = {birth_and_count.length()% 2 == 0 ? 1 : 2}; //
        boolean luhn = birth_and_count
                .chars() //String till character
                .map(i -> i-'0')// Gör charen från ASCII till riktigt nummer
                .map(n -> n * (c[0] = c[0] == 1 ? 2 : 1)) // Multiplicera vartannat tal med 1 och vartannat med 2.
                .map(n -> n > 9 ? n - 9 : n) //
                .sum() % 10 == 0; // Summan av multiplikationerna och kontroll om det är jämnt delbart med 10 ->sant/falskt

        return luhn; // Returnera Luhn booleanens true/false
    }
}
