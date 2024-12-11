# Sabor Gourmet - Sistema de Reservas Online

Este proyecto es una aplicación web diseñada para modernizar el sistema de reservas del restaurante "Sabor Gourmet". La aplicación permite a los clientes realizar, gestionar, cancelar y modificar reservas en línea, mientras que el personal del restaurante puede administrar la disponibilidad de mesas y consultar las reservas actuales desde una interfaz administrativa.

## Características principales

1. **Gestión de Reservas en Línea:**
   - Reserva de mesas en tiempo real.
   - Cancelación y modificación de reservas existentes.
   - Visualización de la disponibilidad de mesas.

2. **Interfaz de Administración:**
   - Configuración y actualización de mesas.
   - Gestión de reservas actuales.

3. **Diseño Responsivo:**
   - Interfaz optimizada para dispositivos móviles y de escritorio.

4. **Arquitectura del Sistema:**
   - **Spring MVC:** Para gestionar las solicitudes y la lógica de negocio.
   - **Spring Data JPA:** Para el manejo de datos relacionados con clientes, reservas y mesas.
   - **Thymeleaf:** Para las vistas dinámicas e interacción con el usuario.

## Tecnologías Utilizadas

- **Java**
- **Spring Boot**
  - Spring MVC
  - Spring Data JPA
- **Thymeleaf**
- **H2 Database** (Base de datos en memoria para desarrollo)
- **Bootstrap** (Para diseño responsivo)
- **Git y GitHub** (Control de versiones)

## Requisitos Previos

Antes de ejecutar el proyecto, asegúrate de tener instalados los siguientes programas:

- Java 17 o superior.
- Maven 3.8 o superior.
- Un IDE como IntelliJ IDEA, Eclipse o Visual Studio Code.

## Instalación y Ejecución

1. **Clona el repositorio:**

   ```bash
   git clone https://github.com/mbstnd/app-mvc-springboot.git
   cd app-mvc-springboot
   ```

2. **Configura el proyecto:**
   - Importa el proyecto en tu IDE como un proyecto Maven.
   - Asegúrate de que el JDK esté configurado correctamente.

3. **Ejecuta la aplicación:**

   ```bash
   mvn spring-boot:run
   ```

4. **Accede a la aplicación:**
   - Abre tu navegador y ve a: `http://localhost:8080`

## Estructura del Proyecto

- **src/main/java:** Contiene los archivos fuente de la aplicación.
  - **controllers:** Implementa los controladores para gestionar las solicitudes de los usuarios.
  - **models:** Define las entidades como Cliente, Mesa y Reserva.
  - **repositories:** Contiene los repositorios para la persistencia de datos usando Spring Data JPA.
  - **services:** Implementa la lógica de negocio de la aplicación.

- **src/main/resources:**
  - **templates:** Vistas Thymeleaf para la interacción del usuario.
  - **static:** Archivos estáticos como CSS, JS e imágenes.
  - **application.properties:** Configuración de la aplicación.

## Funcionalidades a Implementar

### 1. Integración de Spring MVC
- Controladores para gestionar reservas (crear, ver, modificar, cancelar).

### 2. Uso de Spring Data JPA
- Entidades: Cliente, Mesa, Reserva.
- Repositorios para persistencia de datos.

### 3. Desarrollo de Interfaces con Thymeleaf
- Páginas dinámicas para reservas y administración.
- Formularios para interactuar con las funciones del sistema.

## Próximos Pasos

- Mejorar la validación de datos en los formularios.
- Agregar autenticación y autorización para las vistas administrativas.
- Implementar soporte para bases de datos externas como MySQL o PostgreSQL.

## Contribuciones

Si deseas contribuir al proyecto:

1. Haz un fork del repositorio.
2. Crea una nueva rama (`git checkout -b feature/nueva-funcionalidad`).
3. Realiza tus cambios y haz un commit (`git commit -m "Agrega nueva funcionalidad"`).
4. Sube los cambios a tu rama (`git push origin feature/nueva-funcionalidad`).
5. Crea un pull request en este repositorio.

## Licencia

Este proyecto está bajo la licencia MIT. Consulta el archivo `LICENSE` para más detalles.
