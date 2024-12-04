package cl.ipss.crudeva02.controllers;

import cl.ipss.crudeva02.models.EstadoReserva;
import cl.ipss.crudeva02.models.Reserva;
import cl.ipss.crudeva02.services.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/reservas")
public class ReservaController {

  @Autowired
  private ReservaService reservaService;

  // Mostrar lista de reservas
  @GetMapping
  public String listarReservas(Model model) {
    model.addAttribute("titulo", "Listado de Reservas"); // Título para la vista
    model.addAttribute("reservas", reservaService.obtenerTodasLasReservas()); // Obtener todas las reservas
    return "reservas/lista"; // Vista de lista de reservas (debe estar en templates/reservas/lista.html)
  }

  // Mostrar formulario para crear una nueva reserva
  @GetMapping("/nuevo")
  public String mostrarFormularioReserva(Model model) {
    model.addAttribute("reserva", new Reserva()); // Creamos un objeto vacío de reserva para llenar el formulario
    return "reservas/nueva"; // Esta vista debe estar en templates/reservas/nueva.html
  }

  // Crear una nueva reserva
  @PostMapping("/guardar")
  public String crearReserva(@ModelAttribute Reserva reserva) {
    reserva.setEstado(EstadoReserva.PENDIENTE); // Establecer estado a "pendiente"
    reserva.setFechaHora(LocalDateTime.now()); // Establecer fecha y hora actuales
    reservaService.guardarReserva(reserva); // Guardar la nueva reserva
    return "redirect:/reservas"; // Redirigir a la lista de reservas
  }

  // Mostrar formulario para modificar una reserva existente
  @GetMapping("/editar/{id}")
  public String mostrarFormularioModificar(@PathVariable Long id, Model model) {
    Reserva reserva = reservaService.obtenerReservaPorId(id); // Obtener reserva por ID
    if (reserva == null) {
      return "redirect:/reservas"; // Si no se encuentra, redirigir a la lista
    }
    model.addAttribute("reserva", reserva); // Pasar la reserva al formulario
    return "reservas/modificar"; // Esta vista debe estar en templates/reservas/modificar.html
  }

  // Modificar una reserva existente
  @PostMapping("/editar/{id}")
  public String modificarReserva(@PathVariable Long id, @ModelAttribute Reserva reserva) {
    reserva.setId(id); // Asegurar que el ID de la reserva sea el correcto
    reservaService.guardarReserva(reserva); // Guardar los cambios en la reserva
    return "redirect:/reservas"; // Redirigir a la lista de reservas
  }

  // Cancelar una reserva
  @PostMapping("/cancelar/{id}")
  public String cancelarReserva(@PathVariable Long id) {
    reservaService.cancelarReserva(id); // Llamar al servicio para cancelar la reserva
    return "redirect:/reservas"; // Redirigir a la lista de reservas
  }

  @GetMapping("/eliminar/{id}")
  public String eliminarReserva(@PathVariable Long id) {
    reservaService.eliminar(id);
    return "redirect:/reservas";
  }

}
