package clothesShop.repository.storage;

/**
 * Реализация интерфейса получения путей до файлов с данными {@link PathProvider}
 *
 * @author Ozzy on 12-08-21
 */
public class PathProviderImpl implements PathProvider {
    private final static String CLOTHES_PATH = "clothes.csv";
    private final static String CUSTOMERS_PATH = "customers.csv";
    private final static String EMPLOYEES_PATH = "employees.csv";
    private final static String ORDERS_PATH = "orders.csv";

    @Override
    public String getClothesPath() {
        return CLOTHES_PATH;
    }

    @Override
    public String getCustomersPath() {
        return CUSTOMERS_PATH;
    }

    @Override
    public String getEmployeesPath() {
        return EMPLOYEES_PATH;
    }

    @Override
    public String getOrders() { return ORDERS_PATH; }
}
