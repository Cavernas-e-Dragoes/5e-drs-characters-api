package ced.characters.management;

import static ced.characters.management.helper.Calcs.getProficiencyBonus;

public class TestsApplication {

    public static void main(String[] args) {

        //Test getProficiencyBonus calculations
        for(int i = 1; i<21; i++) {
            System.out.println("Level: " + i + " - Proficiency Bonus: " + getProficiencyBonus(i));
        }

    }
}
