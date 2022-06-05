package ced.characters.management.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(indexes = { @Index(name = "IDX_LOGINCHR", columnList = "login") })
public class CharacterSheet {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String login;

    @Column(nullable = false, unique = true)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "race_id")
    private Race race;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "char_class_id")
    private CharClass charClass;

    @ManyToMany
    @JoinTable(name = "characters_equipments",
            joinColumns = @JoinColumn(name = "character_sheet_id"),
            inverseJoinColumns = @JoinColumn(name = "equipment_id"))
    private List<Equipment> equipments = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "characters_magics",
            joinColumns = @JoinColumn(name = "character_sheet_id"),
            inverseJoinColumns = @JoinColumn(name = "magic_id"))
    private List<Magic> magics = new ArrayList<>();

    @Column(nullable = false)
    private Integer level = 1;

    @Column(nullable = false)
    private String Alignment;

    @Column(nullable = false)
    private Integer HitPoints;

    @Column(nullable = false)
    private Integer experiencePoints = 0;

    private Integer initiative;

    private Float speed;

    private Integer armorClass;

    private Integer inspiration;

    private Integer passiveWisdom;

    /**
     * Attributes
     */
    @Column(nullable = false)
    private Integer strength;

    @Column(nullable = false)
    private Integer dexterity;

    @Column(nullable = false)
    private Integer constitution;

    @Column(nullable = false)
    private Integer intelligence;

    @Column(nullable = false)
    private Integer wisdom;

    @Column(nullable = false)
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

}
