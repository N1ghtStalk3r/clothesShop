package clothesShop.model.enums;

/**
 * Перечисление типов одежды
 *
 * @author Ozzy on 12-08-21
 */
public enum ClothesType {
    /**
     * Верхняя одежда
     */
    denimJacket("Джинсовая куртка"),
    shirt("Рубашка"),
    shortSleevedShirt("Рубашка с коротким рукавом"),
    singlet("Майка"),
    tShirt("Футболка"),
    /**
     * Нижняя одежда
     */
    jeans("Джинсы"),
    shorts("Шорты"),
    trousers("Брюки");

    private String clothesTypeName;

    ClothesType(String clothesTypeName) {
        this.clothesTypeName = clothesTypeName;
    }

    public String getClothesTypeName() {
        return clothesTypeName;
    }
}
