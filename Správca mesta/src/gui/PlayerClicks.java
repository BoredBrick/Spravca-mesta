package gui;

import buildings.Building;
import buildings.Storage;
import buildings.housing.House;
import buildings.housing.HousingManager;
import buildings.productionbuildings.IProductionBuilding;
import buildings.productionbuildings.Product;
import buildings.productionbuildings.WorkManager;
import java.io.IOException;
import java.util.HashMap;
import javax.swing.JOptionPane;

/**
 * Trieda reprezentuje všetky druhy kliknutí, ktoré môže hráč urobiť
 *
 * @author Daniel Caban 5ZY016
 */
public class PlayerClicks {

    /**
     * Celkový počet ťažiacich kliknutí, ktoré hráč urobil
     */
    private int totalNumOfMiningClicks = 0;
    /**
     * Zaznamenávanie, koľko kliknutí ešte treba ma vyťaženie daného produkzu
     */
    private HashMap<Product, Integer> clicksToMine;
    /**
     * Násobič kliknutí na vyťaženie, dá sa pomocou upgradu zmenšiť na 1
     */
    private int clickMultiplier = 2;

    public PlayerClicks() {
        this.clicksToMine = new HashMap<>();
        this.initializeClicksNeededToMineProduct();

    }

    /**
     * Kliknutie v prípade, že hráč ide dohrať hru, zapíše sa skore a uzavrie
     * program
     *
     * @param highscore zapisovanie skóre
     * @param storage sklad
     */
    public void gameWinningClick(Highscore highscore, Storage storage) {
        String name;
        while (true) {
            try {
                name = JOptionPane.showInputDialog(null, "Congratulations on winning! Your score is: " + highscore.calculateHighscore(storage, this) + "\nPlease enter your name:");
                if (name.equals("") || name.length() > 12 )  {
                    throw new IllegalArgumentException();
                } else {
                    break;
                }
            } catch (IllegalArgumentException e) {
                continue;
            }
        }
        try {
            highscore.writeHighscore(name, storage, this);
            System.exit(0);
        } catch (IOException e) {
            System.out.println("Could not save highscore");
            System.exit(0);
        }

    }

    /**
     * Kúpa hocijakej budovy
     *
     * @param buying budova na nákup
     * @param storage sklad na kontrolu surovín
     * @param houseManager manažér bytových jednotiek
     * @param workManager manažér workshopov
     */
    public void buyBuildingClick(Building buying, Storage storage, HousingManager houseManager, WorkManager workManager) {
        if (storage.enoughMaterialsToBuild(buying)) {
            storage.buyABuilding(buying);
            if (buying instanceof House) {
                houseManager.addBuilding((House)buying);
            } else if (buying instanceof IProductionBuilding) {
                workManager.addWorkshop((IProductionBuilding)buying);
            }
        }

    }

    /**
     * Kliknutie, vykonáva sa, keď hráč kliká na ťažiace políčko
     *
     * @param mining Produkt, ktorý ťažíme
     * @param storage sklad
     * @return True, ak sme vyťažili produkt, inakšie false
     */
    public boolean playerMiningClick(Product mining, Storage storage) {
        if (this.clicksToMine.get(mining) != 1) {
            this.clicksToMine.put(mining, this.clicksToMine.get(mining) - 1);
            this.totalNumOfMiningClicks++;
            return false;
        } else {
            this.clicksToMine.put(mining, this.clicksNeededToMineProduct(mining));
            storage.addToStorage(mining, 1);
            this.totalNumOfMiningClicks++;
            return true;
        }
    }

    /**
     * Zamestnanie obyvateľa na produkciu produktu
     *
     * @param workManager manažér workshopov
     * @param housingManager manažér bytových jednotiek
     * @param product produkt na produkciu
     * @param workers počet na zamestnanie
     */
    public void employVillagersClick(WorkManager workManager, HousingManager housingManager, Product product, int workers) {
        workManager.employWorkersOnClick(housingManager, product, workers);
    }

    /**
     * Vyhodenie obyvateĺa z produkcie produktu
     *
     * @param workManager manažér workshopov
     * @param product produkt
     * @param workers počet pracujúcich
     */
    public void fireVillagersClick(WorkManager workManager, Product product, int workers) {
        workManager.fireWorkersOnClick(product, workers);
    }

    /**
     * Vylepšenie ťaženia, o polovicu rýchlejšie
     */
    public void upgradePickaxe() {
        this.clickMultiplier = 1;
        this.initializeClicksNeededToMineProduct();
    }

    public int getTotalNumOfMiningClicks() {
        return this.totalNumOfMiningClicks;
    }

    /**
     * Počet kliknutí potrebných na vyťaženie daného produktu
     *
     * @param product Produkt na ťaženie
     * @return potrebný počet kliknutí
     */
    private int clicksNeededToMineProduct(Product product) {
        switch (product) {
            case WOOD:
                return 1 * this.clickMultiplier;
            case IRON:
                return 2 * this.clickMultiplier;
            case GOLD:
                return 5 * this.clickMultiplier;
            case MEAT:
                return 2 * this.clickMultiplier;
            default:
                return 0;
        }
    }

    /**
     * Inicializácia potrebných kliknutí
     */
    private void initializeClicksNeededToMineProduct() {
        for (Product value : Product.values()) {
            this.clicksToMine.put(value, this.clicksNeededToMineProduct(value));
        }
    }

}
