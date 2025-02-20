package br.com.bln.basespringbatch.domain.batchs.jobsisolados.migrarpessoa;

import br.com.bln.basespringbatch.domain.entity.destino.UsuarioDestinoEntity;
import br.com.bln.basespringbatch.domain.entity.origem.PessoaEntity;
import lombok.extern.log4j.Log4j2;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class UsuarioDestinoProcessor implements ItemProcessor<PessoaEntity, UsuarioDestinoEntity> {

    @Override
    public UsuarioDestinoEntity process(PessoaEntity pessoaEntity) throws Exception {
        return UsuarioDestinoEntity.builder()
                .login(pessoaEntity.getApelido())
                .senha(pessoaEntity.getSenha())
                .build();
    }
}
