package com.datachampions.Data.Champions.enums;

public enum QueueType {


    NORMAL_DRAFT(400, "Normal Draft"),
    RANKED_SOLO_DUO(420, "Ranked Solo/Duo"),
    NORMAL_BLIND(430, "Normal Blind"),
    RANKED_FLEX(440, "Ranked Flex"),
    ARAM(450, "ARAM"),
    CLASH(700, "Clash"),
    ARURF(900, "ARURF"),
    URF(1900, "URF"),
    TUTORIAL(2000, "Tutorial"),
    OTHER(-1, "Other");

    private final int code;
    private final String description;

    QueueType(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public static QueueType fromCode(int code) {
        for (QueueType qt : values()) {
            if (qt.code == code) {
                return qt;
            }
        }
        return OTHER;
    }
}



