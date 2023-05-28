package cadastro.pessoas.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository pessoaRepository;

    public List<Pessoa> listarPessoas(){
       return pessoaRepository.findAll();

    }

    public Pessoa cadastrarPessoa(Pessoa pessoa){
        return pessoaRepository.save(pessoa);
    }
}
