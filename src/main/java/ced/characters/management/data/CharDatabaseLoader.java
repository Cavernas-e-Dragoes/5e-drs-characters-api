package ced.characters.management.data;

import ced.characters.management.models.CharacterSheet;
import ced.characters.management.repository.CharactersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import static java.util.Arrays.asList;

@Component
public class CharDatabaseLoader implements ApplicationRunner {

    private final CharactersRepository charactersRepository;

    @Autowired
    public CharDatabaseLoader(CharactersRepository charactersRepository) {
        this.charactersRepository = charactersRepository;
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
        CharacterSheet adno = new CharacterSheet();
        adno.setId(1L);
        adno.setLogin("asa");
        adno.setName("Adno");
        adno.setRace(1L);
        adno.setCharClass(1L);
        adno.setAlignment("Leal e Bom");
        adno.setHitPoints(13);
        adno.setStrength(20);
        adno.setDexterity(20);
        adno.setConstitution(20);
        adno.setIntelligence(20);
        adno.setWisdom(20);
        adno.setCharisma(20);
        adno.setArmorClass(15);
        adno.setSpeed(5F);
        adno.setLevel(32);

        CharacterSheet adna = new CharacterSheet();
        adna.setId(2L);
        adna.setLogin("asa");
        adna.setName("Adna");
        adna.setRace(1L);
        adna.setCharClass(5L);
        adna.setAlignment("Neutro e Bom");
        adna.setHitPoints(12);
        adna.setStrength(15);
        adna.setDexterity(15);
        adna.setConstitution(15);
        adna.setIntelligence(15);
        adna.setWisdom(15);
        adna.setCharisma(15);
        adna.setArmorClass(10);
        adna.setSpeed(4.5F);
        adna.setLevel(28);


        CharacterSheet coisa = new CharacterSheet();
        coisa.setId(3L);
        coisa.setLogin("asa");
        coisa.setName("Coisa");
        coisa.setRace(2L);
        coisa.setCharClass(2L);
        coisa.setAlignment("Caotico e Bom");
        coisa.setHitPoints(12);
        coisa.setStrength(16);
        coisa.setDexterity(16);
        coisa.setConstitution(16);
        coisa.setIntelligence(16);
        coisa.setWisdom(16);
        coisa.setCharisma(16);
        coisa.setArmorClass(20);
        coisa.setSpeed(6.9F);
        coisa.setLevel(2);


        CharacterSheet mingau = new CharacterSheet();
        mingau.setId(4L);
        mingau.setLogin("asa");
        mingau.setName("Mingau");
        mingau.setRace(3L);
        mingau.setCharClass(3L);
        mingau.setAlignment("Bom");
        mingau.setHitPoints(17);
        mingau.setStrength(2);
        mingau.setDexterity(19);
        mingau.setConstitution(10);
        mingau.setIntelligence(4);
        mingau.setWisdom(3);
        mingau.setCharisma(11);
        mingau.setArmorClass(5);
        mingau.setSpeed(10.8F);
        mingau.setLevel(8);


        CharacterSheet preta = new CharacterSheet();
        preta.setId(5L);
        preta.setLogin("asa");
        preta.setName("Preta");
        preta.setRace(4L);
        preta.setCharClass(4L);
        preta.setAlignment("Leal");
        preta.setHitPoints(13);
        preta.setStrength(5);
        preta.setDexterity(10);
        preta.setConstitution(10);
        preta.setIntelligence(30);
        preta.setWisdom(6);
        preta.setCharisma(25);
        preta.setArmorClass(50);
        preta.setSpeed(25.9F);
        preta.setLevel(7);


        CharacterSheet doby = new CharacterSheet();
        doby.setId(6L);
        doby.setLogin("asa");
        doby.setName("Doby");
        doby.setRace(5L);
        doby.setCharClass(5L);
        doby.setAlignment("Caótico");
        doby.setHitPoints(50);
        doby.setStrength(5);
        doby.setDexterity(15);
        doby.setConstitution(5);
        doby.setIntelligence(1);
        doby.setWisdom(1);
        doby.setCharisma(9);
        doby.setArmorClass(01);
        doby.setSpeed(8.5F);
        doby.setLevel(4);

        CharacterSheet daleke = new CharacterSheet();
        daleke.setId(7L);
        daleke.setLogin("asa");
        daleke.setName("Daleke");
        daleke.setRace(6L);
        daleke.setCharClass(6L);
        daleke.setAlignment("Caótico e Bom");
        daleke.setHitPoints(13);
        daleke.setStrength(15);
        daleke.setDexterity(11);
        daleke.setConstitution(11);
        daleke.setIntelligence(8);
        daleke.setWisdom(4);
        daleke.setCharisma(11);
        daleke.setArmorClass(11);
        daleke.setSpeed(20.5F);
        daleke.setLevel(4);

        CharacterSheet caroco = new CharacterSheet();
        caroco.setId(8L);
        caroco.setLogin("asa");
        caroco.setName("Caroço");
        caroco.setRace(6L);
        caroco.setCharClass(6L);
        caroco.setAlignment("Neutro");
        caroco.setHitPoints(300);
        caroco.setStrength(1);
        caroco.setDexterity(1);
        caroco.setConstitution(25);
        caroco.setIntelligence(4);
        caroco.setWisdom(4);
        caroco.setCharisma(10);
        caroco.setArmorClass(30);
        caroco.setSpeed(0.1F);
        caroco.setLevel(6);

        CharacterSheet jake = new CharacterSheet();
        jake.setId(9L);
        jake.setLogin("asa");
        jake.setName("Jake the Snake");
        jake.setRace(5L);
        jake.setCharClass(6L);
        jake.setAlignment("Leal e Mal");
        jake.setHitPoints(15);
        jake.setStrength(10);
        jake.setDexterity(10);
        jake.setConstitution(10);
        jake.setIntelligence(5);
        jake.setWisdom(4);
        jake.setCharisma(15);
        jake.setArmorClass(16);
        jake.setSpeed(1.5F);
        jake.setLevel(3);

        CharacterSheet fifi = new CharacterSheet();
        fifi.setId(10L);
        fifi.setLogin("asa");
        fifi.setName("Jake the Snake");
        fifi.setRace(5L);
        fifi.setCharClass(6L);
        fifi.setAlignment("Caótico e Mal");
        fifi.setHitPoints(0);
        fifi.setStrength(3);
        fifi.setDexterity(10);
        fifi.setConstitution(4);
        fifi.setIntelligence(7);
        fifi.setWisdom(6);
        fifi.setCharisma(9);
        fifi.setArmorClass(0);
        fifi.setSpeed(0F);
        fifi.setLevel(0);

        CharacterSheet kirito = new CharacterSheet();
        kirito.setId(11L);
        kirito.setLogin("asa");
        kirito.setName("Kirito the Spider");
        kirito.setRace(5L);
        kirito.setCharClass(6L);
        kirito.setAlignment("Caótico e Neutro");
        kirito.setHitPoints(4);
        kirito.setStrength(4);
        kirito.setDexterity(10);
        kirito.setConstitution(5);
        kirito.setIntelligence(4);
        kirito.setWisdom(4);
        kirito.setCharisma(5);
        kirito.setArmorClass(8);
        kirito.setSpeed(5.5F);
        kirito.setLevel(5);

        charactersRepository.saveAll(asList(adno, adna, coisa, mingau, preta, doby, daleke, caroco, jake, fifi, kirito));
    }
}
