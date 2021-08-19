package clothesShop.model.enums;

/**
 * Перечисление цветов одежды
 *
 * @author Ozzy on 12-08-21
 */
public enum ClothesColor {
    black("Черный"),
    blue("Синий"),
    gray("Серый"),
    red("Красный"),
    white("Белый");

    private String clothesColorName;

    ClothesColor(String clothesColorName) {
        this.clothesColorName = clothesColorName;
    }

    public String getClothesColorName() {
        return clothesColorName;
    }
}
