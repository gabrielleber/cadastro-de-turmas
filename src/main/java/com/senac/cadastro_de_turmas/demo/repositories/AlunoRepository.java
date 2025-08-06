package com.senac.cadastro_de_turmas.demo.repositories;

import com.senac.cadastro_de_turmas.demo.entities.Alunos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlunoRepository extends JpaRepository<Alunos, Integer> {
    public List<Alunos> findByNome (String nome);
}
