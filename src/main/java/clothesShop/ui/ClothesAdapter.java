package clothesShop.ui;

import clothesShop.repository.datasource.ClothesDataSource;
import clothesShop.repository.ClothesRepository;

/**
 * Адаптер связующий вывод с данными
 *
 * @author Ozzy on 13-08-21
 */
public class ClothesAdapter {
    private final ClothesDataSource dataSource;
    private final ClothesRepository repository;

    /**
     * @param repository репозиторий для получения логики обработки заказов
     * @param dataSource хранилище с данными
     */
    public ClothesAdapter(ClothesDataSource dataSource, ClothesRepository repository) {
        this.dataSource = dataSource;
        this.repository = repository;
    }

    public void showInfo() {
        String info = String.format("Общее количество проданной одежды: %d" +
                " на сумму: %f", repository.getCountOfAllSoldClothes(), repository.getPriceOfAllSoldClothes());
        System.out.println(info);
    }

    public void funOne(){
        repository.getInfoAboutOrder(dataSource.getOrders().get(0));
    }

}
