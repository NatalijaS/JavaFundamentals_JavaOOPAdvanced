package _04_EnumerationsAndAnnotations_Exercises._10_InfernoInfinity;

public class Weapon {

    private WeaponType weaponType;
    private String name;
    private GemType[] gems;

    Weapon(WeaponType weaponType, String name) {
        this.setWeaponType(weaponType);
        this.setName(name);
        this.setGems();
    }

    private void setWeaponType(WeaponType weaponType) {
        this.weaponType = weaponType;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setGems() {
        this.gems = new GemType[this.weaponType.getSockets()];
    }

    private int getMinDamage() {
        int totalBonus = this.getBonus(2, 1);
        return this.weaponType.getMinDamage() + totalBonus;
    }

    private int getMaxDamage() {
        int totalBonus = this.getBonus(3, 4);
        return this.weaponType.getMaxDamage() + totalBonus;
    }

    private int getBonus(int bonusStrength, int bonusAgility) {
        int strengthBonus = 0;
        for (GemType gem : this.gems) {
            if (gem != null) {
                strengthBonus += gem.getStrength() * bonusStrength;
            }
        }

        int agilityBonus = 0;
        for (GemType gem : this.gems) {
            if (gem != null) {
                agilityBonus += gem.getAgility() * bonusAgility;
            }
        }

        return strengthBonus + agilityBonus;
    }

    private int getStrength() {
        int totalStrength = 0;
        for (GemType gem : this.gems) {
            if (gem != null) {
                totalStrength += gem.getStrength();
            }
        }
        return totalStrength;
    }

    private int getAgility() {
        int totalAgility = 0;
        for (GemType gem : this.gems) {
            if (gem != null) {
                totalAgility += gem.getAgility();
            }
        }
        return totalAgility;
    }

    private int getVitality() {
        int totalVitality = 0;
        for (GemType gem : this.gems) {
            if (gem != null) {
                totalVitality += gem.getVitality();
            }
        }
        return totalVitality;
    }

    void addGem(GemType gemType, int socketIndex) {
        try {
            this.gems[socketIndex] = gemType;
        } catch (IndexOutOfBoundsException ignored) {
        }
    }

    void removeGem(int socketIndex) {
        try {
            this.gems[socketIndex] = null;
        } catch (IndexOutOfBoundsException ignored) {
        }
    }

    @Override
    public String toString() {
        return String.format("%s: %d-%d Damage, +%d Strength, +%d Agility, +%d Vitality", this.name,
                this.getMinDamage(), this.getMaxDamage(), this.getStrength(), this.getAgility(), this.getVitality());
    }
}
