package cl.ipss.crudeva02.models;

import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Configuracion {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private LocalTime horarioApertura;
  private LocalTime horarioCierre;
  private int maxReservasPorDia;

  public Configuracion() {
  }

  public Configuracion(LocalTime horarioApertura, LocalTime horarioCierre, int maxReservasPorDia) {
    this.horarioApertura = horarioApertura;
    this.horarioCierre = horarioCierre;
    this.maxReservasPorDia = maxReservasPorDia;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public LocalTime getHorarioApertura() {
    return horarioApertura;
  }

  public void setHorarioApertura(LocalTime horarioApertura) {
    this.horarioApertura = horarioApertura;
  }

  public LocalTime getHorarioCierre() {
    return horarioCierre;
  }

  public void setHorarioCierre(LocalTime horarioCierre) {
    this.horarioCierre = horarioCierre;
  }

  public int getMaxReservasPorDia() {
    return maxReservasPorDia;
  }

  public void setMaxReservasPorDia(int maxReservasPorDia) {
    this.maxReservasPorDia = maxReservasPorDia;
  }

}
