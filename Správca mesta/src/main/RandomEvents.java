package main;

import buildings.Building;
import buildings.Storage;
import buildings.housing.House;
import buildings.housing.HousingManager;
import buildings.productionbuildings.IProductionBuilding;
import buildings.productionbuildings.Product;
import buildings.productionbuildings.WorkManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
/**
 * Trieda predstavuje všetky náhodné udalosti, ktoré môžu nastať
 * @author Daniel Caban 5ZY016
 */
public class RandomEvents {

    public RandomEvents() {
    }
    /**
     * Vygenerovanie náhodného eventu
     * @param hManager správca workshopov
     * @param wManager správca bytových jednotiek
     * @param storage sklad
     * @return Oznamovaciu správu o tom, čo sa stalo
     */
    public String generateEvent(HousingManager hManager, WorkManager wManager, Storage storage) {
        Random random = new Random();
        double roll = random.nextInt();
        if (roll < 0.3) {
            return "Nothing interesting happened";
        } else if (roll < 0.6) {
            if (hManager.getNumOfVillagers() > 20) {
                return this.burnRandomBuilding(hManager, wManager);
            } else {
                return "Nothing interesting happened";
            }
        } else {
            return this.randomlyFound(storage);
        }
    }

    private ArrayList<Building> shuffleAllBuildingsList(HousingManager hManager, WorkManager wManager) {
        ArrayList<Building> buildings = new ArrayList<>();
        ArrayList<IProductionBuilding> productionBuildings = wManager.getAllBuildings();
        ArrayList<House> houses = hManager.getHouses();
        for (IProductionBuilding building : productionBuildings) {
            buildings.add((Building)building);
        }
        for (House house : houses) {
            buildings.add(house);
        }
        Collections.shuffle(buildings);
        return buildings;
    }
    /**
     * Zhorenie náhodnej budovy, či už bytovej jednotky alebo workshopu
     * @param hManager manažer bytových jednotiek
     * @param wManager manažér workshopov
     * @return Správu o budove, ktorá zhorela a počet mŕtvych obyvateľov
     */
    private String burnRandomBuilding(HousingManager hManager, WorkManager wManager) {
        ArrayList<Building> buildings = this.shuffleAllBuildingsList(hManager, wManager);
        Random random = new Random();
        Building burning = buildings.get(random.nextInt(buildings.size()));
        if (burning instanceof House) {
            wManager.killVillager(((House)burning).getOccupiedBeds());
            hManager.burnHouse((House)burning);
            return "One of our buildings has burned down. " + ((House)burning).getOccupiedBeds() + " perished in the fire";
        } else if (burning instanceof IProductionBuilding) {
            int died = random.nextInt(((IProductionBuilding)burning).getPositions());
            int burningPositions = ((IProductionBuilding)burning).getPositions();
            int occupiedType = wManager.getOccupiedPositions(((IProductionBuilding)burning).getProduct());
            if (burningPositions > occupiedType) {
                died = occupiedType;
                if (died != 0) {
                    died = random.nextInt(died);
                }
            }

            wManager.removeWorkshop((IProductionBuilding)burning);
            hManager.killVillagers(died);
            return "One of our workshops burned down, killing " + died + " in the process";

        }
        return "";
    }
    /**
     * Náhodné nájdenie náhodného počta náhodného produktu
     * @param storage sklad
     * @return Správu o nájdenom produkte a množstve
     */
    private String randomlyFound(Storage storage) {
        Random random = new Random();
        double roll = random.nextDouble();
        Product product = null;
        int found = 0;
        if (roll < 0.5) {
            found = random.nextInt(150) + 50;
            storage.addToStorage(Product.WOOD, found);
            product = Product.WOOD;
        } else if (roll < 0.8) {
            found = random.nextInt(50) + 10;
            storage.addToStorage(Product.MEAT, found);
            product = Product.MEAT;

        } else {
            found = random.nextInt(200) + 20;
            storage.addToStorage(Product.GOLD, found);
            product = Product.GOLD;
        }
        return "Our scouters found a hidden stash containing " + found + " of " + product.name();
    }

}
