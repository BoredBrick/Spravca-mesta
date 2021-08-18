package buildings.productionbuildings;

import buildings.Storage;
import buildings.housing.HousingManager;
import java.util.ArrayList;
import java.util.HashMap;
/**
 * Trieda spravujúca všetky workshopy v našej dedine, slúži na zamestnávanie obyvateľov a produkciu produktov
 * @author Daniel Caban
 */
public class WorkManager {
    /**
     * Zoznam všetkých workshopov
     */
    private ArrayList<IProductionBuilding> allBuildings;
    /**
     * Počet každého workshopu
     */
    private HashMap<WorkshopType, Integer> numOfEachWorkshop;
    /**
     * Počet voľných pozícii pri výrobe každého produktu
     */
    private HashMap<Product, Integer> freePositions;
    /**
     * Počet obsadených pozícii pri výrobe každého produktu
     */
    private HashMap<Product, Integer> occupiedPositions;
    
    /**
     *  Vytvorenie manažéra
     */
    public WorkManager() {
        this.allBuildings = new ArrayList<>();
        this.numOfEachWorkshop = new HashMap<>();
        this.freePositions = new HashMap<>();
        this.occupiedPositions = new HashMap<>();
        this.initialize();
    }
    
    /**
     * Pridanie workshopu, upravenie dostupných pracovných pozícii a počtu daného workshopu
     * @param workshop Workshop na pridanie
     */
    public void addWorkshop(IProductionBuilding workshop) {
        this.allBuildings.add(workshop);
        WorkshopType type = workshop.getWorkshop();
        Product product = workshop.getProduct();
        this.numOfEachWorkshop.put(type, this.numOfEachWorkshop.get(type) + 1);
        this.freePositions.put(product, this.freePositions.get(product) + workshop.getPositions());
    }
    /**
     * Metóda pre kliknutie, počas ktorého bude pridelený zamestnanec do určeného workshopu
     * @param housingManager ubytovací manažér, poskytne nezamestnaného obyvateľa, ak nejaký je
     * @param product produkcia produktu, ktorú chceme obsadiť
     * @param workers počet ľudí na zamestnanie
     */
    public void employWorkersOnClick(HousingManager housingManager, Product product, int workers) {
        int unemployed = housingManager.getNumOfVillagers() - this.numOfEmployedVillagers();
        if (workers > unemployed) {
            workers = unemployed;
        }
        if (this.freePositions.get(product) >= workers) {
            this.freePositions.put(product, this.freePositions.get(product) - workers);
            this.occupiedPositions.put(product, this.occupiedPositions.get(product) + workers);
        } else {
            int maxEmployable = this.freePositions.get(product);
            this.freePositions.put(product, this.freePositions.get(product) - maxEmployable);
            this.occupiedPositions.put(product, this.occupiedPositions.get(product) + maxEmployable);
        }

    }
    
    /**
     * Vymazanie workshopu zo zoznamu, odstráni sa počet pozícii aj ich celkový
     * @param workshop Workshop na odstránenie
     */
    public void removeWorkshop(IProductionBuilding workshop) {
        int positions = workshop.getPositions();
        WorkshopType type = workshop.getWorkshop();
        Product product = workshop.getProduct();
        this.allBuildings.remove(workshop);
        this.numOfEachWorkshop.put(type, this.numOfEachWorkshop.get(type) - 1);

        this.freePositions.put(product, this.freePositions.get(product) - positions);
        if (this.occupiedPositions.get(product) < positions) {
            positions = this.occupiedPositions.get(product);
        }
        this.occupiedPositions.put(product, this.occupiedPositions.get(product) - positions);
    }
    
    /**
     * Metóda pre kliknutie, odzamestná daný počet ľudí z pozície produkovania produktu
     * @param product Pozícia z ktorej vyhadzujeme
     * @param workers Počet ľudí na vyhodenie
     */
    public void fireWorkersOnClick(Product product, int workers) {
        if (this.occupiedPositions.get(product) >= workers) {
            this.freePositions.put(product, this.freePositions.get(product) + workers);
            this.occupiedPositions.put(product, this.occupiedPositions.get(product) - workers);
        } else {
            int maxFireable = this.occupiedPositions.get(product);
            this.freePositions.put(product, this.freePositions.get(product) + maxFireable);
            this.occupiedPositions.put(product, this.occupiedPositions.get(product) - maxFireable);
        }
    }
    
