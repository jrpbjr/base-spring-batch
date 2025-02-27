package br.com.bln.basespringbatch.domain.batchs.jobsisolados.migrarpessoa;
import br.com.bln.basespringbatch.domain.entity.destino.EnderecoDestino;
import br.com.bln.basespringbatch.domain.entity.origem.EnderecoEntity;
import lombok.extern.log4j.Log4j2;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class EnderecoDestinoProcessor implements ItemProcessor<EnderecoEntity, EnderecoDestino> {

    @Override
    public EnderecoDestino process(EnderecoEntity EnderecoEntity) throws Exception {
        log.info("Endereco: {}", EnderecoEntity.getId());

        return EnderecoDestino.builder()
                .id(EnderecoEntity.getId())
                .uf(EnderecoEntity.getUf())
                .cep(EnderecoEntity.getCep())
                .endereco(EnderecoEntity.getEndereco())
                .cidade(EnderecoEntity.getCidade())
                .bairro(EnderecoEntity.getBairro())
                .build();
    }



}
