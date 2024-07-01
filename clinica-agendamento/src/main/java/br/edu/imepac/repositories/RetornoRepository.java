package br.edu.imepac.repositories;

import br.edu.imepac.models.RetornoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RetornoRepository extends JpaRepository<RetornoModel, Long> {
}
