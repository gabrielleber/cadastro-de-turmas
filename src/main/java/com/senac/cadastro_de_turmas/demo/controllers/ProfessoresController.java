package com.senac.cadastro_de_turmas.demo.controllers;

import com.senac.cadastro_de_turmas.demo.entities.Professores;
import com.senac.cadastro_de_turmas.demo.repositories.ProfessorRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professores")


public class ProfessoresController {

    private final ProfessorRepository professorRepository;

    public ProfessoresController(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    @GetMapping
    public List<Professores> listar() {
        return this.professorRepository.findAll();
    }

    @GetMapping("/{id_professor}")
    public Professores buscarProfessores(@PathVariable Integer id_professor) {
        return this.professorRepository.findById(id_professor).get();
    }


    @PostMapping
    public Professores criarProfessor (@RequestBody Professores professores) {
        this.professorRepository.save(professores);
        return professores;
    }

    @PostMapping
    public Professores alterarProfessores(
            @PathVariable Integer id_professor,
            @RequestBody Professores professores
    ){
        Professores alterar = this.professorRepository.findById(id_professor).get();


        alterar.setNome(professores.getNome());
        alterar.setDisciplina(professores.getDisciplina());
        this.professorRepository.save(alterar);

        return alterar;
    }

    @DeleteMapping("/{id_professor}")

    public Professores removerProfessores(@PathVariable Integer id_professor) {
        Professores professores = this.professorRepository.findById(id_professor).get();


        this.professorRepository.deleteById(id_professor);

        return professores; 
    }


}
