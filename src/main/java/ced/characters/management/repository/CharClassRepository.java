package ced.characters.management.repository;

import ced.characters.management.models.CharClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharClassRepository extends JpaRepository<CharClass, Long> {
}
