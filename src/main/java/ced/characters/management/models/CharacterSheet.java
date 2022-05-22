package ced.characters.management.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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

    @Column(nullable = false)
    private Long race;

    @Column(nullable = false)
    private Long charClass;

    @OneToMany
    private List<Equipment> equipments;

    @OneToMany
    private List<Magic> magics;

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
