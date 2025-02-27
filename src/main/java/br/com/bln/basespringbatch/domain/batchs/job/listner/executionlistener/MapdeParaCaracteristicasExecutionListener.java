package br.com.bln.basespringbatch.domain.batchs.job.listner.executionlistener;

import br.com.bln.basespringbatch.adapter.gateway.repository.destino.CaracteristicasDestinoRepository;

import br.com.bln.basespringbatch.adapter.gateway.repository.destino.PacienteDestinoRepository;


import lombok.extern.log4j.Log4j2;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.AfterStep;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

@Log4j2
@Component
public class MapdeParaCaracteristicasExecutionListener {
    @Autowired
    private CaracteristicasDestinoRepository caracteristicasDestinoRepository;

    private Map<Long, Long> map = new ConcurrentHashMap<>();


    @BeforeStep
    public void beforeStep(StepExecution stepExecution) {
        if (Objects.isNull(map)) {
            this.map = new ConcurrentHashMap<Long, Long>();

            caracteristicasDestinoRepository.mapDeParam()
                    .stream()
                    .forEach(obj -> {
                        this.map.put((Long) obj[0], (Long) obj[1]);
                    });

            log.info("### StepExecutionListener -> Criando MapDeParaPessoaExecutionListener");
        }

    }

    public Long obterNovoId(Long idDestino) {
        return map.getOrDefault(idDestino, null);
    }

    @AfterStep
    public ExitStatus afterStep(StepExecution stepExecution) {
        return stepExecution.getExitStatus();
    }
}
