package clothesShop.mapper.converter;

import clothesShop.mapper.ReadableModel;

import java.util.List;

/**
 * Класс конвертации
 * @param <T> произвольный класс
 * @author Ozzy on 12-08-21
 */
public class ModelConverter<T extends ReadableModel<T>> {

    public T convert(List<String> args, T clazz) {
        return clazz.createModel(args);
    }
}