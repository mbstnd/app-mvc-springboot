package cl.ipss.crudeva02.models;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;

@Entity
public class Reserva {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "mesa_id")
  private Mesa mesa; // La mesa asociada con la reserva

  private String clienteNombre;

  private LocalDateTime fechaHora;

  @Enumerated(EnumType.STRING)
  private EstadoReserva estado; // Estado de la reserva (confirmada, cancelada, pendiente, etc.)

  // Nuevo campo para almacenar la fecha formateada
  @Transient // Este campo no será persistido en la base de datos
  private String fechaHoraFormateada;

  public Reserva() {
  }

  public Reserva(Mesa mesa, LocalDateTime fechaHora, String clienteNombre,
      EstadoReserva estado) {
    this.mesa = mesa;
    this.fechaHora = fechaHora;
    this.clienteNombre = clienteNombre;
    this.estado = estado;
  }

  // Getters y Setters

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Mesa getMesa() {
    return mesa;
  }

  public void setMesa(Mesa mesa) {
    this.mesa = mesa;
  }

  public LocalDateTime getFechaHora() {
    return fechaHora;
  }

  public void setFechaHora(LocalDateTime fechaHora) {
    this.fechaHora = fechaHora;
  }

  public String getClienteNombre() {
    return clienteNombre;
  }

  public void setClienteNombre(String clienteNombre) {
    this.clienteNombre = clienteNombre;
  }

  public EstadoReserva getEstado() {
    return estado;
  }

  public void setEstado(EstadoReserva estado) {
    this.estado = estado;
  }

  // Getter y Setter para la fecha formateada
  public String getFechaHoraFormateada() {
    return fechaHoraFormateada;
  }

  public void setFechaHoraFormateada(String fechaHoraFormateada) {
    this.fechaHoraFormateada = fechaHoraFormateada;
  }

}
