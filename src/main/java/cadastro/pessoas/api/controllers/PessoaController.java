package cadastro.pessoas.api.controllers;

import cadastro.pessoas.api.services.ContatoService;
import cadastro.pessoas.api.services.PessoaService;
import cadastro.pessoas.api.entidades.Contato;
import cadastro.pessoas.api.entidades.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
    @Autowired //fornece o controle sobre onde e como a ligação entre os bens deve ser realizada.
    private PessoaService pessoaService;

    @Autowired
    private ContatoService contatoService;

//get de buscar uma unica pessoa pelo id que ela foi criada.
    @GetMapping("/{id}")
    public Pessoa buscarPessoa(@PathVariable Long id){
       return pessoaService.buscarPessoa(id);
    }

// get para listar todas as pessoas adicionadas.
    @GetMapping
    public List<Pessoa> listarPessoas(){
        return pessoaService.listarPessoas();
    }
//Post para cadastrar as pessoas no nosso banco de dados.
    @PostMapping
    public Pessoa cadastrarPessoa(@RequestBody Pessoa pessoa){
        return pessoaService.cadastrarPessoa(pessoa);
    }

//Put para atualizar qualquer dado no nosso bando de dados.
    @PutMapping
    public Pessoa atualizarPessoa(@RequestBody Pessoa pessoa){
        return pessoaService.atualizarPessoa(pessoa);
    }

// Metodo para podermos deletar alguma pessoa do nosso cadastro.
    @DeleteMapping("/{id}")
    public void apagarPessoa(@PathVariable("id") long id){
        pessoaService.deleteById(id);
    }

    //Post para adicionar uma lista de contato para a pessoa selecionada.
    @PostMapping("/{id}/contato")
    public Contato adicionarContato(@PathVariable("id") long id, @RequestBody Contato contato){
       return contatoService.adicionarContato(id, contato);
    }


}








