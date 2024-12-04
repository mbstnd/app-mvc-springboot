package cl.ipss.crudeva02.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.ipss.crudeva02.models.EstadoReserva;
import cl.ipss.crudeva02.models.Reserva;
import cl.ipss.crudeva02.repositories.ReservaRepository;

@Service
public class ReservaService {

  @Autowired
  private ReservaRepository reservaRepository;

  // Obtener todas las reservas
  public List<Reserva> obtenerTodasLasReservas() {
    return reservaRepository.findAll();
  }

  // Obtener una reserva por su ID
  public Reserva obtenerReservaPorId(Long id) {
    return reservaRepository.findById(id).orElseThrow();
  }

  // Guardar o actualizar una reserva
  public Reserva guardarReserva(Reserva reserva) {
    return reservaRepository.save(reserva);
  }

  // Cancelar una reserva (cambiar su estado a CANCELADA)
  public void cancelarReserva(Long id) {
    Reserva reserva = obtenerReservaPorId(id);
    if (reserva != null) {
      reserva.setEstado(EstadoReserva.CANCELADA); // Asegúrate que CANCELADA esté definido en tu enum
      reservaRepository.save(reserva);
    }
  }

  // Obtener reservas por estado
  public List<Reserva> obtenerReservasPorEstado(EstadoReserva estado) {
    return reservaRepository.findByEstado(estado); // Verifica que el método findByEstado esté definido en tu

  }

  public void eliminar(Long id) {
    reservaRepository.deleteById(id);

  }

}
