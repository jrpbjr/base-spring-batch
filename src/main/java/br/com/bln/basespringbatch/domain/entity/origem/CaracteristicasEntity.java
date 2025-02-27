package br.com.bln.basespringbatch.domain.entity.origem;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@DynamicUpdate
@Table(name = "tblpaciente")
public class CaracteristicasEntity {

    @Id
    @Column(name = "pac_id")
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "pac_altura")
    private String altura;

    @Column(name = "pac_peso")
    private String peso;

    @Column(name = "pac_genero")
    private Boolean genero;
}
