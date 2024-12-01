package com.ced.model.utils;

import lombok.Getter;

@Getter
public enum CharacterClass {
    BARBARO(12),
    BARDO(8),
    BRUXO(8),
    CLERIGO(8),
    DRUIDA(8),
    FEITICEIRO(6),
    GUARDIAO(10),
    GUERREIRO(10),
    LADINO(8),
    MAGO(6),
    MONGE(8),
    PALADINO(10);

    private final int hitDie;

    CharacterClass(int hitDie) {
        this.hitDie = hitDie;
    }
}
