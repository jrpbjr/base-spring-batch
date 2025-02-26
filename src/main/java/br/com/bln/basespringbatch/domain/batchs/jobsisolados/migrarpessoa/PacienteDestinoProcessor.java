package br.com.bln.basespringbatch.domain.batchs.jobsisolados.migrarpessoa;

import br.com.bln.basespringbatch.domain.entity.destino.PacienteDestino;
import br.com.bln.basespringbatch.domain.entity.origem.PacienteEntity;
import lombok.extern.log4j.Log4j2;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class PacienteDestinoProcessor implements ItemProcessor<PacienteEntity, PacienteDestino> {

    @Override
    public PacienteDestino process(PacienteEntity pacienteEntity) throws Exception {
        log.info("Processando paciente: {}", pacienteEntity.getNome());

        return PacienteDestino.builder()
                .id(pacienteEntity.getId()) // Preserva o mesmo ID, pode ser alterado se necessário
                .cpf(pacienteEntity.getCpf())
                .nome(pacienteEntity.getNome())
                .estcivil(pacienteEntity.getEstcivil())
                .rg(pacienteEntity.getRg())
                .nasc(pacienteEntity.getNasc())
                .email(pacienteEntity.getEmail())
                .infantil(pacienteEntity.isInfantil()) // Corrigir nome do campo se necessário (provavelmente infantil)
                .build();
    }
}