package br.vino.flightcontrol

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import br.vino.flightcontrol.model.Flight
import br.vino.flightcontrol.repository.FlightRepository
import br.vino.flightcontrol.ui.flights.FlightsViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`
import org.mockito.kotlin.argumentCaptor

class FlightsViewModelTest {

    // Rule that allows LiveData to work properly in unit tests
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        Dispatchers.setMain(StandardTestDispatcher())
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `getFlights should fetch flights and update LiveData`() = runTest {
        // Arrange
        val mockRepository = mock(FlightRepository::class.java)
        val flightsViewModel = FlightsViewModel(mockRepository)
        val fakeFlights = listOf(
            Flight(
                flightId = "1",
                status = "CONCLUIDO",
                completionStatus = "ATRASOU",
                startDate = "2024-08-01",
                endDate = "2024-08-01",
                departureTime = "10:00",
                arrivalTime = "14:00",
                departureAirport = "JFK - John F. Kennedy International Airport",
                arrivalAirport = "LAX - Los Angeles International Airport",
                airplaneName = "Boeing 737"
            ),
            Flight(
                flightId = "2",
                status = "CONCLUIDO",
                completionStatus = "NO_HORARIO",
                startDate = "2024-08-03",
                endDate = "2024-08-03",
                departureTime = "15:30",
                arrivalTime = "19:45",
                departureAirport = "ORD - O'Hare International Airport",
                arrivalAirport = "MIA - Miami International Airport",
                airplaneName = "Airbus A320"
            )
        )

        `when`(mockRepository.getFlights()).thenReturn(fakeFlights)

        // Act
        val observer = mock(Observer::class.java) as Observer<List<Flight>>
        val captor = argumentCaptor<List<Flight>>()

        flightsViewModel.flights.observeForever(observer)
        flightsViewModel.getFlights()

        // Advance coroutines
        advanceUntilIdle()

        // Assert
        verify(observer, times(2)).onChanged(captor.capture())
        assert(captor.lastValue == fakeFlights.sortedBy { it.flightId })

        // Clean up
        flightsViewModel.flights.removeObserver(observer)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `getFilteredFlights should fetch flights filtered and update LiveData`() = runTest {
        // Arrange
        val mockRepository = mock(FlightRepository::class.java)
        val flightsViewModel = FlightsViewModel(mockRepository)
        val fakeFlights = listOf(
            Flight(
                flightId = "1",
                status = "CONCLUIDO",
                completionStatus = "ATRASOU",
                startDate = "2024-08-01",
                endDate = "2024-08-01",
                departureTime = "10:00",
                arrivalTime = "14:00",
                departureAirport = "JFK - John F. Kennedy International Airport",
                arrivalAirport = "LAX - Los Angeles International Airport",
                airplaneName = "Boeing 737"
            ),
            Flight(
                flightId = "2",
                status = "CANCELADO",
                completionStatus = "NO_HORARIO",
                startDate = "2024-08-03",
                endDate = "2024-08-03",
                departureTime = "15:30",
                arrivalTime = "19:45",
                departureAirport = "ORD - O'Hare International Airport",
                arrivalAirport = "MIA - Miami International Airport",
                airplaneName = "Airbus A320"
            )
        )

        `when`(mockRepository.getFlights()).thenReturn(fakeFlights)

        // Act
        val observer = mock(Observer::class.java) as Observer<List<Flight>>
        val captor = argumentCaptor<List<Flight>>()

        flightsViewModel.flights.observeForever(observer)
        flightsViewModel.getFilteredFlights("CONCLUIDO")

        // Advance coroutines
        advanceUntilIdle()

        // Assert
        verify(observer, times(2)).onChanged(captor.capture())
        assert(captor.lastValue == fakeFlights.filter { it.status == "CONCLUIDO" }.sortedBy { it.flightId })

        // Clean up
        flightsViewModel.flights.removeObserver(observer)
    }
}