package br.com.carro.projeto_carro_api.controller;

import br.com.carro.projeto_carro_api.model.CarroModel;
import br.com.carro.projeto_carro_api.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carros")
public class CarroController {

    @Autowired
    private CarroService service;

    @PostMapping
    public String criar(@RequestBody CarroModel carro) {
        service.adicionarCarro(carro);
        return "Carro cadastrado com sucesso.";
    }

    @GetMapping
    public List<CarroModel> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public CarroModel buscarPorId(@PathVariable int id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public String atualizar(@PathVariable int id, @RequestBody CarroModel carro) {
        boolean atualizado = service.atualizarCarro(id, carro);
        return atualizado ? "Carro atualizado com sucesso." : "Carro não encontrado.";
    }

    @DeleteMapping("/{id}")
    public String remover(@PathVariable int id) {
        boolean removido = service.removerCarro(id);
        return removido ? "Carro removido com sucesso." : "Carro não encontrado.";
    }
}
