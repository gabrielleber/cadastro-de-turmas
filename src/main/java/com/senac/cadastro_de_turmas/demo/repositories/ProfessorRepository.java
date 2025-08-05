package com.senac.cadastro_de_turmas.demo.repositories;

import com.senac.cadastro_de_turmas.demo.entities.Professores;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professores, Integer> {
}
