package cl.ipss.crudeva02.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cl.ipss.crudeva02.models.Configuracion;
import cl.ipss.crudeva02.services.ConfiguracionService;

@Controller
@RequestMapping("/configuracion")
public class ConfiguracionController {

  @Autowired
  private ConfiguracionService configuracionService;

  @GetMapping
  public String mostrarConfiguracion(Model model) {
    Configuracion configuracion = configuracionService.obtenerConfiguracion();
    model.addAttribute("configuracion", configuracion);
    return "configuracion/detalles";
  }

  @PostMapping("/actualizar")
  public String actualizarConfiguracion(Configuracion configuracion) {
    configuracionService.guardarConfiguracion(configuracion);
    return "redirect:/configuracion";
  }

}
