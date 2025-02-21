package br.com.bln.basespringbatch.domain.entity.destino;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@DynamicUpdate
public class PacienteDestino {


    @Id
    @Column(name = "pac_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "pac_nome", nullable = false)
    private String nome;

    @Column(name = "pac_cpf")
    private String cpf;

    @Column(name = "pac_estcivil")
    private Long estcivil;

    @Column(name = "pac_rg")
    private Long rg;

    @Column(name = "pac_nasc")
    private Long nasc;

    @Column(name = "pac_email")
    private Long email;

    @Column(name = "pac_infantil")
    private Long infatil;

}
