package clothesShop.repository.storage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Реализация интерфейса {@link Storage}
 *
 * @author Ozzy on 12-08-21
 */
public class StorageImpl implements Storage {

    @Override
    public List<String> readFromFile(String path) {
        List<String> text = new ArrayList<>();

        try {

            FileReader reader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(reader);

            String line;

            while ((line = bufferedReader.readLine()) != null) {
                text.add(line);
            }

            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return text;
    }

}
