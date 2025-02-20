package br.com.bln.basespringbatch.domain.batchs.jobsisolados.migrarpessoa;

import br.com.bln.basespringbatch.adapter.gateway.repository.destino.UsuarioDestinoRepository;
import br.com.bln.basespringbatch.adapter.gateway.repository.origem.PessoaRepository;
import br.com.bln.basespringbatch.domain.entity.destino.UsuarioDestinoEntity;
import br.com.bln.basespringbatch.domain.entity.origem.PessoaEntity;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.data.RepositoryItemReader;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.data.builder.RepositoryItemReaderBuilder;
import org.springframework.batch.item.data.builder.RepositoryItemWriterBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Sort;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class UsuarioDestinoStep {

    public static final int CHUNK_SIZE = 20000;

    @Autowired
    protected StepBuilderFactory stepBuilderFactory;

    @Autowired
    protected UsuarioDestinoProcessor usuarioDestinoProcessor;

    @Bean
    public Step stepMigrarUsuarioDestino(
            RepositoryItemReader usuarioDestinoRepositoryReader,
            RepositoryItemWriter usuarioDestinoRepositoryWriter) {
        return stepBuilderFactory
                .get("STEP_MIGRAR_USUARIO_DESTINO")
                .<PessoaEntity, UsuarioDestinoEntity>chunk(CHUNK_SIZE)
                .reader(usuarioDestinoRepositoryReader)
                .processor(usuarioDestinoProcessor)
                .writer(usuarioDestinoRepositoryWriter)
                .build();
    }

    @Bean
    public RepositoryItemReader<PessoaEntity> usuarioDestinoRepositoryReader(PessoaRepository pessoaRepository) {
        Map<String, Sort.Direction> sorts = new HashMap<>();
        sorts.put("id", Sort.Direction.ASC);

        return new RepositoryItemReaderBuilder<PessoaEntity>()
                .name("usuarioDestinoRepositoryReader")
                .repository(pessoaRepository)
                .methodName("buscarTodasPorId")
                .sorts(sorts)
                .pageSize(CHUNK_SIZE)
                .build();
    }

    @Bean
    public RepositoryItemWriter<UsuarioDestinoEntity> usuarioDestinoRepositoryWriter(UsuarioDestinoRepository usuarioDestinoRepository) {
        return new RepositoryItemWriterBuilder<UsuarioDestinoEntity>()
                .repository(usuarioDestinoRepository)
                .build();
    }
}
