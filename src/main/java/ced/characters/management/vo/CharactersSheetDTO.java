package ced.characters.management.vo;

import ced.characters.management.models.Equipment;
import ced.characters.management.models.Magic;

import java.util.List;

public class CharactersSheetDTO {

    private String raceName;

    private String className;

    private String login;


    private String name;


    private Long race;


    private Long charClass;


    private List<Equipment> equipments;


    private List<Magic> magics;


    private Integer level = 1;


    private String Alignment;


    private Integer HitPoints;


    private Integer experiencePoints = 0;


    private Integer initiative;


    private Float speed;


    private Integer armorClass;


    private Integer inspiration;


    private Integer passiveWisdom;


    private Float height;


    private Float weight;


    private Integer age;


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


    public String getRaceName() {
        return raceName;
    }

    public void setRaceName(String raceName) {
        this.raceName = raceName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getRace() {
        return race;
    }

    public void setRace(Long race) {
        this.race = race;
    }

    public Long getCharClass() {
        return charClass;
    }

    public void setCharClass(Long charClass) {
        this.charClass = charClass;
    }

    public List<Equipment> getEquipments() {
        return equipments;
    }

    public void setEquipments(List<Equipment> equipments) {
        this.equipments = equipments;
    }

    public List<Magic> getMagics() {
        return magics;
    }

    public void setMagics(List<Magic> magics) {
        this.magics = magics;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getAlignment() {
        return Alignment;
    }

    public void setAlignment(String alignment) {
        Alignment = alignment;
    }

    public Integer getHitPoints() {
        return HitPoints;
    }

    public void setHitPoints(Integer hitPoints) {
        HitPoints = hitPoints;
    }

    public Integer getExperiencePoints() {
        return experiencePoints;
    }

    public void setExperiencePoints(Integer experiencePoints) {
        this.experiencePoints = experiencePoints;
    }

    public Integer getInitiative() {
        return initiative;
    }

    public void setInitiative(Integer initiative) {
        this.initiative = initiative;
    }

    public Float getSpeed() {
        return speed;
    }

    public void setSpeed(Float speed) {
        this.speed = speed;
    }

    public Integer getArmorClass() {
        return armorClass;
    }

    public void setArmorClass(Integer armorClass) {
        this.armorClass = armorClass;
    }

    public Integer getInspiration() {
        return inspiration;
    }

    public void setInspiration(Integer inspiration) {
        this.inspiration = inspiration;
    }

    public Integer getPassiveWisdom() {
        return passiveWisdom;
    }

    public void setPassiveWisdom(Integer passiveWisdom) {
        this.passiveWisdom = passiveWisdom;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getStrength() {
        return strength;
    }

    public void setStrength(Integer strength) {
        this.strength = strength;
    }

    public Integer getDexterity() {
        return dexterity;
    }

    public void setDexterity(Integer dexterity) {
        this.dexterity = dexterity;
    }

    public Integer getConstitution() {
        return constitution;
    }

    public void setConstitution(Integer constitution) {
        this.constitution = constitution;
    }

    public Integer getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(Integer intelligence) {
        this.intelligence = intelligence;
    }

    public Integer getWisdom() {
        return wisdom;
    }

    public void setWisdom(Integer wisdom) {
        this.wisdom = wisdom;
    }

    public Integer getCharisma() {
        return charisma;
    }

    public void setCharisma(Integer charisma) {
        this.charisma = charisma;
    }

    public Boolean getSTStrength() {
        return STStrength;
    }

    public void setSTStrength(Boolean STStrength) {
        this.STStrength = STStrength;
    }

    public Boolean getSTDexterity() {
        return STDexterity;
    }

    public void setSTDexterity(Boolean STDexterity) {
        this.STDexterity = STDexterity;
    }

    public Boolean getSTConstitution() {
        return STConstitution;
    }

    public void setSTConstitution(Boolean STConstitution) {
        this.STConstitution = STConstitution;
    }

    public Boolean getSTIntelligence() {
        return STIntelligence;
    }

    public void setSTIntelligence(Boolean STIntelligence) {
        this.STIntelligence = STIntelligence;
    }

    public Boolean getSTWisdom() {
        return STWisdom;
    }

    public void setSTWisdom(Boolean STWisdom) {
        this.STWisdom = STWisdom;
    }

    public Boolean getSTCharisma() {
        return STCharisma;
    }

    public void setSTCharisma(Boolean STCharisma) {
        this.STCharisma = STCharisma;
    }

    public Boolean getAcrobatics() {
        return acrobatics;
    }

    public void setAcrobatics(Boolean acrobatics) {
        this.acrobatics = acrobatics;
    }

    public Boolean getAnimalHandling() {
        return animalHandling;
    }

    public void setAnimalHandling(Boolean animalHandling) {
        this.animalHandling = animalHandling;
    }

    public Boolean getArcana() {
        return arcana;
    }

    public void setArcana(Boolean arcana) {
        this.arcana = arcana;
    }

    public Boolean getAthletics() {
        return athletics;
    }

    public void setAthletics(Boolean athletics) {
        this.athletics = athletics;
    }

    public Boolean getDeception() {
        return deception;
    }

    public void setDeception(Boolean deception) {
        this.deception = deception;
    }

    public Boolean getHistory() {
        return history;
    }

    public void setHistory(Boolean history) {
        this.history = history;
    }

    public Boolean getInsight() {
        return insight;
    }

    public void setInsight(Boolean insight) {
        this.insight = insight;
    }

    public Boolean getIntimidation() {
        return intimidation;
    }

    public void setIntimidation(Boolean intimidation) {
        this.intimidation = intimidation;
    }

    public Boolean getInvestigation() {
        return investigation;
    }

    public void setInvestigation(Boolean investigation) {
        this.investigation = investigation;
    }

    public Boolean getMedicine() {
        return medicine;
    }

    public void setMedicine(Boolean medicine) {
        this.medicine = medicine;
    }

    public Boolean getNature() {
        return nature;
    }

    public void setNature(Boolean nature) {
        this.nature = nature;
    }

    public Boolean getPerception() {
        return perception;
    }

    public void setPerception(Boolean perception) {
        this.perception = perception;
    }

    public Boolean getPerformance() {
        return performance;
    }

    public void setPerformance(Boolean performance) {
        this.performance = performance;
    }

    public Boolean getPersuasion() {
        return persuasion;
    }

    public void setPersuasion(Boolean persuasion) {
        this.persuasion = persuasion;
    }

    public Boolean getReligion() {
        return religion;
    }

    public void setReligion(Boolean religion) {
        this.religion = religion;
    }

    public Boolean getSleightOfHand() {
        return sleightOfHand;
    }

    public void setSleightOfHand(Boolean sleightOfHand) {
        this.sleightOfHand = sleightOfHand;
    }

    public Boolean getStealth() {
        return stealth;
    }

    public void setStealth(Boolean stealth) {
        this.stealth = stealth;
    }

    public Boolean getSurvival() {
        return survival;
    }

    public void setSurvival(Boolean survival) {
        this.survival = survival;
    }
}
