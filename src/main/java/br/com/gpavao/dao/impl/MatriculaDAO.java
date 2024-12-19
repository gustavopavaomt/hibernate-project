package br.com.gpavao.dao;

import br.com.gpavao.domain.Matricula;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class MatriculaDAO implements IMatriculaDAO {
    @Override
    public Matricula cadastrar(Matricula matricula) {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = managerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(matricula);
        entityManager.getTransaction().commit();

        entityManager.close();
        managerFactory.close();

        return matricula;
    }

    @Override
    public Matricula findById(Integer id) {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = managerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        Matricula matricula = entityManager.find(Matricula.class, id);
        entityManager.getTransaction().commit();

        entityManager.close();
        managerFactory.close();

        return matricula;
    }

    @Override
    public void delete(Matricula matricula) {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = managerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        matricula = entityManager.merge(matricula);
        entityManager.remove(matricula);
        entityManager.getTransaction().commit();

        entityManager.close();
        managerFactory.close();
    }

    @Override
    public Matricula update(Matricula matricula) {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = managerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        matricula = entityManager.merge(matricula);
        entityManager.getTransaction().commit();

        entityManager.close();
        managerFactory.close();

         return matricula;
    }

    @Override
    public List<Matricula> findAll() {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = managerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        List<Matricula> matriculaList = entityManager.createQuery(
                "SELECT c FROM Matricula c", Matricula.class
        ).getResultList();
        entityManager.getTransaction().commit();

        entityManager.close();
        managerFactory.close();

        return matriculaList;
    }
}
