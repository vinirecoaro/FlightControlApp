package br.vino.flightcontrol.ui.flights

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.vino.flightcontrol.model.Flight
import br.vino.flightcontrol.repository.FlightRepository
import kotlinx.coroutines.async

class FlightsViewModel(private val repository : FlightRepository) : ViewModel() {

    private val _flights = MutableLiveData<List<Flight>>()
    val flights : LiveData<List<Flight>> = _flights

    init {
        getFlights()
    }

    fun getFlights(){
        viewModelScope.async {
            _flights.value = repository.getFlights().sortedBy { it.flightId }
        }
    }

    fun getFilteredFlights(status : String){
        viewModelScope.async {
            _flights.value = repository.getFlights().filter { it.status == status }.sortedBy { it.flightId }
        }
    }
}