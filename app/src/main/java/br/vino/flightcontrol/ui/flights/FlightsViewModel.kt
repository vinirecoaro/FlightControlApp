package br.vino.flightcontrol.ui.flights

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.vino.flightcontrol.model.Flight
import br.vino.flightcontrol.repository.FlightRepository

class FlightsViewModel(private val repository : FlightRepository) : ViewModel() {

    private val _flights = MutableLiveData<List<Flight>>()
    val flights : LiveData<List<Flight>> = _flights

    init {
        getFlights()
    }

    fun getFlights(){
        _flights.value = repository.getFlights()
    }
}