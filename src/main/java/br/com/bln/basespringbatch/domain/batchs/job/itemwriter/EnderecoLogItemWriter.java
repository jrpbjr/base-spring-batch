package br.com.bln.basespringbatch.domain.batchs.job.itemwriter;

import br.com.bln.basespringbatch.domain.entity.destino.CaracteristicasDestino;
import br.com.bln.basespringbatch.domain.entity.destino.EnderecoDestino;
import lombok.extern.log4j.Log4j2;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

@Log4j2
@Component
public class EnderecoLogItemWriter implements ItemWriter<EnderecoDestino> {
    @Override
    public void write(List<? extends EnderecoDestino> list) throws Exception {
        log.info("EnderecoDestinoLogItemWriter");
        list.forEach(PacienteDestino -> {
            log.info(PacienteDestino.getId());
        });
    }


}
