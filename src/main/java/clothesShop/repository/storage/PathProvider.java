package clothesShop.repository.storage;

/**
 * Интерфейс получения путей до файлов с данными
 *
 * @author Ozzy on 12-08-21
 */
public interface PathProvider {
    /**Чтение даонных о одежде*/
    String getClothesPath();

    /**Чтение даонных о покупателях*/
    String getCustomersPath();

    /**Чтение даонных о продавцах*/
    String getEmployeesPath();

    /**Чтение даонных о покупках*/
    String getOrders();
}
