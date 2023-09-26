package ps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ps.model.Jugador;

import java.util.List;

@Repository
public interface JugadorRepository extends JpaRepository<Jugador, Long> {

	List<Jugador> findByValorGreaterThan(double valor);

	// Método personalizado que utiliza una consulta JPQL
	@Query("SELECT j FROM Jugador j WHERE j.valor > :valor")
	List<Jugador> findJugadoresConValorMayorQue(double valor);

	// Consulta JPQL para seleccionar jugadores por posición
	@Query("SELECT j FROM Jugador j WHERE j.posicion = :posicion")
	List<Jugador> findJugadoresPorPosicion(String posicion);
}
