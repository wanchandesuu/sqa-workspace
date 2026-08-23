package sqa.lab.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class SeatReservationTest {

	private SeatDAO seatDAOMock;
	private SeatReservation seatReservation;

	@BeforeEach
	public void setup() throws SQLException {

		seatDAOMock = mock(SeatDAO.class);
		seatReservation = new SeatReservation(seatDAOMock);

		List<String> availableSeats = Arrays.asList("A1", "A2", "B3", "C5");
		when(seatDAOMock.fetchAvailableSeats()).thenReturn(availableSeats);

	}

	@Test
	public void checkSeatAvailability_seatIsAvailable() throws SQLException {
		assertTrue(seatReservation.checkSeatAvailability("A1"));
	}

	@Test
	public void checkSeatAvailability_seatIsAvailable_B3() throws SQLException {
		assertTrue(seatReservation.checkSeatAvailability("B3"));
	}

	@Test
	public void checkSeatAvailability_seatIsNotAvailable() throws SQLException {
		assertFalse(seatReservation.checkSeatAvailability("D1"));
	}

	@Test
	public void checkSeatAvailability_seatIsNotAvailable_A3() throws SQLException {
		assertFalse(seatReservation.checkSeatAvailability("A3"));
	}
}
