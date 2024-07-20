package org.mrtetyong.religionplugin;

public class ReligionPlayerData {

    private String religion;
    private int religionLevel;

    public ReligionPlayerData(String religion, int religionLevel) {
        this.religion = religion;
        this.religionLevel = religionLevel;
    }

    public String getReligion() {
        return religion;
    }

    public int getReligionLevel() {
        return religionLevel;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public void setReligionLevel(int religionLevel) {
        this.religionLevel = religionLevel;
    }
}