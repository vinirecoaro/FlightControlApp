package br.vino.flightcontrol.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Flight(
    @JsonProperty("flight_id")
    val flightId: String,
    val status: String,
    @JsonProperty("completion_status")
    val completionStatus: String,
    @JsonProperty("start_date")
    val startDate: String,
    @JsonProperty("end_date")
    val endDate: String,
    @JsonProperty("departure_time")
    val departureTime: String,
    @JsonProperty("arrival_time")
    val arrivalTime: String,
    @JsonProperty("departure_airport")
    val departureAirport: String,
    @JsonProperty("arrival_airport")
    val arrivalAirport: String,
    @JsonProperty("airplane_name")
    val airplaneName: String,
)