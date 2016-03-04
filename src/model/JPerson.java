package model;

/**
 * Created by eroshin on 03.03.2016.
 */
public class JPerson {

    private String pName;
    private String pSurName;
    private String pTown;
    private int pYear;
    private int pNumber;

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
    }

    private boolean isMale;

    private JGroup pGroup;
    private int pHour;
    private int pMinute;
    private int pSeconds;

    public JPerson(String n, String s, String t,int y, int num,boolean male){
        pName = n;
        pSurName = s;
        pTown = t;
        pYear = y;
        pNumber = num;
        isMale = male;
    }

    public JGroup getpGroup() {
        return pGroup;
    }

    public void setpGroup(JGroup pGroup) {
        this.pGroup = pGroup;
    }

    public Object[] getObject(){
        Object[] ans = new Object[6];
        ans[1] = pName;
        ans[0]=pSurName;
        ans[2]=pTown;
        ans[4]=pYear;
        ans[3]=pNumber;
        ans[5]="";
        return ans;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpSurName() {
        return pSurName;
    }

    public void setpSurName(String pSurName) {
        this.pSurName = pSurName;
    }

    public String getpTown() {
        return pTown;
    }

    public void setpTown(String pTown) {
        this.pTown = pTown;
    }

    public int getpYear() {
        return pYear;
    }

    public void setpYear(int pYear) {
        this.pYear = pYear;
    }

    public int getpNumber() {
        return pNumber;
    }

    public void setpNumber(int pNumber) {
        this.pNumber = pNumber;
    }
}
