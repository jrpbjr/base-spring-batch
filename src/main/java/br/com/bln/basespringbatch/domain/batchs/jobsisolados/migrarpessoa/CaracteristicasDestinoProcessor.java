package br.com.bln.basespringbatch.domain.batchs.jobsisolados.migrarpessoa;

import br.com.bln.basespringbatch.domain.entity.destino.CaracteristicasDestino;

import br.com.bln.basespringbatch.domain.entity.destino.PacienteDestino;
import br.com.bln.basespringbatch.domain.entity.origem.CaracteristicasEntity;

import br.com.bln.basespringbatch.domain.entity.origem.PacienteEntity;
import lombok.extern.log4j.Log4j2;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class CaracteristicasDestinoProcessor implements ItemProcessor<CaracteristicasEntity, CaracteristicasDestino> {



    @Override
    public CaracteristicasDestino process(CaracteristicasEntity CaracteristicasEntity) throws Exception {
        log.info("Processando Caracteristicas: {}", CaracteristicasEntity.getId());

        return CaracteristicasDestino.builder()
                .id(CaracteristicasEntity.getId())
                .altura(CaracteristicasEntity.getAltura())
                .peso(CaracteristicasEntity.getPeso())
                .genero(CaracteristicasEntity.getGenero())
                .build();
    }
}
