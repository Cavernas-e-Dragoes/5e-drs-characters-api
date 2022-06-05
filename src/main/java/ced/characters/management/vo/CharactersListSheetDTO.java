package ced.characters.management.vo;

import ced.characters.management.models.Equipment;
import ced.characters.management.models.Magic;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CharactersListSheetDTO {

    private Long id;

    private String raceName;

    private String className;

    private String name;

    private Integer level;

}
