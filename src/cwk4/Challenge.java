package cwk4;

public class Challenge {
    private int number;
    private ChallengeType type;
    private String enemy;
    private int requiredSkillLevel;
    private int reward;

    public Challenge(int number, ChallengeType type, String enemy, int requiredSkillLevel, int reward) {
        this.number = number;
        this.enemy = enemy;
        this.type = type;
        this.requiredSkillLevel = requiredSkillLevel;
        this.reward = reward;
    }


    public int getRequiredSkillLevel() {
        return requiredSkillLevel;
    }

    public int getReward() {
        return reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }

    public String getEnemy() {
        return enemy;
    }

    public void setEnemy(String enemy) {
        this.enemy = enemy;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public ChallengeType getType() {
        return type;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("number : ").append(number).append("\n");
        sb.append("type : ").append(type).append("\n");
        sb.append("enemy : ").append(enemy).append("\n");
        sb.append("requiredSkillLevel : ").append(requiredSkillLevel).append("\n");
        sb.append("reward : ").append(reward).append("\n");
        return sb.toString();
    }
}