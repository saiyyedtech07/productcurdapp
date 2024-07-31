package productcurdapp.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import productcurdapp.entities.Product;

import java.util.List;

@Component
@Repository
public class ProductRepository {

    private final HibernateTemplate hibernateTemplate;

    @Autowired
    public ProductRepository(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Transactional
    public void addProduct(Product product) {
        this.hibernateTemplate.save(product);
    }

    public List<Product> getAllProducts() {
        return this.hibernateTemplate.loadAll(Product.class);
    }

    @Transactional
    public void deleteProduct(int productId) {
        Product p = this.hibernateTemplate.get(Product.class, productId);
        if (p != null) {
            this.hibernateTemplate.delete(p);
        }
        // Handle the case where the product with the given ID doesn't exist
    }

    public Product getSingleProduct(int productId) {
        return this.hibernateTemplate.get(Product.class, productId);
        // Handle the case where the product with the given ID doesn't exist
    }
}
