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
    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private ContatoService contatoService;

    @GetMapping("/{id}")
    public Pessoa buscarPessoa(@PathVariable Long id){
       return pessoaService.buscarPessoa(id);
    }


    @GetMapping
    public List<Pessoa> listarPessoas(){
        return pessoaService.listarPessoas();

    }

    @PostMapping
    public Pessoa cadastrarPessoa(@RequestBody Pessoa pessoa){
        return pessoaService.cadastrarPessoa(pessoa);
    }

    @PutMapping
    public Pessoa atualizarPessoa(@RequestBody Pessoa pessoa){
        return pessoaService.atualizarPessoa(pessoa);
    }

    @DeleteMapping("/{id}")
    public void apagarPessoa(@PathVariable("id") long id) {
        pessoaService.deleteById(id);
    }

    @PostMapping("/{id}/contato")
    public Contato adicionarContato(@PathVariable("id") long id, @RequestBody Contato contato){
       return contatoService.adicionarContato(id, contato);
    }


}








