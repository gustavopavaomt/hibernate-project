package br.com.gpavao.dao;

import br.com.gpavao.dao.impl.MatriculaDAO;
import br.com.gpavao.domain.Matricula;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MatriculaDAOTest {

    private IMatriculaDAO matriculaDAO;

    MatriculaDAOTest(){
        matriculaDAO = new MatriculaDAO();
    }

    @AfterEach
    public void end(){
        List<Matricula> list = matriculaDAO.findAll();
        list.forEach(matricula -> matriculaDAO.delete(matricula));
    }

    @Test
    public void testCadastro(){
        Matricula matricula = new Matricula();
        matricula.setDate(Instant.now());
        matricula.setPrice(2000d);
        matricula.setStatus("Ativo");
        matricula = matriculaDAO.cadastrar(matricula);

        assertNotNull(matricula);
        assertNotNull(matricula.getId());

        Matricula mat = matriculaDAO.findById(matricula.getId());
        assertNotNull(matricula.getId());
        assertEquals(matricula.getId(), mat.getId());
    }
    @Test
    public void testUpdate(){
        Matricula matricula = new Matricula();
        matricula.setDate(Instant.now());
        matricula.setPrice(3000d);
        matricula.setStatus("Ativo");
        matricula = matriculaDAO.cadastrar(matricula);

        assertNotNull(matricula);
        assertNotNull(matricula.getId());

        matricula.setStatus("INATIVO");
        Matricula mat = matriculaDAO.update(matricula);
        assertEquals("INATIVO", mat.getStatus());
    }

}
