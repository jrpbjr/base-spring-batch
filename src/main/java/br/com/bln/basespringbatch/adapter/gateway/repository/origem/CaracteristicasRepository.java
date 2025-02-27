package br.com.bln.basespringbatch.adapter.gateway.repository.origem;

import br.com.bln.basespringbatch.domain.entity.origem.CaracteristicasEntity;

import br.com.bln.basespringbatch.domain.entity.origem.PacienteEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CaracteristicasRepository extends JpaRepository<CaracteristicasEntity, Long> {

    @Query("SELECT ps FROM CaracteristicasEntity ps")
    Page<CaracteristicasEntity> buscarTodasPorId(Pageable pageable);

}
