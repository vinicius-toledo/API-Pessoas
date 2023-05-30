package cadastro.pessoas.api.services;

import cadastro.pessoas.api.entidades.Contato;
import cadastro.pessoas.api.entidades.Pessoa;
import cadastro.pessoas.api.repositorios.ContatoRepository;
import cadastro.pessoas.api.repositorios.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service// Anotação que serve para definir uma classe como pertencente à camada de Servoçoes da aplicação.
public class ContatoService {
    @Autowired //fornece o controle sobre onde e como a ligação entre os bens deve ser realizada.
    private ContatoRepository contatoRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public Contato adicionarContato(long idPessoa, Contato contato){ // declaração do metodo para adicionar um novo contato a uma pessoa
        Pessoa pessoa = pessoaRepository.findById(idPessoa).get(); //usar o id que foi passado na url para recuperar o banco de dados a pessoa que a gente quer adicionar o contato
        Contato contatoSalvo = contatoRepository.save(contato); //para salvar um contato no banco,mas ainda nao está ligado(ou relacionado) a nenhuma pessoa
        List<Contato> contatos = pessoa.getContatos(); //só chamamos o metodo getContato da pessoa para ter uma referencia a lista de contato("List(contato>") desta pessoa
        contatos.add(contatoSalvo); //adicionar o novo contato nesta lista de contato, sem salvar a relação contatoxpessoa no banco.
        pessoaRepository.save(pessoa); //esse é o ponto onde a gente salva as alteraçoes desse objeto pessoa no banco, no caso serria a adição de um novo contato.
        return contatoSalvo;
    }

}
