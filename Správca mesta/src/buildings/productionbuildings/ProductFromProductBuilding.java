package buildings.productionbuildings;

import buildings.Building;
/**
 * Trieda reprezentujúca workshop, ktorý vyrobí produkt z iného produktu
 * @author Daniel Caban
 */
public class ProductFromProductBuilding extends Building implements IProductFromProduct, IProductionBuilding {
    /**
     * Typ workshopu
     */
    private WorkshopType workshop;
    /**
     * Počet voľných pracovných pozícii
     */
    private int positions;
    /**
     * Produkovaný produkt
     */
    private Product produced;
    /**
     * Spotrebovavaný produkt
     */
    private Product consumed;
    
    /**
     * Vytvorenie takéhoto workshopu
     * @param price cena na vybudovanie
     * @param woodReq   požadované drevo
     * @param steelReq potrebná oceľ
     * @param workshop typ workshopu
     * @param positions počet pracovných pozícii
     * @param produced produkovaný produkt
     * @param consumed spotrebovávaný produkt
     */
    public ProductFromProductBuilding(int price, int woodReq, int steelReq, WorkshopType workshop, int positions, Product produced, Product consumed) {
        super(price, woodReq, steelReq);
        this.workshop = workshop;
        this.positions = positions;
        this.produced = produced;
        this.consumed = consumed;
    }

    public int getPositions() {
        return this.positions;
    }

    public WorkshopType getWorkshop() {
        return this.workshop;
    }

    public Product getConsumed() {
        return this.consumed;
    }

    public Product getProduct() {
        return this.produced;
    }

}
