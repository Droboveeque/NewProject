import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {

    @Test
    public void shouldRemoveProductById() {
        ShopRepository repository = new ShopRepository();
        Product product1 = new Product(1, "Milk", 100);
        Product product2 = new Product(2, "Tea", 200);
        Product product3 = new Product(3, "Water", 300);

        repository.add(product1);
        repository.add(product2);
        repository.add(product3);

        repository.removeById(1);

        Product[] actual = repository.findAll();
        Product[] expected = {product2, product3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveUnknownProductById() {
        ShopRepository repository = new ShopRepository();
        Product product1 = new Product(1, "Milk", 100);
        Product product2 = new Product(2, "Tea", 200);
        Product product3 = new Product(3, "Water", 300);

        repository.add(product1);
        repository.add(product2);
        repository.add(product3);

        Assertions.assertThrows(NotFoundException.class, () -> repository.removeById(4));
    }

    @Test
    public void shouldAddNewProduct() {
        ShopRepository repository = new ShopRepository();
        Product product1 = new Product(1, "Milk", 100);

        repository.add(product1);


        Product[] actual = repository.findAll();
        Product[] expected = {product1};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddProductWithTheSameId() {
        ShopRepository repository = new ShopRepository();
        Product product1 = new Product(1, "Milk", 100);
        Product product2 = new Product(2, "Tea", 200);

        repository.add(product1);
        repository.add(product2);

        Assertions.assertThrows(AlreadyExistsException.class, () -> repository.add(product1));
    }
}
