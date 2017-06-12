package co.wecommit.javatest;

public class Member {

    char memberType;

    int memberID;

    String name;

    double fees;

    public void Member(char pMemberType, int pMemberID, String pName, double pFees) {
        setMemberType(pMemberType);
        setMemberID(pMemberID);
        setName(pName);
        setFees(pFees);
    }

    public void setMemberType(char pMemberType) {
        memberType = pMemberType;
    }

    public char getMemberType() {
        return memberType;
    }

    public void setMemberID(int pMemberID) {
        memberID = pMemberID;
    }

    public int getMemberID() {
        return memberID;
    }

    public void setName(String pName) {
        name = pName;
    }

    public String getName() {
        return name;
    }

    public void setFees(double pFees) {
        fees = pFees;
    }

    public double getFees() {
        return fees;
    }

    @Override
    public String toString() {
        String separator = ", ";

        return memberType + separator + memberID + separator + name + separator + fees;
    }

}
