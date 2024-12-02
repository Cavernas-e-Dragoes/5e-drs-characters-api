package com.ced.model.enums;

public enum Subrace {
    ANAO_DA_COLINA("anao-da-colina"),
    ELFO_ALTO("elfo-alto"),
    HALFLING_PES_LEVES("halfling-pes-leves"),
    GNOMO_DAS_ROCHAS("gnomo-das-rochas");

    private final String index;

    Subrace(String index) {
        this.index = index;
    }

    public String getIndex() {
        return index;
    }

    public static Subrace fromIndex(String index) {
        for (Subrace subrace : values()) {
            if (subrace.index.equalsIgnoreCase(index)) {
                return subrace;
            }
        }
        throw new IllegalArgumentException("Subraça inválida: " + index);
    }
}
