package br.com.bln.basespringbatch.adapter.gateway.repository.destino;


import br.com.bln.basespringbatch.domain.entity.destino.CaracteristicasDestino;
import br.com.bln.basespringbatch.domain.entity.destino.PacienteDestino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CaracteristicasDestinoRepository extends JpaRepository<CaracteristicasDestino, Long> {

    @Query("SELECT endereco.id FROM CaracteristicasDestino endereco")
    List<Object[]> mapDeParam();


}
