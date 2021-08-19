package clothesShop.model;

import clothesShop.model.enums.ClothesBrand;
import clothesShop.model.enums.ClothesColor;
import clothesShop.model.enums.ClothesMaterial;
import clothesShop.model.enums.ClothesType;

import java.util.List;
import java.util.Objects;

/**
 * Дата класс одежды
 *
 * @author Ozzy on 12-08-21
 */
public class Clothes {
    private final int id;
    private final ClothesBrand brand;
    private final ClothesColor color;
    private final ClothesMaterial material;
    private final ClothesType type;
    private final int price;

    /**
     * Конструктор создания объекта непосредственно
     * в коде программы
     *
     * @param id       Индентификатор
     * @param brand    Бренд
     * @param color    Цвет
     * @param material Материал
     * @param type     Тип
     * @param price    Цена
     */
    public Clothes(int id, ClothesBrand brand,
                   ClothesColor color, ClothesMaterial material,
                   ClothesType type, int price) {
        this.id = id;
        this.brand = brand;
        this.color = color;
        this.material = material;
        this.type = type;
        this.price = price;
    }

    /**
     * Конструктор создания объекта с помощью данных из файла clothes.csv
     *
     * @param args Аргументы из файла clothes.csv
     */
    public Clothes(List<String> args) {
        this(
                Integer.parseInt(args.get(0)),
                ClothesBrand.valueOf(args.get(1)),
                ClothesColor.valueOf(args.get(2)),
                ClothesMaterial.valueOf(args.get(3)),
                ClothesType.valueOf(args.get(4)),
                Integer.parseInt(args.get(5))
        );
    }

    public int getId() {
        return id;
    }

    public ClothesBrand getBrand() {
        return brand;
    }

    public ClothesColor getColor() {
        return color;
    }

    public ClothesMaterial getMaterial() {
        return material;
    }

    public ClothesType getType() {
        return type;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Одежда: " +
                "id=" + id +
                ", бренд=" + brand.getClothesBrandName() +
                ", цвет=" + color.getClothesColorName() +
                ", материал=" + material.getClothesMaterialName() +
                ", тип=" + type.getClothesTypeName() +
                ", цена=" + price +
                "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clothes clothes = (Clothes) o;
        return id == clothes.id && price == clothes.price && brand == clothes.brand && color == clothes.color && material == clothes.material && type == clothes.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, brand, color, material, type, price);
    }
}