    /**
     * Náhodne zabijeme daný počet ľudí
     * @param count Počet ľudí na zabitie
     */
    public void killVillager(int count) {
        HashMap<Product, Integer> localOccupied = this.occupiedPositions;
        int alive = count;
        int positions = this.totalOccupied();
        if (alive > positions) {
            alive = positions;
        }
        while (true) {
            for (Product position :localOccupied.keySet()) {
                if (localOccupied.get(position) > 0) {
                    if (alive == 0) {
                        break;
                    }
                    this.fireWorkersOnClick(position, 1);
                    alive--;
                }
            }
            if (alive == 0) {
                break;
            }
        }
    }
    /**
     * Metóda vypočíta, koľko akého produktu sa vyprodukuje za každú jednotku času.
     * @param storage Sklad, budeme ukladať záznam o produktoch
     * @return HashMap obsahujúci počet vyrobeného každého produktu
     */
    public HashMap<Product, Integer> calculateNewProductsEveryTick(Storage storage) {
        HashMap<Product, Integer> counter = new HashMap<>();
        for (Product product : this.occupiedPositions.keySet()) {
            counter.put(product, this.occupiedPositions.get(product));
        }
        HashMap<Product, Product> consumedProduced = new HashMap<>();
        for (IProductionBuilding building : this.allBuildings) {
            if (building instanceof ProductFromProductBuilding) {
                Product consumed = ((ProductFromProductBuilding)building).getConsumed();
                Product produced = building.getProduct();
                boolean matchFound = false;
                for (Product product : consumedProduced.keySet()) {
                    if (consumed == product && produced == consumedProduced.get(consumed)) {
                        matchFound = true;
                    }
                }
                if (matchFound) {
                    continue;
                }
                consumedProduced.put(consumed, produced);
                final int consumedNeededToMakeProduct = 2;
                if (((storage.getProductStock(consumed) - this.occupiedPositions.get(produced) * consumedNeededToMakeProduct)) < 0) {
                    counter.put(produced, counter.get(produced) - this.occupiedPositions.get(produced));
                    continue;
                }
                counter.put(consumed, counter.get(consumed) - consumedNeededToMakeProduct * this.occupiedPositions.get(produced));
            }
        }

        return counter;
    }

    public int numOfUnemployedVillagers(HousingManager manager) {
        return manager.getNumOfVillagers() - this.numOfEmployedVillagers();
    }

    public ArrayList<IProductionBuilding> getAllBuildings() {
        return this.allBuildings;
    }

    public int getFreePositions(Product product) {
        return this.freePositions.get(product);
    }

    public int getOccupiedPositions(Product product) {
        return this.occupiedPositions.get(product);
    }

    public HashMap<WorkshopType, Integer> getWorkshops() {
        return this.numOfEachWorkshop;
    }
    /**
     * Vypočet zamestnaných obyvateľov
     * @return Počet zamestnaných obyvateľov
     */
    private int numOfEmployedVillagers() {
        int employed = 0;
        for (Product occupiedPosition : this.occupiedPositions.keySet()) {
            employed += this.occupiedPositions.get(occupiedPosition);
        }
        return employed;
    }
    /**
     * Inicializácia HashMapov
     */
    private void initialize() {
        for (Product product : Product.values()) {
            this.freePositions.put(product, 0);
            this.occupiedPositions.put(product, 0);
        }
        for (WorkshopType type : WorkshopType.values()) {
            this.numOfEachWorkshop.put(type, 0);
        }
    }
    /**
     * Výpočet obsadených miest
     * @return Počet zamestaných miest
     */
    private int totalOccupied() {
        int total = 0;
        for (Product product : this.occupiedPositions.keySet()) {
            total += this.occupiedPositions.get(product);
        }
        return total;
    }
}
