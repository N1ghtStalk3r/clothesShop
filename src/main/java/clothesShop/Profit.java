package clothesShop;

import java.util.Objects;

/**
 * Класс прибыли за заказ (покупку)
 *
 * @author Ozzy on 12-08-21
 */
public class Profit {
    private final int count; // количество проданного товара
    private final double price; // общая сумма

    /**
     *
     * @param count Кол-во проданного товара
     * @param price Общая сумма
     */
    public Profit(int count, double price) {
        this.count = count;
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Всего " + count +
                " одежд(ы) на сумму " + price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profit profit = (Profit) o;
        return count == profit.count && Double.compare(profit.price, price) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count, price);
    }
}

