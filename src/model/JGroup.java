package model;

/**
 * Created by eroshin on 03.03.2016.
 */
public class JGroup {

    private String gName;
    private int lYear;
    private int hYear;
    private boolean isMale;

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
    }

    public String getgName() {
        return gName;
    }

    public void setgName(String gName) {
        this.gName = gName;
    }

    public int getlYear() {
        return lYear;
    }

    public void setlYear(int lYear) {
        this.lYear = lYear;
    }

    public int gethYear() {
        return hYear;
    }

    public void sethYear(int hYear) {
        this.hYear = hYear;
    }

    public JGroup(String n, int l, int h, boolean y){
        gName = n;
        lYear = l;
        hYear = h;
        isMale = y;
    }

}
