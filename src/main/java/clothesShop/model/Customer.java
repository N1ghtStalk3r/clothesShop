package clothesShop.model;

import java.util.List;

/**
 * Класс CustomerPerson (покупатель-не-компания) наследуется от {@link Person}
 */
public class Customer extends Person {
    public Customer(int id, String fullName) {
        super(id, fullName);
    }

    public Customer(List<String> args)
    {
        this(Integer.parseInt(args.get(0)),
                args.get(1));
    }



}
