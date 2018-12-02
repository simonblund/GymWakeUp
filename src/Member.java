import java.util.Date;
import java.util.regex.Pattern;

public class Member {
    private String personnummer;
    private String fornamn;
    private String efternamn;
    private Date membershipenddate;

    // används för kostnadsberäkning
    private int numberOfMonths;

    //för autenticering

    private String password;

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

    public Date getMembershipenddate() {
        return membershipenddate;
    }

    public void setMembershipenddate(Date membershipenddate) {
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
