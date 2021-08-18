package buildings.housing;

import buildings.Building;
/**
 * Trieda reprezentuje bytovú jednotku v ktorej môžu obyvatelia žiť
 * @author Daniel Caban 5ZY016
 */
public class House extends Building {
    /**
     * Počet neobsadených postelí
     */
    private int freeBeds;
    /**
     * Počet obsadených postelí
     */
    private int occupiedBeds = 0;
    /**
     * Typ bytovej jednotky
     */
    private HousingTypes type;

    public House(int price, int woodReq, int steelReq, HousingTypes type) {
        super(price, woodReq, steelReq);
        this.type = type;
        this.freeBeds = this.calculateFreeBeds();
    }
    /**
     * Ubytovanie obyvateľov
     * @param villagers Počet ubytovávaných
     * @return True, ak boli všetci úspešne ubytovaní, inak false
     */
    public boolean addVillagers(int villagers) {
        if (this.freeBeds >= villagers) {
            this.freeBeds -= villagers;
            this.occupiedBeds += villagers;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Odubytovanie obyvateľov
     * @param villagers Počet odubytovaných
     * @return True, ak boli všetci úspešne odubytovaní, inak false
     */
    public boolean removeVillagers(int villagers) {
        if (this.occupiedBeds >= villagers) {
            this.freeBeds += villagers;
            this.occupiedBeds -= villagers;
            return true;
        } else {
            return false;
        }
    }

    public int getFreeBeds() {
        return this.freeBeds;
    }

    public HousingTypes getType() {
        return this.type;
    }

    public int getOccupiedBeds() {
        return this.occupiedBeds;
    }

    /**
     * Metóda vráti počet postelí podľa toho o akú bytovú jednotku sa jedná
     * @return Počet miest na ubytovanie
     */
    private int calculateFreeBeds() {
        switch (this.type) {
            case TENT:
                return 2;
            case HUT:
                return 4;
            case HOUSE:
                return 8;
            case BLOCK_OF_FLATS:
                return 32;
            case HIGH_RISE_BUILDING:
                return 128;
            case STREET_OF_HOUSES:
                return 250;
            default:
                return 0;
        }
    }

}
