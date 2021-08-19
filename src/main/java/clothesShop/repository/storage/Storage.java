package clothesShop.repository.storage;

import java.util.List;

/**
 * Интерфейс для загрузки файлов из файловой системы
 *
 * @author Ozzy on 12-08-21
 */
public interface Storage {
    /**
     * Чтение данных из файла
     *
     * @param path путь до файла
     * @return построчный текст
     */
    List<String> readFromFile(String path);
}
