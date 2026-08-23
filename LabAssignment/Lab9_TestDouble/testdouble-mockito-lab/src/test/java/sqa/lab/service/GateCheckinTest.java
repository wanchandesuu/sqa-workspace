package sqa.lab.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.mockito.Mockito.*;

class GateCheckinTest {

	private TicketCounter ticketCounterMock;
	private GateCheckin gateCheckin;

	@BeforeEach
	public void setup() {
		ticketCounterMock = mock(TicketCounter.class);
		gateCheckin = new GateCheckin(ticketCounterMock);
	}

	@Test
	public void testCustomerEntry_validTicket() {
		gateCheckin.customerEntry(101);

		assertTrue(gateCheckin.getPassengersOnBoard().contains(101));
		verify(ticketCounterMock).changeTicketStatus(true);
	}

	@Test
	public void testCustomerEntry_multipleCustomers() {
		gateCheckin.customerEntry(101);
		gateCheckin.customerEntry(102);
		gateCheckin.customerEntry(103);

		assertEquals(3, gateCheckin.getPassengersOnBoard().size());
		verify(ticketCounterMock, times(3)).changeTicketStatus(true);
	}

	@Test
	public void testCustomerEntry_duplicateTicket() {
		gateCheckin.customerEntry(101);
		gateCheckin.customerEntry(101);

		assertEquals(1, gateCheckin.getPassengersOnBoard().size());
		verify(ticketCounterMock, times(1)).changeTicketStatus(true);
	}

	@Test
	public void testCustomerIsEligible_newCustomer() {
		assertTrue(gateCheckin.customerIsEligible(101));
	}

	@Test
	public void testCustomerIsEligible_alreadyCheckedIn() {
		gateCheckin.customerEntry(101);
		assertFalse(gateCheckin.customerIsEligible(101));
	}

	@Test
	public void testNoCheckinCustomer_withRealTicketCounter() {
		TicketCounter realTicketCounter = new TicketCounter();
		GateCheckin gate = new GateCheckin(realTicketCounter);

		gate.customerEntry(201);
		gate.customerEntry(202);
		gate.customerEntry(203);

		assertEquals(3, realTicketCounter.getNoCheckinCustomer());
	}

	@Test
	public void testNoCheckinCustomer_duplicateNotCounted() {
		TicketCounter realTicketCounter = new TicketCounter();
		GateCheckin gate = new GateCheckin(realTicketCounter);

		gate.customerEntry(201);
		gate.customerEntry(201);

		assertEquals(1, realTicketCounter.getNoCheckinCustomer());
	}
}
