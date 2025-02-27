package br.com.bln.basespringbatch.domain.batchs.jobsisolados.migrarpessoa;

import br.com.bln.basespringbatch.adapter.gateway.repository.destino.CaracteristicasDestinoRepository;

import br.com.bln.basespringbatch.adapter.gateway.repository.destino.PacienteDestinoRepository;

import br.com.bln.basespringbatch.adapter.gateway.repository.origem.CaracteristicasRepository;
import br.com.bln.basespringbatch.adapter.gateway.repository.origem.PacienteRepository;
import br.com.bln.basespringbatch.domain.entity.destino.CaracteristicasDestino;

import br.com.bln.basespringbatch.domain.entity.destino.PacienteDestino;
import br.com.bln.basespringbatch.domain.entity.destino.PessoaDestinoEntity;
import br.com.bln.basespringbatch.domain.entity.origem.CaracteristicasEntity;

import br.com.bln.basespringbatch.domain.entity.origem.PacienteEntity;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.data.RepositoryItemReader;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.data.builder.RepositoryItemReaderBuilder;
import org.springframework.batch.item.data.builder.RepositoryItemWriterBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Sort;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class CaracteristicasDestinoBatchConfiguration {



    public static final int CHUNK_SIZE = 20000;


    @Autowired
    protected StepBuilderFactory stepBuilderFactory;


    @Autowired
    protected  CaracteristicasDestinoProcessor caracteristicasDestinoProcessor;


    @Bean
    public Step stepMigrarCaracteristicasDestino(RepositoryItemReader CaracteristicasDestinoRepositoryReader, RepositoryItemWriter CaracteristicasDestinoRepositoryWriter) {
        return stepBuilderFactory
                .get("STEP_MIGRAR_CARACTERISTICAS_DESTINO")
                .<PacienteEntity, PessoaDestinoEntity>chunk(CHUNK_SIZE)
                .reader(CaracteristicasDestinoRepositoryReader)
                .processor(caracteristicasDestinoProcessor)
                .writer(CaracteristicasDestinoRepositoryWriter)
                .build();
    }

    @Bean
    public RepositoryItemReader<CaracteristicasEntity> CaracteristicasDestinoRepositoryReader(CaracteristicasRepository caracteristicasRepository) {
        Map<String, Sort.Direction> sorts = new HashMap<>();
        sorts.put("id", Sort.Direction.ASC);

        return new RepositoryItemReaderBuilder<CaracteristicasEntity>()
                .name("CaracteristicasDestinoRepositoryReader")
                .repository(caracteristicasRepository)
                .methodName("buscarTodasPorId")
                .pageSize(CHUNK_SIZE)
                .sorts(sorts)
                .build();
    }

    @Bean
    public RepositoryItemWriter<CaracteristicasDestino> CaracteristicasDestinoRepositoryWriter(CaracteristicasDestinoRepository caracteristicasDestinoRepository) {
        return new RepositoryItemWriterBuilder<CaracteristicasDestino>()
                .repository(caracteristicasDestinoRepository)
                .build();
    }





}
