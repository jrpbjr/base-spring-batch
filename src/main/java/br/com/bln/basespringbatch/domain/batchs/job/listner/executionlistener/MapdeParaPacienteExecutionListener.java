package br.com.bln.basespringbatch.domain.batchs.job.listner.executionlistener;

import br.com.bln.basespringbatch.adapter.gateway.repository.destino.PacienteDestinoRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.core.annotation.AfterStep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

@Log4j2
@Component
public class MapdeParaPacienteExecutionListener {

    @Autowired
    private PacienteDestinoRepository pacienteDestinoRepository;

    private Map<Long, Long> map = new ConcurrentHashMap<>();

    @BeforeStep
    public void beforeStep(StepExecution stepExecution) {
        if (Objects.isNull(map) || map.isEmpty()) {
            log.info("### Criando MapDeParaPacienteExecutionListener");

            pacienteDestinoRepository.findAll()
                    .forEach(paciente -> map.put(paciente.getId(), paciente.getId()));
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



