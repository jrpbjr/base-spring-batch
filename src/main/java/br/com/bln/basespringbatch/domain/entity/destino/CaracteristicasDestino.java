package br.com.bln.basespringbatch.domain.entity.destino;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@DynamicUpdate
public class CaracteristicasDestino {
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


    @Column(name = "car_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long carid;


}
