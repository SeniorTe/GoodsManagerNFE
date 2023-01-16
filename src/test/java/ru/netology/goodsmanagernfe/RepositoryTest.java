package ru.netology.goodsmanagernfe;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RepositoryTest {

    Repository repo = new Repository();
    ProductManager manager = new ProductManager(repo);

    Product product1 = new Book(
            1,
            "Книга1",
            250,
            "Название книги1",
            "Автор1"
    );
    Product product2 = new Book(
            2,
            "Книга2",
            350,
            "Название книги2",
            "Автор2"
    );
    Product product3 = new Smartphone(
            3,
            "Телефон1",
            25_350,
            "Название телефона1",
            "Производитель1"
    );
    Product product4 = new Smartphone(
            4,
            "Телефон2",
            12_350,
            "Название телефона2",
            "Производитель2"

    );

    Product product5 = new Product(
            5,
            "Книга1",
            550,
            "Название книги3"
    );

    @Test

    public void shouldAddProductInRepo() {

        repo.addProduct(product1);
        repo.addProduct(product2);

        Product[] expected = {product1, product2};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void shouldAddProductInManager() {

        manager.addProduct(product1);
        manager.addProduct(product2);

        Product[] expected = {product1, product2};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void shouldRemoveProductById() {

        manager.addProduct(product1);
        manager.addProduct(product2);
        manager.addProduct(product3);
        manager.addProduct(product4);
        repo.removeProductById(3);

        Product[] expected = {product1, product2, product4};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void shouldSearchByText() {

        manager.addProduct(product1);
        manager.addProduct(product2);
        manager.addProduct(product3);
        manager.addProduct(product4);

        Product[] expected = {product4};
        Product[] actual = manager.searchBy("Телефон2");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void shouldSearchByTextSeveralMatches() {

        manager.addProduct(product1);
        manager.addProduct(product2);
        manager.addProduct(product3);
        manager.addProduct(product4);
        manager.addProduct(product5);

        Product[] expected = {product1, product5};
        Product[] actual = manager.searchBy("Книга1");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void shouldSearchById() {

        manager.addProduct(product1);
        manager.addProduct(product2);
        manager.addProduct(product3);
        manager.addProduct(product4);
        manager.addProduct(product5);

        Product expected = product1;
        Product actual = repo.findById(1);

        Assertions.assertEquals(expected, actual);
    }

    @Test

    public void shouldReturnNotFoundExceptionAtRemoveNullId() {

        manager.addProduct(product1);
        manager.addProduct(product2);
        manager.addProduct(product3);
        manager.addProduct(product4);
        manager.addProduct(product5);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeProductById(150);
        });
    }

    @Test

    public void shouldReturnAlreadyExistsExceptionAtRepeatId() {

        manager.addProduct(product1);
        manager.addProduct(product2);
        manager.addProduct(product3);
        manager.addProduct(product4);
        manager.addProduct(product5);

        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            repo.addProduct(product2);
        });
    }
}