package br.com.bln.basespringbatch.domain.entity.origem;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@DynamicUpdate
@Table(name = "tblpaciente")
public class PacienteEntity {

    @Id
    @Column(name = "pac_id", nullable = false)
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "pac_nome", nullable = false)
    private String nome;

    @Column(name = "pac_cpf")
    private String cpf;

    @Column(name = "pac_email")
    private String email;

    @Column(name = "pac_estcivil")
    private Long estcivil;

    @Column(name = "pac_nasc")
    private LocalDate nasc;

    @Column(name = "pac_rg")
    private String rg;

    @Column(name = "pac_infantil")
    private boolean infantil;

    private Integer pacIdade;

    public void calcularIdade() {
        if (this.nasc != null) {
            this.pacIdade = Period.between(this.nasc, LocalDate.now()).getYears();
            this.infantil = this.pacIdade <= 16;
        }
    }
    @PrePersist
    @PreUpdate
    private void preSalvar() {
        calcularIdade();
    }
}
