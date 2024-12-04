package cl.ipss.crudeva02.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import cl.ipss.crudeva02.models.Administrador;
import cl.ipss.crudeva02.services.AdministradorService;

@Controller
@RequestMapping("/administradores")
public class AdministradorController {

  @Autowired
  private AdministradorService administradorService;

  @GetMapping
  public String listarAdministradores(Model model) {
    // Ahora usa correctamente el servicio
    model.addAttribute("administradores", administradorService.listarTodas());
    return "administradores/lista";
  }

  @GetMapping("/nuevo")
  public String mostrarFormularioNuevoAdministrador() {
    return "administradores/nuevo";
  }

  @PostMapping("/guardar")
  public String guardarAdministrador(@ModelAttribute Administrador administrador) {
    administradorService.guardar(administrador); // Guardar el administrador
    return "redirect:/administradores"; // Redirigir a la lista de administradores
  }


  // Editar un administrador
  @GetMapping("/editar/{id}")
  public String editarAdministrador(@PathVariable Long id, Model model) {
    model.addAttribute("administrador", administradorService.obtenerPorId(id));
    return "/administradores/modificar"; // Redirigir a la lista de administradores
  }

  // Eliminar un administrador
  @PostMapping("/eliminar/{id}")
  public String eliminarAdministrador(@PathVariable Long id, Model model) {
    administradorService.eliminarAdministrador(id); // Eliminar el administrador
    return "redirect:/administradores"; // Redirigir a la lista de administradores
  }

}
