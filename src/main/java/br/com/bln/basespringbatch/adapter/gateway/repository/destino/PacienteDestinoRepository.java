package br.com.bln.basespringbatch.adapter.gateway.repository.destino;

import br.com.bln.basespringbatch.domain.entity.destino.PacienteDestino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PacienteDestinoRepository extends JpaRepository<PacienteDestino, Long> {

    @Query("SELECT paciente.id, paciente.cpf FROM PacienteDestino paciente")
    List<Object[]> mapDePac();
}
