package ced.characters.management.helper;

import static java.lang.Math.floor;

public class Calcs {

    public static int convertAttribute(Integer value)
    {
        double calc = floor((value - 10) / 2);
        return (int) calc;
    }

    public static int calcInitialHT(Integer hitDice, Integer constitution)
    {
        return hitDice + constitution;
    }


}
