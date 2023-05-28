package cadastro.pessoas.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    public List<Pessoa> listarPessoas(){
        return pessoaService.listarPessoas();

    }

    @PostMapping
    public Pessoa cadastrarPessoa(@RequestBody Pessoa pessoa){
        return pessoaService.cadastrarPessoa(pessoa);
    }
}
