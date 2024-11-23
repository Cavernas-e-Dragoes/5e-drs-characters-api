//package com.ced.model.character;
//
//import com.ced.model.Equipment;
//import com.ced.model.SubRace;
//import com.ced.model.drs.classes.CharClass;
//import com.ced.model.drs.races.Race;
//import com.ced.model.drs.spells.Spell;
//import lombok.Data;
//import lombok.EqualsAndHashCode;
//import org.springframework.data.annotation.Id;
//import org.springframework.data.mongodb.core.index.Indexed;
//import org.springframework.data.mongodb.core.mapping.DBRef;
//import org.springframework.data.mongodb.core.mapping.Document;
//import org.springframework.data.mongodb.core.mapping.Field;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Data
//@EqualsAndHashCode(onlyExplicitlyIncluded = true)
//@Document(collection = "characters")
//public class CharacterSheet {
//
//    @EqualsAndHashCode.Include
//    @Id
//    private String id;
//
//    @Indexed(unique = true)
//    private String email;
//
//    private String name;
//
//    @DBRef
//    private Race race;
//
//    @DBRef
//    private SubRace subRace;
//
//    @DBRef
//    @Field("class")
//    private CharClass charClass;
//
//    @DBRef
//    private List<Equipment> equipments = new ArrayList<>();
//
//    @DBRef
//    private List<Spell> magics = new ArrayList<>();
//
//    private Integer level = 1;
//    private String alignment;
//    private Integer hitPoints;
//    private Integer experiencePoints = 0;
//    private Integer initiative;
//    private Integer armorClass;
//    private Integer inspiration;
//    private Integer passiveWisdom;
//
//    /**
//     * Attributes
//     */
//    private Integer strength;
//    private Integer dexterity;
//    private Integer constitution;
//    private Integer intelligence;
//    private Integer wisdom;
//    private Integer charisma;
//
//    /**
//     * Saving Throws
//     */
//    private Boolean stStrength;
//    private Boolean stDexterity;
//    private Boolean stConstitution;
//    private Boolean stIntelligence;
//    private Boolean stWisdom;
//    private Boolean stCharisma;
//
//    /**
//     * Skills
//     */
//    private Boolean acrobatics;
//    private Boolean animalHandling;
//    private Boolean arcana;
//    private Boolean athletics;
//    private Boolean deception;
//    private Boolean history;
//    private Boolean insight;
//    private Boolean intimidation;
//    private Boolean investigation;
//    private Boolean medicine;
//    private Boolean nature;
//    private Boolean perception;
//    private Boolean performance;
//    private Boolean persuasion;
//    private Boolean religion;
//    private Boolean sleightOfHand;
//    private Boolean stealth;
//    private Boolean survival;
//}