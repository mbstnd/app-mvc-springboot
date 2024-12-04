package cl.ipss.crudeva02.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.ipss.crudeva02.models.Mesa;

public interface MesaRepository extends JpaRepository<Mesa, Long> {
  List<Mesa> findByDisponible(boolean disponible);

}
