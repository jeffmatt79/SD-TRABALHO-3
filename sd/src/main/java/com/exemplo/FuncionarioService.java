package com.exemplo.supermercado.service;

import com.exemplo.supermercado.model.Funcionario;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class FuncionarioService {
    private final List<Funcionario> funcionarios = new ArrayList<>();

    public void registrarFuncionario(Funcionario f) {
        funcionarios.add(f);
    }

    public List<Funcionario> listarFuncionarios() {
        return funcionarios;
    }
}

