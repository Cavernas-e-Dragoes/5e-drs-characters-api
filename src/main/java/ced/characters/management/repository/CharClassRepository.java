package ced.characters.management.repository;

import ced.characters.management.models.CharClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharClassRepository extends JpaRepository<CharClass, Long> {
}
