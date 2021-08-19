package clothesShop.mapper;

import clothesShop.model.Clothes;
import clothesShop.model.Customer;
import clothesShop.model.Employee;
import clothesShop.model.Order;

import java.util.List;

/**
 * Класс маппер. Создает объекты по данным из файлов
 *
 * @author Ozzy on 12-08-21
 */
public class ModelMapper {

    public Clothes mapClothes(List<String> args) { return new Clothes(args); }

    public Customer mapCustomer(List<String> args) { return new Customer(args); }

    public Employee mapEmployee(List<String> args) { return new Employee(args); }

//    public Order mapOrder(List<String> args) { return new Order(args); }
//    public Order mapOrder(List<String> args) { return new Order(int id, int cust,
//        int empl, int [] clt); }

}
