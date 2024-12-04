package cl.ipss.crudeva02.controllers;

import java.util.List;

import cl.ipss.crudeva02.models.Mesa;
import cl.ipss.crudeva02.services.MesaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.ui.Model;

@Controller
@RequestMapping("/mesas")
public class MesaController {

  @Autowired
  private MesaService mesaService;

  // Mostrar mesas disponibles
  @GetMapping
  public String listarMesas(Model model) {
    List<Mesa> mesasDisponibles = mesaService.obtenerTodasLasMesas();
    model.addAttribute("mesas", mesasDisponibles);
    return "mesas/lista"; // Vista para mostrar las mesas
  }

  // Mostrar el formulario para agregar una nueva mesa
  @GetMapping("/nueva")
  public String mostrarFormularioNuevaMesa(Model model) {
    model.addAttribute("mesa", new Mesa()); // Crear un objeto vacío para el formulario
    return "mesas/nueva"; // Devuelve la vista de agregar nueva mesa
  }

  // Manejar la adición de una nueva mesa
  @PostMapping("/nueva")
  public String agregarNuevaMesa(@ModelAttribute Mesa mesa, Model model) {
    try {
      // Asigna el valor de 'disponible' a 'estado' antes de guardar la mesa
      String estado = mesa.isDisponible() ? "Disponible" : "Ocupada"; // Convierte el booleano a String
      mesa.setEstado(estado); // Establece el estado de la mesa

      mesaService.guardar(mesa); // Llama al servicio para agregar la mesa
      model.addAttribute("success", "Mesa agregada con éxito");
      return "redirect:/mesas"; // Redirige a la lista de mesas
    } catch (Exception e) {
      model.addAttribute("error", "Error al agregar la mesa: " + e.getMessage());
      return "mesas/nueva"; // Regresa al formulario si hay un error
    }
  }

  @PostMapping("/guardar")
  public String guardarMesa(@ModelAttribute Mesa mesa) {
    mesaService.guardar(mesa); // Método que guarda o actualiza la mesa
    return "redirect:/mesas"; // Redirige a la lista de mesas
  }

  // Modificar una mesa
  @GetMapping("/editar/{id}")
  public String modificarMesa(@PathVariable Long id, Model model) {
    model.addAttribute("mesa", mesaService.obtenerPorId(id));
    return "mesas/modificar"; // Vista para modificar la mesa
  }

  // Eliminar una mesa
  @PostMapping("/eliminar/{id}")
  public String eliminarMesa(@PathVariable Long id) {
    mesaService.eliminarMesa(id); // Elimina la mesa
    return "redirect:/mesas"; // Redirige a la lista de mesas
  }
}
