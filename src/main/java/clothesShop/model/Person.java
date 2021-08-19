package clothesShop.model;

import java.util.Objects;

/**
 * Родительский класс Person
 *
 * Наследники:
 *      Покупатели в розницу (customerPerson) {@link Customer}
 *      Работники склада (employee) {@link Employee}
 *
 * @author Ozzy on 07-08-2021
 */
public class Person {
    private final int id;
    private final String fullName;

    /**
     * @param id       Индентификатор
     * @param fullName ФИ
     */
    public Person(int id, String fullName) {
        this.id = id;
        this.fullName = fullName;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && fullName.equals(person.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                '}';
    }
}
