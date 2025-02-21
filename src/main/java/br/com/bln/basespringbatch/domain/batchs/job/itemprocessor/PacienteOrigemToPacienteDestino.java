package br.com.bln.basespringbatch.domain.batchs.job.itemprocessor;

import br.com.bln.basespringbatch.domain.batchs.job.listner.executionlistener.MapdeParaPacienteExecutionListener;
import br.com.bln.basespringbatch.domain.entity.destino.PacienteDestino;
import br.com.bln.basespringbatch.domain.entity.origem.PacienteEntity;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PacienteOrigemToPacienteDestino implements ItemProcessor<PacienteEntity, PacienteDestino> {

    @Autowired
    private MapdeParaPacienteExecutionListener mapDeParaPacienteExecutionListener;

    @Override
    public PacienteDestino process(PacienteEntity pacienteEntity) throws Exception {
        Long novoId = mapDeParaPacienteExecutionListener.obterNovoId(pacienteEntity.getId());

        return PacienteDestino.builder()
                .id(novoId)
                .cpf(pacienteEntity.getCpf())
                .nome(pacienteEntity.getNome())
                .estcivil(Long.valueOf(pacienteEntity.getEstcivil())) // Conversão para Long
                .rg(Long.valueOf(pacienteEntity.getRg()))
                .nasc(Long.valueOf(pacienteEntity.getNasc()))
                .email(Long.valueOf(pacienteEntity.getEmail()))
                .infatil(Long.valueOf(pacienteEntity.getInfantil()))
                .build();
    }
}
