package br.com.bln.basespringbatch.domain.batchs.job.itemwriter;

import br.com.bln.basespringbatch.domain.entity.destino.PacienteDestino;
import br.com.bln.basespringbatch.domain.entity.destino.PessoaDestinoEntity;
import lombok.extern.log4j.Log4j2;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

@Log4j2
@Component
public class PacienteDestinoLogItemWriter implements ItemWriter<PacienteDestino> {


    @Override
    public void write(List<? extends PacienteDestino> list) throws Exception {
        log.info("PessoaDestinoLogItemWriter");
        list.forEach(PacienteDestino -> {
            log.info(PacienteDestino.getId());
        });
    }
}
