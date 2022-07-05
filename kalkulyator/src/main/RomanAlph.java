package main;

public enum RomanAlph {
    I("I",1), II("II",2), III("III",3), IV("IV",4), V("V",5), VI("VI",6), VII("VII",7), VIII("VIII",8), IX("IX",9), X("X",10),
    XX("XX",20), XXX("XXX",30), XL("XL",40), L("L",50), LX("LX",60), LXX("LXX",70), LXXX("LXXX",80), XC("XC",90), C("C",100);

    private String roman;
    private int arab;

    RomanAlph(String roman, int arab) {
        this.roman = roman;
        this.arab = arab;
    }

    public String getRoman() {
        return this.roman;
    }

    public int getArab() {
        return this.arab;
    }

    public static int toArab(String roman) {
        for (RomanAlph i : values()) {
            if (i.getRoman().equals(roman)) {
                return i.getArab();
            }
        }
        return 0;
    }

    public static boolean isRoman(String cnt) {
        for (RomanAlph i : values()) {
            if (i.getRoman().equals(cnt)) return true;
        }
        return false;
    }

    public static String toRoman(int arab) {

        String[] masArab = Integer.toString(arab).split("");
        String arabToRoman = "";
        for(int i = 0; i < masArab.length;i++ ) {
            for (RomanAlph j : values()) {
                if (Integer.toString(j.getArab()).equals(Integer.toString(Integer.parseInt(masArab[i])*((int)Math.pow(10, masArab.length-1-i))))) {
                    arabToRoman += j.getRoman();
                }
            }
        }
        if (arabToRoman.length() > 0 && arab > 0) return arabToRoman;
        return "nulla";
    }
}