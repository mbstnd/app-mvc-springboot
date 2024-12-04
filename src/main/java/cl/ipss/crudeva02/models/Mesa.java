package cl.ipss.crudeva02.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Mesa {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String numeroMesa;
  private int capacidad;
  private boolean disponible;
  private String estado; // Asegúrate de que esta propiedad esté aquí

  public Mesa() {
  }

  public Mesa(String numeroMesa, int capacidad, boolean disponible) {
    this.numeroMesa = numeroMesa;
    this.capacidad = capacidad;
    this.disponible = disponible;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNumeroMesa() {
    return numeroMesa;
  }

  public void setNumeroMesa(String numeroMesa) {
    this.numeroMesa = numeroMesa;
  }

  public int getCapacidad() {
    return capacidad;
  }

  public void setCapacidad(int capacidad) {
    this.capacidad = capacidad;
  }

  public boolean isDisponible() {
    return disponible;
  }

  public void setDisponible(boolean disponible) {
    this.disponible = disponible;
  }

  // Getter y setter para la propiedad 'estado'
  public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }
}