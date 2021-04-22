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
@Table(name = "Cliente")
public class Cliente {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int           id;

   private String        dni;
   private String        nombre;
   private String        apellidos;
   private String        direccion;
   private String        municipio;
   private String        provincia;
   private int           codigoPostal;
   private String        email;
   private int           telefono;
   private String        observaciones;

   @OneToMany(mappedBy = "cliente")
   private Set<Alquiler> alquilerCliente = new HashSet<Alquiler>();

   public Cliente() {
      super();
      alquilerCliente = new HashSet<Alquiler>();
   }

   public Cliente(int id, String dni, String nombre, String apellidos, String direccion, String municipio, String provincia, int codigoPostal, String email, int telefono, String observaciones, Set<Mobiliario> mobiliarios) {
      super();
      this.id = id;
      this.dni = dni;
      this.nombre = nombre;
      this.apellidos = apellidos;
      this.direccion = direccion;
      this.municipio = municipio;
      this.provincia = provincia;
      this.codigoPostal = codigoPostal;
      this.email = email;
      this.telefono = telefono;
      this.observaciones = observaciones;
   }

}
