package clothesShop.model;

import java.util.Arrays;
import java.util.Objects;

/**
 * Класс заказов (покупок)
 *
 * @author Ozzy on 12-08-21.
 */

public class Order {
    private final int id;
    private final int customerId;
    private final int employeeId;
    private int[] clothes;

    /**
     * @param id         Идентификатор
     * @param employeeId Продаваец
     * @param customerId Покупатель
     * @param clothes    id одежды
     */
    public Order(int id, int employeeId, int customerId,
                 int[] clothes) {
        this.id = id;
        this.customerId = customerId;
        this.employeeId = employeeId;
        if (clothes.length > 0)
            this.clothes = clothes;
    }


    public int getId() {
        return id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public int[] getClothes() {
        return clothes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id && customerId == order.customerId && employeeId == order.employeeId && Arrays.equals(clothes, order.clothes);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, customerId, employeeId);
        result = 31 * result + Arrays.hashCode(clothes);
        return result;
    }

    @Override
    public String toString() {
        return "Заказ{" +
                "id=" + id +
                ", покупатель=" + customerId +
                ", продавец=" + employeeId +
                ", одежды=" + Arrays.toString(clothes) +
                '}';
    }

}