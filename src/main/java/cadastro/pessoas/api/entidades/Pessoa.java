package cadastro.pessoas.api.entidades;

import cadastro.pessoas.api.entidades.Contato;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity // utilizado para informar que uma classe tambem é uma entidade
public class Pessoa {
//o que a pessoa vai possuir.
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;

//getters e setters
    @OneToMany
    private List<Contato> contatos;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public List<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(List<Contato> contatos) {
        this.contatos = contatos;
    }
}
