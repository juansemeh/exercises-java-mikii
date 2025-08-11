public class Characters {
    String name;
    String power;
    Boolean hasWeapon;
    Boolean isGood;
    Integer health;
    Integer damage;

    public Characters(String name, String power, Boolean hasWeapon, Boolean isGood, Integer health, Integer damage) {
        this.name = name;
        this.power = power;
        this.hasWeapon = hasWeapon;
        this.isGood = isGood;
        this.health = health;
        this.damage = damage;
    }

    public void showCharacter(){
        System.out.println("The name is: " + name);
        System.out.println("The power is: " + power);
        System.out.println("¿Has a weapon?: " + hasWeapon);
        System.out.println("¿Is good?: " + isGood);
        System.out.println("Life ammount: " + health);
        System.out.println("Damage ammount: " + damage);
    }

    public void attack(Characters character){
        if(character.health > 0){
            character.health -= damage;
            System.out.println(character.name + " has been attacked by " + name + " and now has " + character.health + " health");
        } else {
            System.out.println(character.name + " has been defeated by " + name);
        }
    }

    public void heal(Characters character) {
        if(character.health > 0 ) {
            character.health += damage;
            System.out.println(character.name + " has been healed by " + name + " and now has " + character.health + " health");
        } else {
            System.out.println(character.name + " Is downed and cannot be revived by " + name);
        }
    }



    public static void main(String[] args) {
        Characters IronMan = new Characters("Ironman", "Money", true, true, 100, 150);
        Characters Spiderman = new Characters("Spiderman", "Aracnid sense", false, true, 160, 60);
        Characters DoctorStrange = new Characters("Doctor Strange", "Magic", true, true, 200, 100);
    
        IronMan.attack(Spiderman);
        DoctorStrange.heal(Spiderman);
    }

}

