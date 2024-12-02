package com.ced.model.enums;

public enum Race {
    ELFO("elfo"),
    PEQUENINO("pequenino"),
    ANAO("anao"),
    GNOMO("gnomo"),
    DRACONATO("draconato"),
    TIFERINO("tiferino"),
    MEIO_ORC("meio-orc"),
    HUMANO("humano"),
    MEIO_ELFO("meio-elfo");

    private final String index;

    Race(String index) {
        this.index = index;
    }

    public String getIndex() {
        return index;
    }

    public static Race fromIndex(String index) {
        for (Race race : values()) {
            if (race.index.equalsIgnoreCase(index)) {
                return race;
            }
        }
        throw new IllegalArgumentException("Raça inválida: " + index);
    }
}
