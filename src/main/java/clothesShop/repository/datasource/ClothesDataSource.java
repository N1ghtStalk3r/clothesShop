package clothesShop.repository.datasource;

import clothesShop.model.Clothes;
import clothesShop.model.Order;
import clothesShop.model.Customer;
import clothesShop.model.Employee;

import java.util.List;

/**
 * Интерфейс источника данных.
 * Наследник: {@link ClothesDataSourceImpl}
 *
 * @author Ozzy on 12-08-21
 */
public interface ClothesDataSource {

    /** Получить список одежды */
    List<Clothes> getClothes();

    /** Получить список покупателей */
    List<Customer> getCustomers();

    /** Получить список сотрудников */
    List<Employee> getEmployees();

    /** Получить список заказов */
    List<Order> getOrders();

}
