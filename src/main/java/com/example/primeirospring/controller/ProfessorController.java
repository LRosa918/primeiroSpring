package com.example.primeirospring.controller;

import com.example.primeirospring.model.Professor;
import com.example.primeirospring.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professores")
public class ProfessorController {
    @Autowired
    private ProfessorRepository professorRepository;

    @PostMapping("/add")
    public ResponseEntity<String> addProfessor(@RequestBody Professor professor) {
        professorRepository.save(professor);
        return ResponseEntity.ok("Professor foi Adicionado com sucesso!");
    }

    @GetMapping("/List")
    public ResponseEntity<List<Professor>> listProfessores() {
        List<Professor> professores = professorRepository.findAll();
        return ResponseEntity.ok(professores);
    }

}
