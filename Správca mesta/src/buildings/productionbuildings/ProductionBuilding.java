package buildings.productionbuildings;

import buildings.Building;
/**
 * Workshop, ktorý tvorí produkty
 * @author Daniel Caban
 */
public class ProductionBuilding extends Building implements IProductionBuilding {
    /**
     * Typ workshopu
     */
    private WorkshopType workshop;
    /**
     * Počet pracovných pozícii
     */
    private int positions;
    /**
     * Produkovaný produkt
     */
    private Product product;
    
    /**
     * 
     * @param price požadovaná cena
     * @param woodReq potrebné drevo
     * @param steelReq potrebná oceľ
     * @param workshop typ workshopu
     * @param positions počet pracovných pozícii
     * @param product produkovaný produkt
     */
    public ProductionBuilding(int price, int woodReq, int steelReq, WorkshopType workshop, int positions, Product product) {
        super(price, woodReq, steelReq);
        this.workshop = workshop;
        this.positions = positions;
        this.product = product;
    }

    public int getPositions() {
        return this.positions;
    }

    public Product getProduct() {
        return this.product;
    }

    public WorkshopType getWorkshop() {
        return this.workshop;
    }

}
