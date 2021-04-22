package es.and.eme3.h2.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table(name = "Mobiliario")
public class Mobiliario {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int           id;

   private String        alias;
   private String        direccion;
   private String        municipio;
   private int           codigoPostal;
   private String        provincia;
   private int           contadorLuz;
   private int           contadorAgua;

   // @Column(name = "disponible")
   // private boolean disponible = Boolean.TRUE;

   @OneToMany(mappedBy = "mobiliario")
   private Set<Alquiler> alquilerMobiliario = new HashSet<Alquiler>();

   public Mobiliario() {
      super();
      alquilerMobiliario = new HashSet<Alquiler>();
   }

   public Mobiliario(int id, String alias, String direccion, String municipio, int codigoPostal, String provincia, int contadorLuz, int contadorAgua) {
      super();
      this.id = id;
      this.alias = alias;
      this.direccion = direccion;
      this.municipio = municipio;
      this.codigoPostal = codigoPostal;
      this.provincia = provincia;
      this.contadorLuz = contadorLuz;
      this.contadorAgua = contadorAgua;
      // this.disponible = Optional.ofNullable(disponible).orElse(this.disponible);

   }

}
