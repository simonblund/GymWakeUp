package test;

import main.BCrypt;
import main.GymWakeUp;
import main.Member;
import main.PnrCheck;

import java.time.LocalDate;

public class MemberTest {
    private static void createMembersTest(String first, String last, String pnr, int months, boolean expired){
        if(PnrCheck.personnummerChecker(pnr)){
        Member testmember = new Member();
        testmember.setFornamn(first);
        testmember.setEfternamn(last);
        testmember.setPersonnummer(pnr);
        String hashed = BCrypt.hashpw("123", BCrypt.gensalt());
        testmember.setPassword(hashed);

        LocalDate date = LocalDate.now().plusMonths(months);
        if(expired){
            date = LocalDate.now().minusMonths(2);
        }
        testmember.setMembershipenddate(date);
        GymWakeUp.testmember(testmember);
        }
    }

    public static void createTestMembers(){
        createMembersTest("Stefan", "Stefansson","341212-3220", 2, true);
        createMembersTest("Lars", "Stefansson","341212-0317", 2, false);
    }
}
