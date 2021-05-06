package es.and.eme3.h2.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table(name = "alquiler")
public class Alquiler {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int             id;

   @ManyToOne
   @JoinColumn(name = "id_cliente")
   private Cliente         cliente;

   @ManyToOne
   @JoinColumn(name = "id_mobiliario")
   private Mobiliario      mobiliario;

   @OneToMany(cascade = CascadeType.ALL, mappedBy = "alquiler")
   private List<ReciboLuz> reciboLuz;

   @Column(name = "fechaInicio")
   private String          fechaInicio;

   @Column(name = "fechaFin")
   private String          fechaFin;

   @Column(name = "luzInicio")
   private int             luzInicio;

   @Column(name = "luzFin")
   private int             luzFin;

   @Column(name = "aguaInicio")
   private int             aguaInicio;

   @Column(name = "aguaFin")
   private int             aguaFin;

   @Column(name = "precio")
   private int             precio;

   @Column(name = "observaciones")
   private String          observaciones;

   @Lob
   @Column(name = "contrato")
   private byte[]          contrato;

   @Column(name = "docName", columnDefinition = "Default null")
   private String          docName;

   @Column(name = "docType", columnDefinition = "Default null")
   private String          docType;

   public Alquiler() {
      super();
      cliente = new Cliente();
      mobiliario = new Mobiliario();
      // reciboLuz = new ArrayList<ReciboLuz>();
      fechaInicio = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
      fechaFin = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
   }

   public Alquiler(Integer id, Cliente cliente, Mobiliario mobiliario, String fechaInicio, String fechaFin, int luzInicio, int luzFin, int aguaInicio, int aguaFin, int precio, String observaciones, byte[] contrato, boolean disponible, String docName, String docType) {
      super();
      this.id = id;
      this.cliente = new Cliente();
      this.mobiliario = new Mobiliario();
      // this.reciboLuz = new ArrayList<ReciboLuz>();
      this.fechaInicio = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
      this.fechaFin = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
      this.luzInicio = luzInicio;
      this.luzFin = luzFin;
      this.aguaInicio = aguaInicio;
      this.aguaFin = aguaFin;
      this.precio = precio;
      this.observaciones = observaciones;
      this.contrato = contrato;
      this.docName = docName;
      this.docType = docType;
   }

}