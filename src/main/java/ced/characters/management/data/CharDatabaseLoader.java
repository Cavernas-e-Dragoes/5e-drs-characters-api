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
        adna.setId(1L);
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

        charactersRepository.saveAll(asList(adno, adna));
    }
}
