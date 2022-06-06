package ced.characters.management.vo;

import ced.characters.management.models.Equipment;
import ced.characters.management.models.Magic;
import ced.characters.management.models.Race;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CharacterSheetDTO {

    private Long id;

    private String raceName;

    private String className;

    private String login;

    private String name;

    @JsonIgnore
    private Race race;

    @JsonIgnore
    private Race charClass;

    private List<Equipment> equipments;

    private List<Magic> magics;

    private Integer level;

    private String Alignment;

    private Integer experiencePoints;

    private Integer initiative;

    private Float speed;

    private Integer armorClass;

    private Integer inspiration;

    private Integer passiveWisdom;

    /**
     * Attributes
     */
    private Integer strength;

    private Integer dexterity;

    private Integer constitution;

    private Integer intelligence;

    private Integer wisdom;

    private Integer charisma;

    /**
     * Saving Throws
     */
    private Boolean STStrength;

    private Boolean STDexterity;

    private Boolean STConstitution;

    private Boolean STIntelligence;

    private Boolean STWisdom;

    private Boolean STCharisma;

    /**
     * Skills
     */
    private Boolean acrobatics;

    private Boolean animalHandling;

    private Boolean arcana;

    private Boolean athletics;

    private Boolean deception;

    private Boolean history;

    private Boolean insight;

    private Boolean intimidation;

    private Boolean investigation;

    private Boolean medicine;

    private Boolean nature;

    private Boolean perception;

    private Boolean performance;

    private Boolean persuasion;

    private Boolean religion;

    private Boolean sleightOfHand;

    private Boolean stealth;

    private Boolean survival;

    /**
     * Calculated properties
     */
    private Integer proficiencyBonus;

    private Integer strengthModifier;

    private Integer dexterityModifier;

    private Integer constitutionModifier;

    private Integer intelligenceModifier;

    private Integer wisdomModifier;

    private Integer charismaModifier;

    private Integer HitPoints;


}
