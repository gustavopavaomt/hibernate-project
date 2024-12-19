package br.com.gpavao.dao;

import br.com.gpavao.dao.impl.ProductDAO;
import br.com.gpavao.domain.Product;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ProductDAOTest {

    private IProductDAO productDAO;

    ProductDAOTest(){
        productDAO = new ProductDAO();
    }

    @AfterEach
    public void end(){
        List<Product> productList = productDAO.findAll();
        productList.forEach(product -> productDAO.remover(product));
    }

    @Test
    public void testInsercao(){
        Product product = new Product();
        product.setNome("Notebook Dell");
        product.setPrice(2000d);
        product.setQuantidade(10);
        product = productDAO.cadastrar(product);
        assertNotNull(product);
        assertNotNull(product.getId());

        Product produtoResult = productDAO.findByID(product.getId());
        assertNotNull(produtoResult);
        assertEquals(product.getId(), produtoResult.getId());

    }

    @Test
    public void testUpdate(){
        Product product = new Product();
        product.setNome("Iphone 11");
        product.setPrice(3000d);
        product.setQuantidade(3);
        product = productDAO.cadastrar(product);
        assertNotNull(product);
        assertNotNull(product.getId());

        product.setPrice(3500d);
        product.setQuantidade(10);
        Product productResult = productDAO.update(product);
        assertEquals(3500d, productResult.getPrice());
        assertEquals(10,productResult.getQuantidade());

        Product produtoResult = productDAO.findByID(product.getId());
        assertNotNull(produtoResult);
        assertEquals(product.getId(), productResult.getId());
    }
}
