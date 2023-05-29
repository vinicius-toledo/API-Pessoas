package cadastro.pessoas.api.repositorios;

import cadastro.pessoas.api.entidades.Contato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContatoRepository extends JpaRepository<Contato, Long> {

}

