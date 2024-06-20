package br.com.api.fatec.apifatec.domain.fornecedor;

import br.com.api.fatec.apifatec.entities.Fornecedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FornecedorService {
    
    @Autowired
    private FornecedorRepository fornecedorRepository;

    public List<Fornecedor> listarFornecedores() {
        return fornecedorRepository.findAll();
    }

    public Fornecedor encontrarFornecedorPorId(Long id) {
        return fornecedorRepository.findById(id).orElse(null);
    }

    public Fornecedor salvarFornecedor(Fornecedor fornecedor) {
        return fornecedorRepository.save(fornecedor);
    }

    public Fornecedor atualizarFornecedor(Long id, Fornecedor fornecedor) {
        Fornecedor fornecedorCadastrado = encontrarFornecedorPorId(id);
        
        if (fornecedorCadastrado == null) {
            return null;
        } else {
            fornecedorCadastrado.setNome(fornecedor.getNome());
            fornecedorCadastrado.setContato(fornecedor.getContato());
            return fornecedorRepository.save(fornecedorCadastrado);
        }
    }

    public void deletarFornecedor(Long id) {
        fornecedorRepository.deleteById(id);
    }
}
