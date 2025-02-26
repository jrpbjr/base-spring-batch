package br.com.bln.basespringbatch.domain.entity.destino;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.context.annotation.Bean;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@DynamicUpdate

public class PacienteDestino {


    @Id
    @Column(name = "pac_id", nullable = false)
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "pac_nome", nullable = false)
    private String nome;

    @Column(name = "pac_cpf")
    private String cpf;

    @Column(name = "pac_estcivil")
    private Long estcivil;

    @Column(name = "pac_rg")
    private String rg;

    @Column(name = "pac_nasc")
    private LocalDate nasc;

    @Column(name = "pac_email")
    private String email;

    @Column(name = "pac_infantil")
    private Boolean infantil;

}
