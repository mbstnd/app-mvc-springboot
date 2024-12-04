package cl.ipss.crudeva02.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.ipss.crudeva02.models.EstadoReserva;
import cl.ipss.crudeva02.models.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
  List<Reserva> findByEstado(EstadoReserva estado);

}
