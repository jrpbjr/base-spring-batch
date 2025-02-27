package br.com.bln.basespringbatch.domain.batchs.job.itemprocessor;


import br.com.bln.basespringbatch.domain.batchs.job.listner.executionlistener.MapdeParaEnderecoExecutionListener;

import br.com.bln.basespringbatch.domain.entity.destino.EnderecoDestino;

import br.com.bln.basespringbatch.domain.entity.origem.EnderecoEntity;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EnderecoOrigemToEnderecoDestino implements ItemProcessor<EnderecoEntity, EnderecoDestino> {

    @Autowired
    private MapdeParaEnderecoExecutionListener mapdeParaEnderecoExecutionListener;

    @Override
    public EnderecoDestino process(EnderecoEntity EnderecoEntity) throws Exception {
        Long novoId = mapdeParaEnderecoExecutionListener.obterNovoId(EnderecoEntity.getId());

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
