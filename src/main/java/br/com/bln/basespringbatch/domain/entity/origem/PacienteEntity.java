package br.com.bln.basespringbatch.domain.entity.origem;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "pac_nome", nullable = false)
    private String nome;

    @Column(name = "pac_cpf")
    private String cpf;

    @Column(name = "pac_email")
    private String email;

    @Column(name = "pac_estcivil")
    private Long estcivil; // Alterado para Long

    @Column(name = "pac_nasc")
    private Long nasc; // Alterado para Long

    @Column(name = "pac_rg")
    private Long rg; // Alterado para Long

    @Column(name = "pac_infantil")
    private Long infantil; // Alterado para Long
}