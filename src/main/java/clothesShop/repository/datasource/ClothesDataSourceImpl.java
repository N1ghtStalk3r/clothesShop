package clothesShop.repository.datasource;

import clothesShop.StringUtils;
import clothesShop.model.Clothes;
import clothesShop.model.Order;
import clothesShop.model.Customer;
import clothesShop.model.Employee;
import clothesShop.repository.storage.PathProvider;
import clothesShop.repository.storage.Storage;
import clothesShop.mapper.ModelMapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Реализация интерфейса {@link ClothesDataSource}
 *
 * @author Ozzy on 12-08-21
 */
public class ClothesDataSourceImpl implements ClothesDataSource {
    private final List<Clothes> clothes = new ArrayList<>();
    private final List<Customer> customers = new ArrayList<>();
    private final List<Employee> employees = new ArrayList<>();
    private final List<Order> orders = new ArrayList<>();

    private final Storage storage;
    private final PathProvider provider;
    private final ModelMapper mapper;

    //Переменные для loadOrders
    private final int ORDER_ID = 0;
    private final int CUSTOMER_ID = 1;
    private final int EMPLOYEE_ID = 2;

    private int getClothesIdsCount(int argsCount)
    {
        int clothesIdsCount = argsCount - 3;
        return clothesIdsCount;
    }

    /**
     * Конструктор класса
     *
     * @param provider Пути к файлам с данными
     * @param storage  Интерфейс для загрузки файлов из файловой системы
     */
    public ClothesDataSourceImpl(PathProvider provider, Storage storage) {
        this.provider = provider;
        this.storage = storage;
        mapper = new ModelMapper();
        initData();
    }

    /**
     * Инициализация и загрузка данных
     */
    private void initData() {
        loadClothes();
        loadCustomers();
        loadEmployees();
        loadOrders();
    }

    @Override
    public List<Clothes> getClothes() {
        return clothes;
    }

    @Override
    public List<Customer> getCustomers() {
        return customers;
    }

    @Override
    public List<Employee> getEmployees() {
        return employees;
    }

    @Override
    public List<Order> getOrders() {
        return orders;
    }

    /**
     * Загрузка данных о одежде
     * @return {@link Clothes}
     */
    private List<Clothes> loadClothes() {
        List<Clothes> clothesList = new ArrayList<>();
        List<String> clothesText = storage.readFromFile(provider.getClothesPath());
        for (String clText : clothesText) {
            List<String> args = Arrays.asList(clText.split(StringUtils.DELIMETER));
            Clothes clothes = mapper.mapClothes(args);
            clothesList.add(clothes);
        }

        if (!clothesList.isEmpty()) {
            clothes.clear();
            clothes.addAll(clothesList);
        }

        return clothes;
    }

    /**
     * Загрузка данных о покупателях
     * @return {@link Customer}
     */
    private List<Customer> loadCustomers() {
        List<Customer> customersList = new ArrayList<>();
        List<String> customersText = storage.readFromFile(provider.getCustomersPath());
        for (String custText : customersText) {
            List<String> args = Arrays.asList(custText.split(StringUtils.DELIMETER));
            Customer customer = mapper.mapCustomer(args);
            customersList.add(customer);
        }

        if (!customersList.isEmpty()) {
            customers.clear();
            customers.addAll(customersList);
        }

        return customers;
    }

    /**
     * Загрузка данных о продавцах
     * @return {@link Employee}
     */
    private List<Employee> loadEmployees() {
        List<Employee> employeesList = new ArrayList<>();
        List<String> employeesText = storage.readFromFile(provider.getEmployeesPath());
        for (String emplText : employeesText) {
            List<String> args = Arrays.asList(emplText.split(StringUtils.DELIMETER));
            Employee employee = mapper.mapEmployee(args);
            employeesList.add(employee);
        }

        if (!employeesList.isEmpty()) {
            employees.clear();
            employees.addAll(employeesList);
        }

        return employees;
    }

    /**
     * Загрузка данных о заказах
     * @return {@link Order}
     */
    private List<Order> loadOrders() {
        List<Order> ordersList = new ArrayList<>();
        List<String> ordersText = storage.readFromFile(provider.getOrders());
        for (String ordText : ordersText) {
            List<String> args = Arrays.asList(ordText.split(StringUtils.DELIMETER));
            //Задание значений
            int id = Integer.parseInt(args.get(ORDER_ID));
            int customerId = Integer.parseInt(args.get(CUSTOMER_ID));
            int employeeId = Integer.parseInt(args.get(EMPLOYEE_ID));
            //Задание id одежды*/
            int [] clothes = new int[getClothesIdsCount(args.size())];
            for (int i = 0; i < clothes.length; i++) {
                clothes[i] = Integer.parseInt(args.get(i+3));
            }
            Order order = new Order(id, customerId, employeeId, clothes);
            ordersList.add(order);
        }

        if (!ordersList.isEmpty()) {
            orders.clear();
            orders.addAll(ordersList);
        }

        return orders;
    }

}
