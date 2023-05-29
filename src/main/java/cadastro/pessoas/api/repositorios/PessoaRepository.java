package cadastro.pessoas.api.repositorios;

import cadastro.pessoas.api.entidades.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
