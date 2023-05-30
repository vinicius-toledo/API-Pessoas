package cadastro.pessoas.api.services;

import cadastro.pessoas.api.entidades.Pessoa;
import cadastro.pessoas.api.repositorios.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service// Anotação que serve para definir uma classe como pertencente à camada de Servoçoes da aplicação.
public class PessoaService {
    @Autowired //fornece o controle sobre onde e como a ligação entre os bens deve ser realizada.
    private PessoaRepository pessoaRepository;

    //declaraçao do metodo Post(
     public Pessoa buscarPessoa(long id ){
        return pessoaRepository.findById(id).get();
    }

    //declaraçao do metodo Put
     public Pessoa atualizarPessoa(Pessoa pessoa){
         return pessoaRepository.save(pessoa);
     }

    //declaraçao do metodo delete
     public void deleteById(long id){
        if (pessoaRepository.existsById(id)){
            pessoaRepository.deleteById(id);
        }
    }

    //declaraçao do metodo para buscar todas as pessoas da lista(get)
    public List<Pessoa> listarPessoas(){
       return pessoaRepository.findAll();
    }

    //declaraçao do metodo de cadastrar as pessoas(get)
    public Pessoa cadastrarPessoa(Pessoa pessoa) {
        //implimentar validaçao de cpf
        //implementar logica de data de nascimento nao ser futura
        //caso cpf e data seja invalida, lançar uma exessao
        return pessoaRepository.save(pessoa);
    }
}
