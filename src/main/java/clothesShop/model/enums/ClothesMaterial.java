package clothesShop.model.enums;

/**
 * Перечисление материалов одежды
 *
 * @author Ozzy on 12-08-21
 */
public enum ClothesMaterial {
    cotton("Хлопок"),
    denim("Джинсовая ткань"),
    flax("Лён"),
    nylon("Нейлон"),
    polyester("Полиэстер");

    private String clothesMaterialName;

    ClothesMaterial(String clothesMaterialName) {
        this.clothesMaterialName = clothesMaterialName;
    }

    public String getClothesMaterialName() {
        return clothesMaterialName;
    }
}
