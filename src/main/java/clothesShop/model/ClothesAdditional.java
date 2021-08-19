package clothesShop.model;

import clothesShop.model.enums.ClothesType;

/**
 * Дополнительный класс одежды
 *
 * @author Ozzy on 12-08-21
 */
public class ClothesAdditional {
    private final ClothesType type;
    private final int count;

    /**
     * Конструктор дополнительного класса одежды
     *
     * @param type  Тип
     * @param count Кол-во
     */
    public ClothesAdditional(ClothesType type, int count) {
        this.type = type;
        this.count = count;
    }

    public ClothesType getType() {
        return type;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "ClothesAdditional{" +
                "тип=" + type.getClothesTypeName() +
                ", кол-во=" + count +
                '}' + "\n";
    }
}
