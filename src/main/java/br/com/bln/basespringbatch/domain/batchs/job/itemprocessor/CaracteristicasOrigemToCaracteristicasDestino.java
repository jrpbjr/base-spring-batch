package br.com.bln.basespringbatch.domain.batchs.job.itemprocessor;


import br.com.bln.basespringbatch.domain.batchs.job.listner.executionlistener.MapdeParaCaracteristicasExecutionListener;


import br.com.bln.basespringbatch.domain.entity.destino.CaracteristicasDestino;
import br.com.bln.basespringbatch.domain.entity.destino.PacienteDestino;

import br.com.bln.basespringbatch.domain.entity.origem.CaracteristicasEntity;
import br.com.bln.basespringbatch.domain.entity.origem.PacienteEntity;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CaracteristicasOrigemToCaracteristicasDestino implements ItemProcessor<CaracteristicasEntity, CaracteristicasDestino> {

     @Autowired
    private MapdeParaCaracteristicasExecutionListener mapdeParaCaracteristicasExecutionListener;

    @Override
    public CaracteristicasDestino process(CaracteristicasEntity CaracteristicasEntity) throws Exception {
        Long novoId = mapdeParaCaracteristicasExecutionListener.obterNovoId(CaracteristicasEntity.getId());

        return CaracteristicasDestino.builder()
                .id(novoId)
                .peso(CaracteristicasEntity.getPeso())
                .altura(CaracteristicasEntity.getAltura())
                .genero(CaracteristicasEntity.getGenero())
                .build();
    }



}
