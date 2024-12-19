package br.com.gpavao.dao.impl;

import br.com.gpavao.dao.ICursoDAO;
import br.com.gpavao.domain.Curso;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CursoDAO implements ICursoDAO {

    @Override
    public Curso cadastro(Curso curso) {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = managerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(curso);
        entityManager.getTransaction().commit();

        entityManager.close();
        managerFactory.close();

        return curso;
    }
}
