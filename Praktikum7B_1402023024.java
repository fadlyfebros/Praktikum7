// Interface HaveUltimateAbility
interface HaveUltimateAbility {
    String getPowerName();

    int getPower();

    int attack();
}

// Interface Weaponed
interface Weaponed {
    String getWeaponName();

    int getWeaponPower();
}

// Class Character
class Character implements HaveUltimateAbility, Weaponed {
    private String characterName;
    private String origin;
    private String epithet;
    private int bounty;
    private int health = 100;
    private String weaponName;
    private int weaponPower;

    // Constructor
    public Character(String characterName, String origin, String epithet, int bounty) {
        this.characterName = characterName;
        this.origin = origin;
        this.epithet = epithet;
        this.bounty = bounty;
    }

    // Getters and Setters
    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getEpithet() {
        return epithet;
    }

    public void setEpithet(String epithet) {
        this.epithet = epithet;
    }

    public int getBounty() {
        return bounty;
    }

    public void setBounty(int bounty) {
        this.bounty = bounty;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    // Implementasi dari interface HaveUltimateAbility
    @Override
    public String getPowerName() {
        return "Default Power";
    }

    @Override
    public int getPower() {
        return 0;
    }

    @Override
    public int attack() {
        return 0;
    }

    // Implementasi dari interface Weaponed
    @Override
    public String getWeaponName() {
        return weaponName;
    }

    @Override
    public int getWeaponPower() {
        return weaponPower;
    }

    // Setter untuk senjata
    public void setWeapon(String weaponName, int weaponPower) {
        this.weaponName = weaponName;
        this.weaponPower = weaponPower;
    }
}

// Class StrawHat
class StrawHat extends Character {
    private String profession;

    // Constructor
    public StrawHat(String characterName, String origin, String epithet, int bounty, String profession) {
        super(characterName, origin, epithet, bounty);
        this.profession = profession;
    }

    public String getProfession() {
        return profession;
    }

    // Implementasi dari interface HaveUltimateAbility
    @Override
    public String getPowerName() {
        return "Sanzen Sekai";
    }

    @Override
    public int getPower() {
        return 20;
    }

    @Override
    public int attack() {
        return getWeaponPower() + getPower();
    }
}

// Class Beast
class Beast extends Character {
    private String division;

    // Constructors
    public Beast(String characterName, String origin, String epithet, int bounty, String division) {
        super(characterName, origin, epithet, bounty);
        this.division = division;
    }

    public Beast(String characterName, String epithet, int bounty, String division) {
        super(characterName, "", epithet, bounty);
        this.division = division;
    }

    public String getDivision() {
        return division;
    }

    // Implementasi dari interface HaveUltimateAbility
    @Override
    public String getPowerName() {
        return "Ocean Blast";
    }

    @Override
    public int getPower() {
        return 18;
    }

    @Override
    public int attack() {
        return getWeaponPower() + getPower();
    }
}

public class Praktikum7B_1402023024 {
    public static void main(String[] args) {
        // Array of Object StrawHat
        StrawHat[] strawHats = {
                new StrawHat("Roronoa Zoro", "West Blue", "Pirate Hunter", 320_000_000, "Combotant"),
                new StrawHat("Usopp", "East Blue", "Sogeking", 200_000_000, "Sniper")
        };

        // Set senjata untuk masing-masing StrawHat
        strawHats[0].setWeapon("Samurai", 9);
        strawHats[1].setWeapon("Ketapel", 4);

        // Array of Object Beast
        Beast[] beasts = {
                new Beast("King", "North Blue", "King the Wildfire", 1_390_000_000, "All-Stars"),
                new Beast("Queen", "Queen the Plague", 1_320_000_000, "Tobiroppo")
        };

        // Set senjata untuk masing-masing Beast
        beasts[0].setWeapon("Kapak", 12);
        beasts[1].setWeapon("Pistol", 7);

        // Tampilkan data StrawHat
        System.out.println("Straw Hats:");
        for (StrawHat strawHat : strawHats) {
            displayCharacterDetails(strawHat);
        }
        System.out.println();

        // Tampilkan data Beast
        System.out.println("Beasts:");
        for (Beast beast : beasts) {
            displayCharacterDetails(beast);
        }
        System.out.println();

        // Lakukan pertempuran antara Roronoa Zoro dan King
        battle(strawHats[0], beasts[0]);
    }

    // Method battle
    public static void battle(Character a, Character b) {
        displayCharacterDetails(a);
        displayCharacterDetails(b);

        while (b.getHealth() > 0) {
            System.out.println("=============================================");
            System.out.println(a.getCharacterName() + " Menyerang karakter " + b.getCharacterName());
            System.out.println("Memakai jurus -> " + a.getPowerName() + " Dengan Damage Jurus -> " + a.getPower());
            System.out.println(
                    "Memakai senjata -> " + a.getWeaponName() + " Dengan Damage Senjata -> " + a.getWeaponPower());
            int totalAttack = a.attack();
            System.out.println("Total serangan " + a.getCharacterName() + " Ke karakter " + b.getCharacterName()
                    + " Adalah " + totalAttack);
            System.out.println("=============================================");

            b.setHealth(b.getHealth() - totalAttack);
            if (b.getHealth() < 0) {
                b.setHealth(0);
            }

            System.out.println("Darah " + b.getCharacterName() + " Saat ini tersisa -> " + b.getHealth());
            System.out.println("=============================================");
        }
        System.out.println("Harga Buronan " + a.getCharacterName() + " Menjadi -> " + (a.getHealth() * 100_000));
        System.out.println("=============================================");

        displayCharacterDetails(a);
        displayCharacter(b);
    }

    // Helper method to display character details
    public static void displayCharacterDetails(Character character) {
        System.out.println("Nama Karakter    : " + character.getCharacterName());
        System.out.println("Darah Karakter   : " + character.getHealth());
        System.out.println("Asal             : " + character.getOrigin());
        System.out.println("Julukan          : " + character.getEpithet());
        System.out.println("Harga Buronan    : " + character.getBounty());
        System.out.println("Nama Senjata     : " + character.getWeaponName());
        System.out.println("Kekuatan Senjata : " + character.getWeaponPower());
        System.out.println();
    }

    public static void displayCharacter(Character character) {
        System.out.println("Nama Karakter    : " + character.getCharacterName());
        System.out.println("Asal             : " + character.getOrigin());
        System.out.println("Julukan          : " + character.getEpithet());
        System.out.println("Harga Buronan    : " + character.getBounty());
        System.out.println("Darah Karakter   : " + character.getHealth());
        System.out.println("Nama Senjata     : " + character.getWeaponName());
        System.out.println("Kekuatan Senjata : " + character.getWeaponPower());
        System.out.println();
    }
}
