package br.com.bln.basespringbatch.domain.batchs.job.itemwriter;

import br.com.bln.basespringbatch.adapter.gateway.repository.destino.CaracteristicasDestinoRepository;
import br.com.bln.basespringbatch.domain.entity.destino.CaracteristicasDestino;
import lombok.extern.log4j.Log4j2;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class CaracteristicasDestinoRepositoryItemWriter {

    @Autowired
    private CaracteristicasDestinoRepository caracteristicasDestinoRepository;

    @Bean
    public RepositoryItemWriter<CaracteristicasDestino> writer() {
        RepositoryItemWriter<CaracteristicasDestino> writer = new RepositoryItemWriter<>();
        writer.setRepository(caracteristicasDestinoRepository);
        writer.setMethodName("save");
        return writer;
    }

}
