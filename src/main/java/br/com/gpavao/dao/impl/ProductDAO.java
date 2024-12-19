package br.com.gpavao.dao.impl;

import br.com.gpavao.dao.IProductDAO;
import br.com.gpavao.domain.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ProductDAO implements IProductDAO {


    @Override
    public Product cadastrar(Product product) {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = managerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(product);
        entityManager.getTransaction().commit();

        entityManager.close();
        managerFactory.close();

        return product;
    }

    @Override
    public Product update(Product product) {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = managerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        product = entityManager.merge(product);
        entityManager.getTransaction().commit();

        entityManager.close();
        managerFactory.close();

        return product;
    }

    @Override
    public Product findByID(Integer id) {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = managerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        Product product = entityManager.find(Product.class, id);
        entityManager.getTransaction().commit();

        entityManager.close();
        managerFactory.close();

        return product;
    }

    @Override
    public List<Product> findAll() {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = managerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        List<Product> productList = entityManager.createQuery(
                "SELECT c FROM Product c", Product.class
        ).getResultList();
        entityManager.getTransaction().commit();

        entityManager.close();
        managerFactory.close();

        return productList;
    }

    @Override
    public void remover(Product product) {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = managerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        product = entityManager.merge(product);
        entityManager.remove(product);
        entityManager.getTransaction().commit();

        entityManager.close();
        managerFactory.close();
    }
}
