package clothesShop.repository.storage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OrderStorageImp implements Storage{
    @Override
    public List<String> readFromFile(String path) {
        /**Список строк*/
        List<String> text = new ArrayList<>();

        try {

            FileReader reader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(reader);
            /**Строка*/
            String line;

            /**Цикл чтения пока не eof*/
            while ((line = bufferedReader.readLine()) != null) {
                /**Добавление строки в список*/
                text.add(line);
            }
            /**Закрытие чтения*/
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        /**Возращение списка*/
        return text;
    }
}
