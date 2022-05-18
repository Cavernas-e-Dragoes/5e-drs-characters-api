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

        CharacterSheet adna = new CharacterSheet();
        adna.setId(2L);
        adna.setLogin("asa");
        adna.setName("Adna");
        adna.setRace(1L);
        adna.setCharClass(1L);
        adna.setAlignment("Leal e Bom");
        adna.setHitPoints(13);
        adna.setStrength(20);
        adna.setDexterity(20);
        adna.setConstitution(20);
        adna.setIntelligence(20);
        adna.setWisdom(20);
        adna.setCharisma(20);

        CharacterSheet coisa = new CharacterSheet();
        coisa.setId(3L);
        coisa.setLogin("asa");
        coisa.setName("Coisa");
        coisa.setRace(2L);
        coisa.setCharClass(2L);
        coisa.setAlignment("Leal e Bom");
        coisa.setHitPoints(13);
        coisa.setStrength(20);
        coisa.setDexterity(20);
        coisa.setConstitution(20);
        coisa.setIntelligence(20);
        coisa.setWisdom(20);
        coisa.setCharisma(20);

        CharacterSheet mingau = new CharacterSheet();
        mingau.setId(4L);
        mingau.setLogin("asa");
        mingau.setName("Mingau");
        mingau.setRace(3L);
        mingau.setCharClass(3L);
        mingau.setAlignment("Leal e Bom");
        mingau.setHitPoints(13);
        mingau.setStrength(20);
        mingau.setDexterity(20);
        mingau.setConstitution(20);
        mingau.setIntelligence(20);
        mingau.setWisdom(20);
        mingau.setCharisma(20);

        CharacterSheet preta = new CharacterSheet();
        preta.setId(5L);
        preta.setLogin("asa");
        preta.setName("Preta");
        preta.setRace(4L);
        preta.setCharClass(4L);
        preta.setAlignment("Leal e Bom");
        preta.setHitPoints(13);
        preta.setStrength(20);
        preta.setDexterity(20);
        preta.setConstitution(20);
        preta.setIntelligence(20);
        preta.setWisdom(20);
        preta.setCharisma(20);

        CharacterSheet doby = new CharacterSheet();
        doby.setId(6L);
        doby.setLogin("asa");
        doby.setName("Doby");
        doby.setRace(5L);
        doby.setCharClass(5L);
        doby.setAlignment("Leal e Bom");
        doby.setHitPoints(13);
        doby.setStrength(20);
        doby.setDexterity(20);
        doby.setConstitution(20);
        doby.setIntelligence(20);
        doby.setWisdom(20);
        doby.setCharisma(20);

        CharacterSheet daleke = new CharacterSheet();
        daleke.setId(7L);
        daleke.setLogin("asa");
        daleke.setName("Daleke");
        daleke.setRace(6L);
        daleke.setCharClass(6L);
        daleke.setAlignment("Leal e Bom");
        daleke.setHitPoints(13);
        daleke.setStrength(20);
        daleke.setDexterity(20);
        daleke.setConstitution(20);
        daleke.setIntelligence(20);
        daleke.setWisdom(20);
        daleke.setCharisma(20);

        CharacterSheet caroco = new CharacterSheet();
        caroco.setId(8L);
        caroco.setLogin("asa");
        caroco.setName("Caroço");
        caroco.setRace(6L);
        caroco.setCharClass(6L);
        caroco.setAlignment("Leal e Bom");
        caroco.setHitPoints(13);
        caroco.setStrength(20);
        caroco.setDexterity(20);
        caroco.setConstitution(20);
        caroco.setIntelligence(20);
        caroco.setWisdom(20);
        caroco.setCharisma(20);

        CharacterSheet jake = new CharacterSheet();
        jake.setId(9L);
        jake.setLogin("asa");
        jake.setName("Jake the Snake");
        jake.setRace(5L);
        jake.setCharClass(6L);
        jake.setAlignment("Leal e Bom");
        jake.setHitPoints(13);
        jake.setStrength(20);
        jake.setDexterity(20);
        jake.setConstitution(20);
        jake.setIntelligence(20);
        jake.setWisdom(20);
        jake.setCharisma(20);

        CharacterSheet fifi = new CharacterSheet();
        fifi.setId(10L);
        fifi.setLogin("asa");
        fifi.setName("Jake the Snake");
        fifi.setRace(5L);
        fifi.setCharClass(6L);
        fifi.setAlignment("Leal e Bom");
        fifi.setHitPoints(13);
        fifi.setStrength(20);
        fifi.setDexterity(20);
        fifi.setConstitution(20);
        fifi.setIntelligence(20);
        fifi.setWisdom(20);
        fifi.setCharisma(20);

        CharacterSheet kirito = new CharacterSheet();
        kirito.setId(11L);
        kirito.setLogin("asa");
        kirito.setName("Kirito the Spider");
        kirito.setRace(5L);
        kirito.setCharClass(6L);
        kirito.setAlignment("Leal e Bom");
        kirito.setHitPoints(13);
        kirito.setStrength(20);
        kirito.setDexterity(20);
        kirito.setConstitution(20);
        kirito.setIntelligence(20);
        kirito.setWisdom(20);
        kirito.setCharisma(20);


        charactersRepository.saveAll(asList(adno, adna, coisa, mingau, preta, doby, daleke, caroco, jake, fifi, kirito));
    }
}
