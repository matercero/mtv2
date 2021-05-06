package es.and.eme3.h2.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;


@Data
@Entity
@Table(name = "reciboluz")
public class ReciboLuz {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int      id;

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "alquiler_id")
   private Alquiler alquiler;

   @Temporal(TemporalType.TIMESTAMP)
   private Date     fechaInicio;

   @Temporal(TemporalType.TIMESTAMP)
   private Date     fechaFin;

   private int      lecturaInicio;

   private int      lecturaFin;

   private int      consumoKwInicio;

   private int      consumoKwFin;

   private int      potenciaKw;

   private int      coeficienteKwDia;

   private int      precioKwh;

   private int      descuentoPorcentaje;

   private int      coeficienteImpuestoElectricidad;

   private int      porcentajeCoeficienteImpuesto;

   private int      coeficienteEquipo;

   private int      iva;

}
