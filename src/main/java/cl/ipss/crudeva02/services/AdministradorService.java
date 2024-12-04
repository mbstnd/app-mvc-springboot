package cl.ipss.crudeva02.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import cl.ipss.crudeva02.models.Administrador;
import cl.ipss.crudeva02.repositories.AdministradorRepository;

@Service
public class AdministradorService {

  @Autowired
  private AdministradorRepository administradorRepository;

  // Método para obtener todos los administradores
  public List<Administrador> listarTodas() {
    return administradorRepository.findAll(); // Devuelve todos los administradores desde el repositorio
  }

  // Método para guardar un administrador
  public Administrador guardar(Administrador administrador) {
    return administradorRepository.save(administrador);
  }

  // Método para obtener un administrador por su ID
  public Administrador obtenerPorId(Long id) {
    return administradorRepository.findById(id).orElse(null);
  }

  // Método para eliminar un administrador por su ID
  public void eliminarAdministrador(Long id) {
    administradorRepository.deleteById(id);
  }
}
