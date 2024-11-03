package com.ced.utils.helper;

import static java.lang.Math.floor;

public class Calcs {

    public static int convertAttribute(final Integer value) {
        if (value != null) {
            double calc = Math.floor((value - 10.0) / 2);
            return (int) calc;
        } else {
            return 0;
        }
    }
    public static int calcInitialHT(Integer hitDice, Integer constitution)
    {
        return hitDice + constitution;
    }

    public static int getProficiencyBonus(int level) {
        double calc = floor(2 + (level - 1.0) / 4);
        return (int) calc;
    }
}
