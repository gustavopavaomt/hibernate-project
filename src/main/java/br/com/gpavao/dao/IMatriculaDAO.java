package br.com.gpavao.dao;

import br.com.gpavao.domain.Matricula;

import java.util.List;

public interface IMatriculaDAO {

    Matricula cadastrar(Matricula matricula);

    Matricula findById(Integer id);

    void delete(Matricula matricula);

    Matricula update(Matricula matricula);

    List<Matricula> findAll();
}
