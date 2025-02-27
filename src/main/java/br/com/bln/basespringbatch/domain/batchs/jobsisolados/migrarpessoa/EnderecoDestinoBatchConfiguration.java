package br.com.bln.basespringbatch.domain.batchs.jobsisolados.migrarpessoa;


import br.com.bln.basespringbatch.adapter.gateway.repository.destino.EnderecoDestinoRepository;

import br.com.bln.basespringbatch.adapter.gateway.repository.origem.EnderecoRepository;

import br.com.bln.basespringbatch.domain.entity.destino.EnderecoDestino;
import br.com.bln.basespringbatch.domain.entity.destino.PessoaDestinoEntity;

import br.com.bln.basespringbatch.domain.entity.origem.EnderecoEntity;
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
import org.springframework.data.domain.Sort;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class EnderecoDestinoBatchConfiguration {

    public static final int CHUNK_SIZE = 20000;

    @Autowired
    protected StepBuilderFactory stepBuilderFactory;


    @Autowired
    protected  EnderecoDestinoProcessor enderecoDestinoProcessor;


    @Bean
    public Step stepMigrarEnderecoDestino(RepositoryItemReader EnderecoDestinoRepositoryReader, RepositoryItemWriter EnderecoDestinoRepositoryWriter) {
        return stepBuilderFactory
                .get("STEP_MIGRAR_ENDERECO_DESTINO")
                .<PacienteEntity, PessoaDestinoEntity>chunk(CHUNK_SIZE)
                .reader(EnderecoDestinoRepositoryReader)
                .processor(enderecoDestinoProcessor)
                .writer(EnderecoDestinoRepositoryWriter)
                .build();
    }

    @Bean
    public RepositoryItemReader<EnderecoEntity> EnderecoDestinoRepositoryReader(EnderecoRepository enderecoRepository) {
        Map<String, Sort.Direction> sorts = new HashMap<>();
        sorts.put("id", Sort.Direction.ASC);

        return new RepositoryItemReaderBuilder<EnderecoEntity>()
                .name("EnderecoDestinoRepositoryReader")
                .repository(enderecoRepository)
                .methodName("buscarTodasPorId")
                .pageSize(CHUNK_SIZE)
                .sorts(sorts)
                .build();
    }

    @Bean
    public RepositoryItemWriter<EnderecoDestino> EnderecoDestinoRepositoryWriter(EnderecoDestinoRepository enderecoDestinoRepository) {
        return new RepositoryItemWriterBuilder<EnderecoDestino>()
                .repository(enderecoDestinoRepository)
                .build();
    }

}
