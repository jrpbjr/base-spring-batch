package br.com.bln.basespringbatch.domain.batchs.job.itemwriter;

import br.com.bln.basespringbatch.domain.entity.destino.CaracteristicasDestino;

import br.com.bln.basespringbatch.domain.entity.destino.PacienteDestino;
import lombok.extern.log4j.Log4j2;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

@Log4j2
@Component
public class CaracteristicasLogItemWriter implements ItemWriter<CaracteristicasDestino>  {

    @Override
    public void write(List<? extends CaracteristicasDestino> list) throws Exception {
        log.info("PessoaDestinoLogItemWriter");
        list.forEach(PacienteDestino -> {
            log.info(PacienteDestino.getId());
        });
    }


}
