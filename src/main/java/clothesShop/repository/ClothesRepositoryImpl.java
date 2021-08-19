package clothesShop.repository;

import clothesShop.model.*;
import clothesShop.model.enums.ClothesType;
import clothesShop.Profit;
import clothesShop.repository.datasource.ClothesDataSource;

import java.util.*;

public class ClothesRepositoryImpl implements ClothesRepository {

    private final ClothesDataSource dataSource;

    private final List<ClothesType> CLOTHES_TYPES_LIST = Arrays.asList(ClothesType.values());

    public ClothesRepositoryImpl(ClothesDataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * Получение данных по id
     */

    @Override
    public Clothes getClothesById(int id) {
        Clothes searchable = null;

        for (Clothes clothes : dataSource.getClothes()) {
            if (clothes.getId() == id) {
                searchable = clothes;
                break;
            }
        }

        return searchable;
    }

    @Override
    public Customer getCustomerById(int id) {
        Customer searchable = null;

        for (Customer customer : dataSource.getCustomers()) {
            if (customer.getId() == id) {
                searchable = customer;
                break;
            }
        }

        return searchable;
    }

    @Override
    public Employee getEmployeeById(int id) {
        Employee searchable = null;

        for (Employee employee : dataSource.getEmployees()) {
            if (employee.getId() == id) {
                searchable = employee;
                break;
            }
        }

        return searchable;
    }

    @Override
    public Order getOrderById(int id) {
        Order searchable = null;

        for (Order order : dataSource.getOrders()) {
            if (order.getId() == id) {
                searchable = order;
                break;
            }
        }
        return searchable;
    }

    /**
     * Получение информации
     */
    @Override
    public void getInfoAboutOrder(Order order) {
        Order searchable = null;

        for (Order current : dataSource.getOrders()) {
            if (current == order) {
                searchable = current;
                break;
            }
        }

        assert searchable != null;
        System.out.println("ID заказа: " + searchable.getId());
        System.out.println("Продавец: " + getEmployeeById(searchable.getEmployeeId()));
        System.out.println("Покупатель: " + getCustomerById(searchable.getCustomerId()));
        System.out.println("Одежда: ");
        getListOfClothesInOrder(searchable);
        System.out.println("Итого: " + getPriceOfSoldClothesByOrder(searchable));
    }

    /**
     * Получение стоимости разного рода
     */

    @Override
    public double getPriceOfAllSoldClothes() {
        double price = 0;

        if (dataSource.getOrders() != null)
        for (Order order : dataSource.getOrders()) {
            price += getPriceOfSoldClothesByOrder(order);
        }
        return price;
    }

    @Override
    public double getPriceOfSoldClothesByOrder(Order order) {
        double price = 0;

        for (int clothesId : order.getClothes()) {
            Clothes current = getClothesById(clothesId);
            if (current != null)
                price += current.getPrice();
        }
        return price;
    }

    @Override
    public int getCountOfAllSoldClothes() {
        int count = 0;

        for (Order order : dataSource.getOrders()) {
            count += order.getClothes().length;
        }
        return count;
    }

    @Override
    public int getPriceOfSoldClothesByTypeInOrder(Order order, ClothesType type) {
        int price = 0;

        for (int clothesId : order.getClothes()) {
            Clothes c = getClothesById(clothesId);
            if (c != null && c.getType() == type) {
                price += c.getPrice();
            }
        }
        return price;
    }

    @Override
    public List<ClothesAdditional> getPriceOfSoldClothesByType() {
        List<ClothesAdditional> result = new ArrayList<>();

        Map<ClothesType, Integer> clothesPriceByTypeMap = new HashMap<>();

        for (ClothesType type : CLOTHES_TYPES_LIST) {
            clothesPriceByTypeMap.put(type, 0);
        }

        for (Order order : dataSource.getOrders()) {
            for (ClothesType type : clothesPriceByTypeMap.keySet()) {
                int priceOfClothesByType =
                        clothesPriceByTypeMap.get(type) +
                                getPriceOfSoldClothesByTypeInOrder(order, type);
                clothesPriceByTypeMap.put(type, priceOfClothesByType);
            }
        }

        for (ClothesType type : clothesPriceByTypeMap.keySet()) {
            int price = clothesPriceByTypeMap.get(type);
            result.add(new ClothesAdditional(type, price));
        }

        return result;
    }

    @Override
    public int getAvgPriceOfSoldClothesInOrder(Order order) {
        int price = 0, countOfSold = 0;
        for (int clothesId : order.getClothes()) {
            Clothes c = getClothesById(clothesId);
            {
                countOfSold++;
                price += c.getPrice();
            }
        }
        return price / countOfSold;

    }

    @Override
    public double getAvgPriceOfSoldClothesInAllOrders() {
        return getPriceOfAllSoldClothes() / getCountOfAllSoldClothes();
    }

    /**
     * Получение списков разного рода
     */

    @Override
    public List<ClothesAdditional> getCountOfSoldClothesByType() {
        List<ClothesAdditional> result = new ArrayList<>();
        Map<ClothesType, Integer> clothesCountByTypeMap = new HashMap<>();

        for (ClothesType type : CLOTHES_TYPES_LIST) {
            clothesCountByTypeMap.put(type, 0);
        }

        for (Order order : dataSource.getOrders()) {
            for (ClothesType type : clothesCountByTypeMap.keySet()) {
                int countOfClothesByType =
                        clothesCountByTypeMap.get(type) +
                                getCountOfSoldClothesByTypeInOrder(order, type);
                clothesCountByTypeMap.put(type, countOfClothesByType);
            }
        }

        for (ClothesType type : clothesCountByTypeMap.keySet()) {
            int count = clothesCountByTypeMap.get(type);
            result.add(new ClothesAdditional(type, count));
        }

        return result;
    }

    @Override
    public int getCountOfSoldClothesByTypeInOrder(Order order, ClothesType type) {
        int count = 0;

        for (int clothesId : order.getClothes()) {
            Clothes current = getClothesById(clothesId);
            if (current != null && current.getType() == type) {
                count++;
            }
        }
        return count;
    }

    @Override
    public void getListOfClothesInOrder(Order order) {
        //Искомый заказ
        Order searchable = null;
        //Проход по все заказам
        for (Order current : dataSource.getOrders()) {
            //Если конкр. зак. рав. order
            if (current == order) {
                //То искомый равен конкр.
                searchable = current;
                break;
            }
        }

        //1. Выводится кол-во одежды из искомого заказа
        //Кол-во кол-во одежды из искомого заказа
        assert searchable != null;
        int amountOfClothes = searchable.getClothes().length;
        System.out.println("Кол-во купленного: " + amountOfClothes);
        System.out.println();
        //2. Пока есть что выводить
        for (int id : searchable.getClothes()) {
            System.out.println(getClothesById(id));
        }
    }

    /**
     * Прочие функции
     */

    @Override
    public Profit getProfitByEmployee(int employeeId) {
        int count = 0;
        double price = 0;
        for (Order order : dataSource.getOrders()) {
            if (order.getEmployeeId() == employeeId) {
                price += getPriceOfSoldClothesByOrder(order);
                count += order.getClothes().length;
            }
        }
        return new Profit(count, price * 0.87);
    }

    @Override
    public Employee getTheBestEmployee() {

        Employee bestEmployee = dataSource.getEmployees().get(0);
        for (Employee employee : dataSource.getEmployees()) {
            if (getProfitByEmployee(employee.getId()).getPrice() > getProfitByEmployee(bestEmployee.getId()).getPrice()) {
                bestEmployee = employee;
                break;
            }
        }
        return bestEmployee;
    }

    @Override
    public Clothes getMostExpensiveClothes(ClothesDataSource dataSource) {

        Clothes mostExpensive = dataSource.getClothes().get(0);
        for (Clothes clothes : dataSource.getClothes()) {
            if (clothes.getPrice() > mostExpensive.getPrice()) {
                mostExpensive = clothes;
                break;
            }
        }
        return mostExpensive;
    }

    @Override
    public Clothes getTheCheapestClothes(ClothesDataSource dataSource) {

        Clothes cheapest = dataSource.getClothes().get(0);
        for (Clothes clothes : dataSource.getClothes()) {
            if ((clothes.getPrice() < cheapest.getPrice())) {
                cheapest = clothes;
                break;
            }
        }
        return cheapest;
    }


}
