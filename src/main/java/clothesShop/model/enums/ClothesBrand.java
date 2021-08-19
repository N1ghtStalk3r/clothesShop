package clothesShop.model.enums;

/**
 * Перечисление брендов одежды
 *
 * @author Ozzy on 12-08-21
 */
public enum ClothesBrand {
    brandOne("Burdano"),
    brandTwo("Kamasta"),
    brandThree("Costa Russo");

    private String clothesBrandName;

    ClothesBrand(String clothesBrandName) {
        this.clothesBrandName = clothesBrandName;
    }

    public String getClothesBrandName() {
        return clothesBrandName;
    }
}
