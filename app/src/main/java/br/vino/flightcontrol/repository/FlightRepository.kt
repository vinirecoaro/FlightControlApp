package br.vino.flightcontrol.repository

import br.vino.flightcontrol.model.Flight

class FlightRepository {
    suspend fun getFlights():List<Flight>{
        return listOf(
            Flight(
                flightId = "AB123",
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
                flightId = "CD456",
                status = "CONCLUIDO",
                completionStatus = "NO_HORARIO",
                startDate = "2024-08-03",
                endDate = "2024-08-03",
                departureTime = "15:30",
                arrivalTime = "19:45",
                departureAirport = "ORD - O'Hare International Airport",
                arrivalAirport = "MIA - Miami International Airport",
                airplaneName = "Airbus A320"
            ),
            Flight(
                flightId = "EF789",
                status = "CANCELADO",
                completionStatus = "CANCELADO",
                startDate = "2024-08-05",
                endDate = "2024-08-05",
                departureTime = "08:00",
                arrivalTime = "11:30",
                departureAirport = "SFO - San Francisco International Airport",
                arrivalAirport = "SEA - Seattle-Tacoma International Airport",
                airplaneName = "Boeing 747"
            ),
            Flight(
                flightId = "GH012",
                status = "CONCLUIDO",
                completionStatus = "ATRASOU",
                startDate = "2024-08-07",
                endDate = "2024-08-07",
                departureTime = "09:45",
                arrivalTime = "13:30",
                departureAirport = "ATL - Hartsfield-Jackson Atlanta International Airport",
                arrivalAirport = "DFW - Dallas/Fort Worth International Airport",
                airplaneName = "Boeing 777"
            ),
            Flight(
                flightId = "IJ345",
                status = "CONCLUIDO",
                completionStatus = "NO_HORARIO",
                startDate = "2024-08-09",
                endDate = "2024-08-09",
                departureTime = "12:00",
                arrivalTime = "16:15",
                departureAirport = "BOS - Logan International Airport",
                arrivalAirport = "LAX - Los Angeles International Airport",
                airplaneName = "Airbus A380"
            ),
            Flight(
                flightId = "KL678",
                status = "CANCELADO",
                completionStatus = "CANCELADO",
                startDate = "2024-08-11",
                endDate = "2024-08-11",
                departureTime = "11:30",
                arrivalTime = "14:50",
                departureAirport = "MIA - Miami International Airport",
                arrivalAirport = "JFK - John F. Kennedy International Airport",
                airplaneName = "Boeing 737"
            ),
            Flight(
                flightId = "MN901",
                status = "CONCLUIDO",
                completionStatus = "ATRASOU",
                startDate = "2024-08-13",
                endDate = "2024-08-13",
                departureTime = "06:00",
                arrivalTime = "09:30",
                departureAirport = "LAX - Los Angeles International Airport",
                arrivalAirport = "SFO - San Francisco International Airport",
                airplaneName = "Airbus A320"
            ),
            Flight(
                flightId = "OP234",
                status = "CONCLUIDO",
                completionStatus = "NO_HORARIO",
                startDate = "2024-08-15",
                endDate = "2024-08-15",
                departureTime = "14:00",
                arrivalTime = "18:30",
                departureAirport = "SEA - Seattle-Tacoma International Airport",
                arrivalAirport = "ORD - O'Hare International Airport",
                airplaneName = "Boeing 777"
            ),
            Flight(
                flightId = "QR567",
                status = "CANCELADO",
                completionStatus = "CANCELADO",
                startDate = "2024-08-17",
                endDate = "2024-08-17",
                departureTime = "10:30",
                arrivalTime = "13:45",
                departureAirport = "DFW - Dallas/Fort Worth International Airport",
                arrivalAirport = "ATL - Hartsfield-Jackson Atlanta International Airport",
                airplaneName = "Boeing 747"
            ),
            Flight(
                flightId = "ST890",
                status = "CONCLUIDO",
                completionStatus = "ATRASOU",
                startDate = "2024-08-19",
                endDate = "2024-08-19",
                departureTime = "17:00",
                arrivalTime = "20:45",
                departureAirport = "LGA - LaGuardia Airport",
                arrivalAirport = "MIA - Miami International Airport",
                airplaneName = "Airbus A380"
            ),
            Flight(
                flightId = "UV123",
                status = "CONCLUIDO",
                completionStatus = "NO_HORARIO",
                startDate = "2024-08-21",
                endDate = "2024-08-21",
                departureTime = "08:30",
                arrivalTime = "12:15",
                departureAirport = "ORD - O'Hare International Airport",
                arrivalAirport = "DFW - Dallas/Fort Worth International Airport",
                airplaneName = "Boeing 737"
            ),
            Flight(
                flightId = "WX456",
                status = "CANCELADO",
                completionStatus = "CANCELADO",
                startDate = "2024-08-23",
                endDate = "2024-08-23",
                departureTime = "16:00",
                arrivalTime = "19:30",
                departureAirport = "SFO - San Francisco International Airport",
                arrivalAirport = "JFK - John F. Kennedy International Airport",
                airplaneName = "Airbus A320"
            ),
            Flight(
                flightId = "YZ789",
                status = "CONCLUIDO",
                completionStatus = "ATRASOU",
                startDate = "2024-08-25",
                endDate = "2024-08-25",
                departureTime = "11:00",
                arrivalTime = "14:45",
                departureAirport = "ATL - Hartsfield-Jackson Atlanta International Airport",
                arrivalAirport = "LAX - Los Angeles International Airport",
                airplaneName = "Boeing 777"
            ),
            Flight(
                flightId = "AB987",
                status = "CONCLUIDO",
                completionStatus = "NO_HORARIO",
                startDate = "2024-08-27",
                endDate = "2024-08-27",
                departureTime = "09:00",
                arrivalTime = "12:30",
                departureAirport = "SEA - Seattle-Tacoma International Airport",
                arrivalAirport = "ORD - O'Hare International Airport",
                airplaneName = "Boeing 747"
            ),
            Flight(
                flightId = "CD654",
                status = "CANCELADO",
                completionStatus = "CANCELADO",
                startDate = "2024-08-29",
                endDate = "2024-08-29",
                departureTime = "13:00",
                arrivalTime = "16:45",
                departureAirport = "JFK - John F. Kennedy International Airport",
                arrivalAirport = "MIA - Miami International Airport",
                airplaneName = "Airbus A320"
            ),
            Flight(
                flightId = "EF321",
                status = "CONCLUIDO",
                completionStatus = "ATRASOU",
                startDate = "2024-08-31",
                endDate = "2024-08-31",
                departureTime = "07:30",
                arrivalTime = "10:45",
                departureAirport = "LAX - Los Angeles International Airport",
                arrivalAirport = "DFW - Dallas/Fort Worth International Airport",
                airplaneName = "Boeing 737"
            ),
            Flight(
                flightId = "GH098",
                status = "CONCLUIDO",
                completionStatus = "NO_HORARIO",
                startDate = "2024-09-02",
                endDate = "2024-09-02",
                departureTime = "12:15",
                arrivalTime = "15:45",
                departureAirport = "ORD - O'Hare International Airport",
                arrivalAirport = "SEA - Seattle-Tacoma International Airport",
                airplaneName = "Airbus A380"
            ),
            Flight(
                flightId = "IJ765",
                status = "CANCELADO",
                completionStatus = "CANCELADO",
                startDate = "2024-09-04",
                endDate = "2024-09-04",
                departureTime = "18:00",
                arrivalTime = "21:45",
                departureAirport = "MIA - Miami International Airport",
                arrivalAirport = "LAX - Los Angeles International Airport",
                airplaneName = "Boeing 747"
            ),
            Flight(
                flightId = "KL432",
                status = "CONCLUIDO",
                completionStatus = "ATRASOU",
                startDate = "2024-09-06",
                endDate = "2024-09-06",
                departureTime = "14:30",
                arrivalTime = "18:15",
                departureAirport = "SEA - Seattle-Tacoma International Airport",
                arrivalAirport = "ATL - Hartsfield-Jackson Atlanta International Airport",
                airplaneName = "Boeing 777"
            )
        )
    }
}