package cl.ipss.crudeva02.models;

public enum EstadoReserva {
  CONFIRMADA, // Reserva confirmada
  CANCELADA, // Reserva cancelada
  PENDIENTE, // Reserva pendiente de confirmación
  NO_SHOW // El cliente no se presentó a la reserva
}