package co.wecommit.javatest;


public class SingleClubMember extends Member {

    private int club;

    SingleClubMember(char pMemberType, int pMemberID, String pName, double pFees, int pClub) {
        super.Member(pMemberType, pMemberID, pName, pFees);

        setClub(pClub);
    }

    public void setClub(int pClub) {
        club = pClub;
    }

    public int getClub() {
        return club;
    }

    @Override
    public String toString() {
        return super.toString() + ", "+ getClub();
    }
}
