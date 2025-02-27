package br.com.bln.basespringbatch.domain.entity.destino;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@DynamicUpdate
public class EnderecoDestino {

    @Id
    @Column(name = "pac_id")
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "pac_end")
    private String endereco;

    @Column(name = "pac_bai")
    private String bairro;

    @Column(name = "pac_cid")
    private String cidade;

    @Column(name = "pac_uf")
    private String uf;

    @Column(name = "pac_cep")
    private String cep;
}
