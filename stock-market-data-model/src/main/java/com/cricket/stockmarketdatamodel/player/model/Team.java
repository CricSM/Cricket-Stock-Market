package com.cricket.stockmarketdatamodel.player.model;

import java.util.HashSet;
import java.util.Set;

public enum Team {
    INDIA,
    AUSTRALIA,
    ENGLAND,
    NEWZEALAND,
    PAKISTAN,
    BANGLADESH,
    SRILANKA,
    WESTINDIES,
    AFGANISTAN,
    ZIMBABWE;

    public static Set<String> INTERNATIONAL_TEAM_SET;

    static {
        INTERNATIONAL_TEAM_SET = new HashSet<>();
        for (Team team : Team.values()) {
            INTERNATIONAL_TEAM_SET.add(team.name());
        }
    }
}
