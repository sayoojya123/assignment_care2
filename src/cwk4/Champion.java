package cwk4;


public class Champion {
    private String name;
    private int skillLevel;
    private boolean necromancer;
    private int entryFee;
    private String spellSpeciality;
    private String weapon;
    private boolean talks;
    private ChampionType championType;
    private ChampionState championState;

    public Champion(String name, int skillLevel, boolean necromancer, int entryFee, String spellSpeciality, String weapon, boolean talks, ChampionType championType) {
        this.name = name;
        this.skillLevel = skillLevel;
        this.necromancer = necromancer;
        this.entryFee = entryFee;
        this.spellSpeciality = spellSpeciality;
        this.weapon = weapon;
        this.talks = talks;
        this.championType = championType;
        this.championState = ChampionState.WAITING;

    }

    @Override
    public String toString() {
        return "Name: " + name +
                "\nSkill level: " + skillLevel +
                "\nNecromancer: " + (necromancer ? "yes" : "no") +
                "\nEntry fee: " + entryFee +
                "\nSpell Speciality: " + spellSpeciality +
                "\nWeapon: " + weapon +
                "\nTalks: " + (talks ? "yes" : "no") +
                "\nChampion Type: " + championType;
    }

    // getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(int skillLevel) {
        this.skillLevel = skillLevel;
    }

    public boolean isNecromancer() {
        return necromancer;
    }

    public void setNecromancer(boolean necromancer) {
        this.necromancer = necromancer;
    }

    public int getEntryFee() {
        return entryFee;
    }

    public void setEntryFee(int entryFee) {
        this.entryFee = entryFee;
    }

    public String getSpellSpeciality() {
        return spellSpeciality;
    }

    public void setSpellSpeciality(String spellSpeciality) {
        this.spellSpeciality = spellSpeciality;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public boolean isTalks() {
        return talks;
    }

    public void setTalks(boolean talks) {
        this.talks = talks;
    }

    public ChampionType getChampionType() {
        return championType;
    }

    public void setChampionType(ChampionType championType) {
        this.championType = championType;
    }

    public ChampionState getChampionState() {
        return championState;
    }

    public void setChampionState(ChampionState championState) {
        this.championState = championState;
    }

    public boolean isInReserve() {
        return championState == ChampionState.WAITING;
    }

    public boolean isEntered() {
        return championState == ChampionState.ENTERED;
    }

    public void setInReserve() {

        this.championState = ChampionState.WAITING;

    }


    public void setAsEntered() {

        this.championState = ChampionState.ENTERED;

    }


    public void setAsDisqualified() {

        this.championState = ChampionState.DISQUALIFIED;

    }

    public boolean isDisqualified() {
        return championState == ChampionState.DISQUALIFIED;
    }
}