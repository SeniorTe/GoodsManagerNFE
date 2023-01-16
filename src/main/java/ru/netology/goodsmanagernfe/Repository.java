package ru.netology.goodsmanagernfe;

public class Repository {
    private Product[] products = new Product[0];


    public void addProduct(Product product) {
        if (findByIdFromProduct(product) != null) {
            throw new AlreadyExistsException(
                    "Element with id: " + product.id + " already exist"
            );
        } else {
            Product[] tmp = new Product[products.length + 1];
            for (int i = 0; i < products.length; i++) {
                tmp[i] = products[i];
            }
            tmp[tmp.length - 1] = product;
            products = tmp;
        }
    }

    public Product[] findAll() {
        return products;
    }

    public Product findById(int id) {
        for (Product product : findAll()) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }


    public Product findByIdFromProduct(Product verifiableProduct) {
        for (Product product : findAll()) {
            if (product.getId() == verifiableProduct.id) {
                return product;
            }
        }
        return null;
    }

    public void removeProductById(int id) {
        if (findById(id) == null) {
            throw new NotFoundException(
                    "Element with id: " + id + " not found"
            );
        } else {
            Product[] tmp = new Product[products.length - 1];
            int copyToIndex = 0;
            for (Product product : products) {
                if (product.getId() != id) {
                    tmp[copyToIndex] = product;
                    copyToIndex++;
                }
            }
            products = tmp;
        }
    }
}