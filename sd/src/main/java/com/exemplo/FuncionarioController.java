package com.exemplo.supermercado.controller;

import com.exemplo.supermercado.model.Funcionario;
import com.exemplo.supermercado.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired 
    private FuncionarioService service;

    @PostMapping
    public String registrar(@RequestBody Funcionario f) {
        service.registrarFuncionario(f);
        return "Funcionário registrado!";
    }

    @GetMapping
    public List<Funcionario> listar() {
        return service.listarFuncionarios();
    }
}

