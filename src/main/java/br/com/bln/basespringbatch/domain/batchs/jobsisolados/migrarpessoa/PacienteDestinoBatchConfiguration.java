package br.com.bln.basespringbatch.domain.batchs.jobsisolados.migrarpessoa;

import br.com.bln.basespringbatch.adapter.gateway.repository.destino.PacienteDestinoRepository;
import br.com.bln.basespringbatch.adapter.gateway.repository.destino.PacienteDestinoRepository;
import br.com.bln.basespringbatch.adapter.gateway.repository.origem.PacienteRepository;
import br.com.bln.basespringbatch.adapter.gateway.repository.origem.PacienteRepository;
import br.com.bln.basespringbatch.domain.batchs.job.tasklet.PacienteDestinoCleanTasklet;
import br.com.bln.basespringbatch.domain.entity.destino.PacienteDestino;
import br.com.bln.basespringbatch.domain.entity.destino.PessoaDestinoEntity;
import br.com.bln.basespringbatch.domain.entity.origem.PacienteEntity;
import br.com.bln.basespringbatch.domain.entity.origem.PacienteEntity;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.data.RepositoryItemReader;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.data.builder.RepositoryItemReaderBuilder;
import org.springframework.batch.item.data.builder.RepositoryItemWriterBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import br.com.bln.basespringbatch.domain.batchs.jobsisolados.migrarpessoa.PacienteDestinoProcessor;
import org.springframework.data.domain.Sort;

import java.util.HashMap;
import java.util.Map;

import static br.com.bln.basespringbatch.domain.batchs.jobsisolados.migrarpessoa.PessoaDestinoBatchConfiguration.CHUNK_SIZE;

@Configuration
public class PacienteDestinoBatchConfiguration {

    public static final int CHUNK_SIZE = 20000;

    @Autowired
    protected StepBuilderFactory stepBuilderFactory;

    @Autowired
    protected PacienteDestinoProcessor pacienteDestinoProcessor;

    @Bean
    public Step stepMigrarPacienteDestino(RepositoryItemReader pacienteDestinoRepositoryReader, RepositoryItemWriter PacienteDestinoRepositoryWriter) {
        return stepBuilderFactory
                .get("STEP_MIGRAR_PACIENTE_DESTINO")
                .<PacienteEntity, PessoaDestinoEntity>chunk(CHUNK_SIZE)
                .reader(pacienteDestinoRepositoryReader)
                .processor(pacienteDestinoProcessor)
                .writer(PacienteDestinoRepositoryWriter)
                .build();
    }

    @Bean
    public RepositoryItemReader<PacienteEntity> pacienteDestinoRepositoryReader(PacienteRepository PacienteRepository) {
        Map<String, Sort.Direction> sorts = new HashMap<>();
        sorts.put("id", Sort.Direction.ASC);

        return new RepositoryItemReaderBuilder<PacienteEntity>()
                .name("pacienteDestinoRepositoryReader")
                .repository(PacienteRepository)
                .methodName("buscarTodasPorId")
                .pageSize(CHUNK_SIZE)
                .sorts(sorts)
                .build();
    }

    @Bean
    public RepositoryItemWriter<PacienteDestino> PacienteDestinoRepositoryWriter(PacienteDestinoRepository PacienteDestinoRepository) {
        return new RepositoryItemWriterBuilder<PacienteDestino>()
                .repository(PacienteDestinoRepository)
                .build();
    }
}
