package clothesShop.repository;

import clothesShop.model.*;
import clothesShop.model.enums.ClothesType;
import clothesShop.Profit;
import clothesShop.repository.datasource.ClothesDataSource;

import java.util.List;

/**
 * Интерфейс репозитория.
 * Работа с данными
 *
 * @author Ozzy on 12-08-21
 */
public interface ClothesRepository {

    /**
     * Получение данных по id
     */

    /**Получить одежду по id*/
    Clothes getClothesById(int id);

    /**Получить покупателя по id*/
    Customer getCustomerById(int id);

    /**Получить продавца по id*/
    Employee getEmployeeById(int id);

    /**Получить заказ по id*/
    Order getOrderById(int id);

    /**
     * Получение информации
     */

    /**Получить информацию об одном заказе*/
    void getInfoAboutOrder(Order order);

    /**
     * Получение стоимости разного рода
     */

    /**Получить стоимость всей проданной одежды*/
    double getPriceOfAllSoldClothes();

    /**Получить стоимость проданной одежды по парядку*/
    double getPriceOfSoldClothesByOrder(Order order);

    /**Получить кол-во всей проданной одежды*/
    int getCountOfAllSoldClothes();

    /**Получить список проданной одежды в одном определенном заказе по виду*/
    int getPriceOfSoldClothesByTypeInOrder(Order order, ClothesType type);

    /**Получить стоимость проданной одежды по виду*/
    List<ClothesAdditional> getPriceOfSoldClothesByType();

    /**Получить среднюю цену проданной одежды в одном заказе*/
    int getAvgPriceOfSoldClothesInOrder(Order order);

    /**Получить среднюю цену проданной одежды во всех заказах*/
    double getAvgPriceOfSoldClothesInAllOrders();

    /**
     * Получение списков разного рода
     */

    /**Получить список проданной одежды по виду*/
    List<ClothesAdditional> getCountOfSoldClothesByType();

    /**Получить список проданной одежды в одном заказе по виду*/
    int getCountOfSoldClothesByTypeInOrder(Order order, ClothesType type);

    /**Получить список одежды в опред. заказе*/
    void getListOfClothesInOrder(Order order);

    /**
     * Прочие функции
     */
    /**Получить профит продавца*/
    Profit getProfitByEmployee(int employeeId);

    /**Получить лучшего продавца (кто больше продал)*/
    Employee getTheBestEmployee();

    /**Получить самую дорогую одежду*/
    Clothes getMostExpensiveClothes(ClothesDataSource dataSource);

    /**Получить самую дешевую одежду*/
    Clothes getTheCheapestClothes(ClothesDataSource dataSource);

}
