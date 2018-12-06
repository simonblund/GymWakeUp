import java.time.LocalDate;
import java.util.Date;
import java.util.regex.Pattern;

public class Member {
    private String personnummer;
    private String fornamn;
    private String efternamn;
    private LocalDate membershipenddate;

    private int numberOfMonths; // används för kostnadsberäkning
    private String password; //för autenticering

    // Getters and setters for all instance variables
    public String getPersonnummer() {
        return personnummer;
    }

    public void setPersonnummer(String personnummer) {
        this.personnummer = personnummer; //940709-3030

    }

    public String getFornamn() {
        return fornamn;
    }

    public void setFornamn(String fornamn) {
        this.fornamn = fornamn;
    }

    public String getEfternamn() {
        return efternamn;
    }

    public void setEfternamn(String efternamn) {
        this.efternamn = efternamn;
    }

    public LocalDate getMembershipenddate() {
        return membershipenddate;
    }

    public void setMembershipenddate(LocalDate membershipenddate) {
        this.membershipenddate = membershipenddate;
    }

    public int getNumberOfMonths(){
        return numberOfMonths;
    }

    public void setNumberOfMonths(int numberOfMonths) {
        this.numberOfMonths = numberOfMonths;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }




}
