package org.mrtetyong.religionplugin;

public class Religion {

    private String name;
    private String buff;
    private int buffLevel;
    private int buffDuration;
    private String debuff;
    private int debuffLevel;

    public Religion(String name, String buff, int buffLevel, int buffDuration, String debuff, int debuffLevel) {
        this.name = name;
        this.buff = buff;
        this.buffLevel = buffLevel;
        this.buffDuration = buffDuration;
        this.debuff = debuff;
        this.debuffLevel = debuffLevel;
    }

    public String getName() {
        return name;
    }

    public String getBuff() {
        return buff;
    }

    public int getBuffLevel() {
        return buffLevel;
    }

    public int getBuffDuration() {
        return buffDuration;
    }

    public String getDebuff() {
        return debuff;
    }

    public int getDebuffLevel() {
        return debuffLevel;
    }
}