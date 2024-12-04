package cl.ipss.crudeva02.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.ipss.crudeva02.models.Mesa;
import cl.ipss.crudeva02.repositories.MesaRepository;

@Service
public class MesaService {

  @Autowired
  private MesaRepository mesaRepository;

  // Método para obtener todas las mesas
  public List<Mesa> obtenerTodasLasMesas() {
    return mesaRepository.findAll();
  }

  // Método para obtener mesas disponibles
  public List<Mesa> obtenerMesasDisponibles() {
    return mesaRepository.findByDisponible(true); // Devuelve las mesas con estado 'disponible'
  }

  public Mesa guardar(Mesa mesa) {
    return mesaRepository.save(mesa);
  }

  // // Método para agregar una nueva mesa
  // public void agregarMesa(Mesa mesa) {
  // mesaRepository.save(mesa); // Guarda la nueva mesa en la base de datos
  // }

  // Método para obtener una mesa por su ID
  public Mesa obtenerPorId(Long id) {
    return mesaRepository.findById(id).orElse(null); // Devuelve null si no se encuentra
  }

  // Método para actualizar la disponibilidad de una mesa
  public void actualizarDisponibilidadMesa(Long id, boolean disponible) {
    Mesa mesa = obtenerPorId(id);
    if (mesa != null) {
      mesa.setDisponible(disponible); // Actualiza la disponibilidad
      mesaRepository.save(mesa); // Guarda los cambios en la base de datos
    }
  }

  // public void guardarMesa(Mesa mesa) {
  // mesaRepository.save(mesa); // Guarda o actualiza la mesa
  // }

  // Método para eliminar una mesa
  public void eliminarMesa(Long id) {
    Mesa mesa = obtenerPorId(id);
    if (mesa != null) {
      mesaRepository.delete(mesa); // Elimina la mesa si existe
    }
  }
}
