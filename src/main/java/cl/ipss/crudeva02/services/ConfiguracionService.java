package cl.ipss.crudeva02.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.ipss.crudeva02.models.Configuracion;
import cl.ipss.crudeva02.repositories.ConfiguracionRepository;

@Service
public class ConfiguracionService {

  @Autowired
  private ConfiguracionRepository configuracionRepository;

  public Configuracion obtenerConfiguracion() {
    return configuracionRepository.findById(1L).orElse(null);
  }

  public Configuracion guardarConfiguracion(Configuracion configuracion) {
    return configuracionRepository.save(configuracion);
  }

}
