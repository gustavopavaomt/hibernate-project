package br.com.gpavao.dao;

import br.com.gpavao.domain.Product;

import java.util.List;

public interface IProductDAO {

    Product cadastrar(Product product);

    Product update(Product product);

    Product findByID(Integer id);

    List<Product> findAll();

    void remover(Product product);
}
