package co.wecommit.javatest;

public class MultiClubMember extends Member {

    private int membershipPoints;

    MultiClubMember(char pMemberType, int pMemberID, String pName, double pFees, int pMembershipPoints) {
        super.Member(pMemberType, pMemberID, pName, pFees);

        setMembershipPoints(pMembershipPoints);
    }

    public void setMembershipPoints(int pMembershipPoints) {
        membershipPoints = pMembershipPoints;
    }

    public int getMembershipPoints() {
        return membershipPoints;
    }

    @Override
    public String toString() {
        return super.toString() + ", "+ getMembershipPoints();
    }


}
