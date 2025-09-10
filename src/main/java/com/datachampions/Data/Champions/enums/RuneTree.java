package com.datachampions.Data.Champions.enums;

public enum RuneTree {

    PRECISION(8100, "Precision"),
    DOMINATION(8300, "Domination"),
    SORCERY(8000, "Sorcery"),
    RESOLVE(8400, "Resolve"),
    INSPIRATION(8200, "Inspiration");

    private final int id;
    private final String displayName;

    RuneTree(int id, String displayName) {
        this.id = id;
        this.displayName = displayName;
    }

    public int getId() {
        return id;
    }

    public String getDisplayName() {
        return displayName;
    }
}
