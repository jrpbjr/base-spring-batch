package br.com.bln.basespringbatch.adapter.gateway.repository.destino;


import br.com.bln.basespringbatch.domain.entity.destino.PessoaDestinoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PessoaDestinoRepository extends JpaRepository<PessoaDestinoEntity, Long> {

    @Query("SELECT psDestino.id, psDestino.idOrigem FROM PessoaDestinoEntity psDestino")
    List<Object[]> mapDePara();


}
