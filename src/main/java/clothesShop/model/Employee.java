package clothesShop.model;

import java.util.List;

/**
 * Класс Employee (Работники) наследуется от {@link Person}
 *
 */
public class Employee extends Person {
    public Employee(int id, String fullName) {
        super(id, fullName);
    }

    public Employee(List<String> args)
    {
        this(Integer.parseInt(args.get(0)), args.get(1));
    }

}
