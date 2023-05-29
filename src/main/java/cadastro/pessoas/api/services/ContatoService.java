package cadastro.pessoas.api.services;

import cadastro.pessoas.api.entidades.Contato;
import cadastro.pessoas.api.entidades.Pessoa;
import cadastro.pessoas.api.repositorios.ContatoRepository;
import cadastro.pessoas.api.repositorios.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContatoService {
    @Autowired
    private ContatoRepository contatoRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public Contato adicionarContato(long idPessoa, Contato contato){
        Pessoa pessoa = pessoaRepository.findById(idPessoa).get();
        Contato contatoSalvo = contatoRepository.save(contato);
        List<Contato> contatos = pessoa.getContatos();
        contatos.add(contatoSalvo);
        pessoaRepository.save(pessoa);
        return contatoSalvo;
    }

}
