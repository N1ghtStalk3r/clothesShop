package clothesShop.mapper;

import java.util.List;

/**
 * Интерфейс создания модели объекта класса T
 * @param <T>   произвольный класс
 * @author Ozzy on 12-08-21
 */
public interface ReadableModel<T> {
    T createModel(List<String> args);
}
