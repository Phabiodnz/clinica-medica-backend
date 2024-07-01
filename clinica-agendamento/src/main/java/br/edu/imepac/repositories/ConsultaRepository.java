package br.edu.imepac.repositories;

import br.edu.imepac.models.ConsultaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultaRepository extends JpaRepository<ConsultaModel, Long> {
}
