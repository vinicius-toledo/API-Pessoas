package cadastro.pessoas.api.services;

import cadastro.pessoas.api.entidades.Pessoa;
import cadastro.pessoas.api.repositorios.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository pessoaRepository;
     public Pessoa buscarPessoa(long id ){
        return pessoaRepository.findById(id).get();
    }

     public Pessoa atualizarPessoa(Pessoa pessoa){
         return pessoaRepository.save(pessoa);
     }


     public void deleteById(long id){
        if (pessoaRepository.existsById(id)){
            pessoaRepository.deleteById(id);
        }
    }

    public List<Pessoa> listarPessoas(){
       return pessoaRepository.findAll();
    }

    public Pessoa cadastrarPessoa(Pessoa pessoa) {
        //implimentar validaçao de cpf
        //implementar logica de data de nascimento nao ser futura
        //caso cpf e data seja invalida, lançar uma exessao
        return pessoaRepository.save(pessoa);
    }
}
