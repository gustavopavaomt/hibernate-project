package br.com.gpavao.dao;

import br.com.gpavao.dao.impl.CursoDAO;
import br.com.gpavao.domain.Curso;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CursoDAOTest {

    private ICursoDAO cursoDAO;

    CursoDAOTest(){
        cursoDAO = new CursoDAO();
    }

    @Test
    public void testCadastrar(){
        Curso curso = new Curso();
        curso.setNome("Curso Java Pro");
        curso.setDescricao("Descricao teste");
       curso = cursoDAO.cadastro(curso);

        assertNotNull(curso);
        assertNotNull(curso.getId());
    }
}
