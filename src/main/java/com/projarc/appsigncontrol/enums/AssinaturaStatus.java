package com.projarc.appsigncontrol.enums;

public enum AssinaturaStatus {
    ATIVA,
    INATIVA;

    public static AssinaturaStatus getType(String type) {
        if (type.equals("ATIVA")) {
            return ATIVA;
        }

        if (type.equals("INATIVA")) {
            return INATIVA;
        }

        return null;
    }
}
