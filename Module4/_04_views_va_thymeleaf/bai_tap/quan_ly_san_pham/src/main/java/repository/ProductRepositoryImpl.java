package repository;

import model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepositoryImpl implements  ProductRepository{
    private static Map<Integer, Product> productMap;

    static {
        productMap = new HashMap<>();
        productMap.put(1, new Product(1, "quan", 100000, "asdasd", "Channel"));
        productMap.put(2, new Product(2, "ao", 200000, "asdasd123", "Channel"));
        productMap.put(3, new Product(3, "giay", 123000, "1231231", "Channel"));
        productMap.put(4, new Product(4, "dep", 3543000, "456456", "Channel"));
        productMap.put(5, new Product(5, "khan", 23000, "zxczxc", "Channel"));
        productMap.put(6, new Product(6, "mu", 980000, "dfgdfgdfg", "Channel"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public Product findById(int id) {
        return productMap.get(id);
    }

    @Override
    public void save(Product product) {
        productMap.put(product.getId(), product);
    }

    @Override
    public void update(int id, Product product) {
        productMap.put(id, product);
    }

    @Override
    public void remove(int id) {
        productMap.remove(id);
    }
}
