package buildings.productionbuildings;
/**
 * Interface pre všetky budovy, ktoré niečo produkujú
 * @author Daniel Caban
 */
public interface IProductionBuilding {

    WorkshopType getWorkshop();

    int getPositions();

    Product getProduct();

}
