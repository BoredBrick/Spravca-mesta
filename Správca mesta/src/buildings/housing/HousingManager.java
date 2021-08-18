package buildings.housing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
/**
 * Trieda spravuje všetky bytové jednotky a všetkých obyvateľov
 * @author Daniel Caban 5ZY016
 */
public class HousingManager {
    /**
     * Zoznam všetkých bytových jednotiek
     */
    private ArrayList<House> houses;
    /**
     * Počet každej bytovej jednotky
     */
    private HashMap<HousingTypes, Integer> numOfEachHouse;
    /**
     * Počet voľných postelí vo všetkých jednotkách
     */
    private int totalFreeBeds = 0;
    /**
     * Počet obyvateľov
     */
    private int numOfVillagers = 0;

    public HousingManager() {
        this.houses = new ArrayList<>();
        this.numOfEachHouse = new HashMap<>();
        for (HousingTypes value : HousingTypes.values()) {
            this.numOfEachHouse.put(value, 0);
        }
    }
    /**
     * Počítanie všetkých voľných postelí
     */
    public void calculateTotalFreeBeds() {
        int beds = 0;
        for (House house : this.houses) {
            beds += house.getFreeBeds();
        }
        this.totalFreeBeds = beds;
    }
    /**
     * Pridanie bytovej jednotky do zoznamu
     * @param house bytová jednotka na pridanie
     */
    public void addBuilding(House house) {
        this.houses.add(house);
        this.totalFreeBeds += house.getFreeBeds();
        this.numOfEachHouse.put(house.getType(), this.numOfEachHouse.get(house.getType()) + 1);
    }

    /**
     * Pridanie nových obyvateľov
     * @param count Počet nových obyvateľov
     */
    public void addVillager(int count) {
        this.houseNewVillagers(count);
    }
    /**
     * Metóda náhodne vygeneruje nových obyvateľov a ubytuje ich
     * @return Oznamovaciu správu o nových obyvateľoch
     */
    public String spawnVillager() {
        Random rand = new Random();
        int dice = rand.nextInt(6) + 1;
        switch (dice) {
            case 1:
                this.houseNewVillagers(1);
                return "A lonesome wanderer arrives";
            case 2:
                this.houseNewVillagers(2);
                return "A couple seeks shelter in one of our beds";
            case 3:
                this.houseNewVillagers(3);
                return "A small gropu of friends wishes to stay with us";
            case 4:
                this.houseNewVillagers(4);
                return "A tired family wants to be a part of our village";
            case 5:
                this.houseNewVillagers(10);
                return "Group of survivors joins forces with us";
            case 6:
                this.houseNewVillagers(30);
                return "Caravana becomes part of our village";
        }
        return "";
    }
    
    /**
     * Metóda rozloží obyvateľov do jenotlivých bytových jednotiek
     * @param villagers Počet na ubytovanie
     */
    public void houseNewVillagers(int villagers) {
        int remaining = villagers;
        for (int i = 0; i < this.houses.size(); i++) {
            int beds = this.houses.get(i).getFreeBeds();
            if (remaining == 0) {
                break;
            } else if (beds >= remaining) {
                this.houses.get(i).addVillagers(remaining);
                this.numOfVillagers += remaining;
                this.calculateTotalFreeBeds();
                break;
            } else if (beds > 0) {
                this.houses.get(i).addVillagers(beds);
                remaining -= beds;
                this.numOfVillagers += beds;
                this.calculateTotalFreeBeds();
            } else {
                continue;
            }
        }
    }

    /**
     * Metóda vyhorí jeden dom, odráda počet voľných posteli aj celkový počet jednotiek
     * @param house Dom na vypálenie
     */
    public void burnHouse(House house) {
        this.numOfVillagers -= house.getOccupiedBeds();
        this.numOfEachHouse.put(house.getType(), this.numOfEachHouse.get(house.getType()) - 1);
        this.houses.remove(house);
        this.calculateTotalFreeBeds();

    }
    /**
     * Metóda náhodne zabije obyvateľov
     * @param count Počet ľudí na zabitie
     */
    public void killVillagers(int count) {
        int alive = count;
        while (true) {
            for (House house : this.houses) {
                if (house.getOccupiedBeds() > 0) {
                    if (alive == 0) {
                        break;
                    }
                    house.removeVillagers(1);
                    this.numOfVillagers -= 1;
                    alive--;
                }
            }
            if (alive == 0) {
                this.calculateTotalFreeBeds();
                break;
            }
        }

    }

    /**
     * Výpočet, koľko mäsa treba na nakŕmenie všetkých obyvateľov
     * @return Potrebné mäso na nakŕmenie
     */
    public int meatEaten() {
        int villagers = this.getNumOfVillagers();
        final int oneMeatFeedsHowManyVillagers = 10;
        return villagers / oneMeatFeedsHowManyVillagers;
    }

    public int getTotalFreeBeds() {
        return this.totalFreeBeds;
    }

    public int getNumOfVillagers() {
        return this.numOfVillagers;
    }

    public int getNumOfHouseType(HousingTypes type) {
        return this.numOfEachHouse.get(type);
    }

    public ArrayList<House> getHouses() {
        return this.houses;
    }

}
