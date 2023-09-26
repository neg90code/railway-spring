package ps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ps.model.Jugador;
import ps.repository.JugadorRepository;
import java.util.List;

@RestController
@RequestMapping("/jugadores")
public class JugadorController {

	@Autowired
	private JugadorRepository jugadorRepository;

	// Obtener todos los jugadores
	@GetMapping
	public List<Jugador> obtenerTodosLosJugadores() {
		return jugadorRepository.findAll();
	}

	// Crear un nuevo jugador
	@PostMapping
	public Jugador crearJugador(@RequestBody Jugador jugador) {
		return jugadorRepository.save(jugador);
	}

	// Actualizar un jugador existente por ID
	@PutMapping("/{id}")
	public Jugador actualizarJugador(@PathVariable Long id, @RequestBody Jugador jugadorActualizado) {
		jugadorActualizado.setId(id);
		return jugadorRepository.save(jugadorActualizado);
	}

	// Eliminar un jugador por ID
	@DeleteMapping("/{id}")
	public void eliminarJugador(@PathVariable Long id) {
		jugadorRepository.deleteById(id);
	}

	// Obtener jugadores con valor mayor a 1,000,000
	@GetMapping("/valor-mayor")
	public List<Jugador> obtenerJugadoresConValorMayor() {
		// return jugadorRepository.findByValorGreaterThan(1000000);
		// return jugadorRepository.findJugadoresPorPosicion("Delantero");
		return jugadorRepository.findJugadoresConValorMayorQue(1000000);
	}
}
