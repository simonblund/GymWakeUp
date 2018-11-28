import java.util.Date;

public class Member {
    private String personnummer;
    private String fornamn;
    private String efternamn;
    private Date membershipenddate;

    // Getters and setters for all instance variables
    public String getPersonnummer() {
        return personnummer;
    }

    public void setPersonnummer(String personnummer) {
        this.personnummer = personnummer;

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


}
