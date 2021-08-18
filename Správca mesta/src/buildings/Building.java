package buildings;

/**
 * Trieda predstavuje základnú budovu bez špecifického účelu, potrebná pre všetky ďalšie budovy 
 */
public abstract class Building {
    /**
     * Požadované zlato na postavanie
     */
    private int goldReq;
    /**
     * Požadované drevo na postavanie
     */
    private int woodReq;
    /**
     * Požadovaná oceľ na postavanie
     */
    private int steelReq;
    /**
     * Vytvorenie budovy
     * @param price cena
     * @param woodReq potrebné drevo na vybudovanie
     * @param steelReq 
     */
    public Building(int price, int woodReq, int steelReq) {
        this.goldReq = price;
        this.woodReq = woodReq;
        this.steelReq = steelReq;
    }

    public int getPrice() {
        return this.goldReq;
    }

    public int getWoodReq() {
        return this.woodReq;
    }

    public int getSteelReq() {
        return this.steelReq;
    }

}
