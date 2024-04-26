package cwk4;

import java.io.Serializable;

public enum ChampionType implements Serializable {
    WIZARD("Wizard"),
    WARRIOR("Warrior"),
    DRAGON("Dragon");

    private String name;

    private ChampionType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

