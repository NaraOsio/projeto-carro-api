package br.com.carro.projeto_carro_api.service;

import br.com.carro.projeto_carro_api.model.CarroModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarroService {

    private final List<CarroModel> carros = new ArrayList<>();

    public void adicionarCarro(CarroModel carro) {
        carros.add(carro);
    }

    public List<CarroModel> listarTodos() {
        return carros;
    }

    public CarroModel buscarPorId(int id) {
        return carros.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
    }

    public boolean atualizarCarro(int id, CarroModel novoCarro) {
        CarroModel existente = buscarPorId(id);
        if (existente != null) {
            existente.setMarca(novoCarro.getMarca());
            existente.setModelo(novoCarro.getModelo());
            existente.setAno(novoCarro.getAno());
            return true;
        }
        return false;
    }

    public boolean removerCarro(int id) {
        return carros.removeIf(c -> c.getId() == id);
    }
}

