package com.senac.cadastro_de_turmas.demo.controllers;

import com.senac.cadastro_de_turmas.demo.entities.Alunos;
import com.senac.cadastro_de_turmas.demo.repositories.AlunoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/{alunos}")

public class AlunosController {

    private final AlunoRepository alunoRepository;

    public AlunosController(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    @GetMapping
    public List<Alunos> listar () {
        return this.alunoRepository.findAll();
    }


    // Em casa de criar Filtro//

    @GetMapping("/{nome}")
    public List<Alunos> listarPorNome (@PathVariable String nome) {
        return this.alunoRepository.findByNome(nome);
    }

    @GetMapping("/{idAluno}")
    public Alunos buscarAlunos(@PathVariable Integer idAluno) {
        return this.alunoRepository.findById(idAluno).get();
    }

    @PostMapping
    public Alunos criarAluno (@RequestBody Alunos alunos) {
        this.alunoRepository.save(alunos);
        return alunos;
    }

    @PostMapping
    public Alunos alterarAlunos(
            @PathVariable Integer idAluno,
            @RequestBody Alunos alunos
    ) {
        Alunos alterar = this.alunoRepository.findById(idAluno).get();


        alterar.setNome(alunos.getNome());
        alterar.setMatricula(alunos.getMatricula());
        this.alunoRepository.save(alterar);

        return alterar;
    }

    @DeleteMapping("/{idAluno}")

    public Alunos removerAlunos(@PathVariable Integer idAluno) {
        Alunos alunos = this.alunoRepository.findById(idAluno).get();

        return alunos;
    }

}
