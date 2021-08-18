package buildings;

import buildings.housing.HousingManager;
import buildings.productionbuildings.Product;
import buildings.productionbuildings.WorkManager;
import java.util.HashMap;

/**
 * Trieda predstavuje sklad, v ktorom skladujeme všetky naše produkty, taktiež vedie záznamy o celkovom počte vyrobených
 * produktov
 */
public class Storage {
    /**
     * Aktuálne množstvo každého produktu
     */
    private HashMap<Product, Integer> inventory;
    /**
     * Celkové množstvo každého produktu
     */
    private HashMap<Product, Integer> totalProduced;

    public Storage() {
        this.inventory = new HashMap<>();
        this.totalProduced = new HashMap<>();
        for (Product product : Product.values()) {
            this.inventory.put(product, 0);
            this.totalProduced.put(product, 0);
        }
    }

    /**
     * Pridáme produkt na sklad
     * @param product Pridávaný produkt
     * @param count Počet produktov
     */
    public void addToStorage(Product product, int count) {
        this.inventory.put(product, this.inventory.get(product) + count);
        this.totalProduced.put(product, this.totalProduced.get(product) + count);
    }
    /**
     * Metóda kontroluje, či máme dostatok surovín na sklade
     * @param product Produkt, ktorého dostatok kontrolujeme
     * @param count Požadované množstvo
     * @return True, ak sa na sklade nachádza dostatočné množstvo, inakšie false
     */
    public boolean enoughMaterialsToBuy(Product product, int count) {
        return this.getProductStock(product) >= count;
    }
    /**
     * Metóda kontroluje, či máme dostatok surovín na sklade
     * @param buying Budova, ktorú chceme postaviť
     * @return True, ak sa na sklade nachádza dostatočné množstvo, inakšie false
     */
    public boolean enoughMaterialsToBuild(Building buying) {
        return (this.getProductStock(Product.GOLD) >= buying.getPrice()
                && this.getProductStock(Product.WOOD) >= buying.getWoodReq()
                && this.getProductStock(Product.STEEL) >= buying.getSteelReq());

    }
    
    /**
     * Ak máme dostatok produktov na sklade, tak ich odčítame
     * @param building Budova, ktorú chceme postaviť
     */
    public void buyABuilding(Building building) {
        if (this.enoughMaterialsToBuild(building)) {
            this.removeFromStorage(Product.WOOD, building.getWoodReq());
            this.removeFromStorage(Product.GOLD, building.getPrice());
            this.removeFromStorage(Product.STEEL, building.getSteelReq());
        }
    }

    /**
     * Odstráni produkt zo skladu
     * @param product Odstraňovaný produkt
     * @param count Odstraňovaný počet
     */
    public void removeFromStorage(Product product, int count) {
        this.inventory.put(product, this.inventory.get(product) - count);
    }
    /**
     * Ak máme na sklade dostatok mäsa na nakŕmenie obyvateľstva, tak ho vymažeme zo skladu
     * @param manager manažér obyvateľstva
     * @return True, ak je dosť mäsa pre všetkých, inak false
     */
    public boolean eatMeat(HousingManager manager) {
        int meatToFeed = manager.meatEaten();
        if (this.inventory.get(Product.SMOKED_MEAT) >= meatToFeed) {
            this.inventory.put(Product.SMOKED_MEAT, this.inventory.get(Product.SMOKED_MEAT) - meatToFeed);
            return true;
        }
        return false;
    }

    /**
     * Metóda počíta, koľko každého produktu sa vyrobilo každú jednotku času, pridá ich na sklad
     * @param manager Manažer práce, uchováva údaje o výrobniach každého produktu
     */
    public void addNewProductsEveryTick(WorkManager manager) {
        HashMap<Product, Integer> update = manager.calculateNewProductsEveryTick(this);
        for (Product product : update.keySet()) {
            int updated = this.inventory.get(product) + update.get(product);
            this.inventory.put(product, updated);
            this.totalProduced.put(product, this.totalProduced.get(product) + update.get(product));
            if (product == Product.SMOKED_MEAT) {
                this.totalProduced.put(Product.MEAT, this.totalProduced.get(Product.MEAT) + update.get(product) * 2);
            } else if (product == Product.STEEL) {
                this.totalProduced.put(Product.IRON, this.totalProduced.get(Product.IRON) + update.get(product) * 2);
            }
        }

    }

    public int getProductStock(Product product) {
        return this.inventory.get(product);
    }

    public HashMap<Product, Integer> getTotalProduced() {
        return this.totalProduced;
    }
}
