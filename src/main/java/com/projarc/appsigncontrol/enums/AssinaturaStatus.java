package com.projarc.appsigncontrol.enums;

import javax.naming.NameNotFoundException;

public enum AssinaturaStatus {
    ATIVA,
    INATIVA;

    public static AssinaturaStatus getType(String type) throws NameNotFoundException {
        if (type.equals("ATIVA")) {
            return ATIVA;
        }

        if (type.equals("INATIVA")) {
            return INATIVA;
        }

        throw new NameNotFoundException("Invalid type");
    }
}
