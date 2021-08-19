package clothesShop.ui;

import clothesShop.repository.ClothesRepository;
import clothesShop.repository.ClothesRepositoryImpl;
import clothesShop.repository.datasource.ClothesDataSource;
import clothesShop.repository.datasource.ClothesDataSourceImpl;
import clothesShop.repository.storage.PathProvider;
import clothesShop.repository.storage.PathProviderImpl;
import clothesShop.repository.storage.Storage;
import clothesShop.repository.storage.StorageImpl;

public class Main {

    public static void main(String[] args) {
        PathProvider provider = new PathProviderImpl();
        Storage storage = new StorageImpl();

        ClothesDataSource dataSource = new ClothesDataSourceImpl(provider, storage);
        ClothesRepository repository = new ClothesRepositoryImpl(dataSource);
        ClothesAdapter adapter = new ClothesAdapter(dataSource, repository);

        adapter.funOne();
    }
}

