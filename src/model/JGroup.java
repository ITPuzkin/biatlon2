package model;

/**
 * Created by eroshin on 03.03.2016.
 */
public class JGroup {

    private String gName;
    private int lYear;
    private int hYear;

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

    public JGroup(String n, int l, int h){
        gName = n;
        lYear = l;
        hYear = h;

    }

}
