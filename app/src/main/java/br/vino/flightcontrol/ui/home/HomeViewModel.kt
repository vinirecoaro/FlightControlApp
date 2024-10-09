package br.vino.flightcontrol.ui.home

import android.graphics.Color
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.vino.flightcontrol.repository.FlightRepository
import kotlinx.coroutines.async

class HomeViewModel(private val repository : FlightRepository) : ViewModel() {

    private val _flightsPerStatusList = MutableLiveData<List<Pair<String, Int>>>()
    val flightsPerStatusList : LiveData<List<Pair<String, Int>>> = _flightsPerStatusList
    private val pieChartPaletteColors = listOf(
        Color.rgb(50, 111, 168),
        Color.rgb(168, 83, 50),
        Color.rgb(0,150,0),
        Color.rgb(168, 135, 50),
        Color.rgb(107, 50, 168)
    )

    fun getFlightsInfo(){
        viewModelScope.async {
            val flights = repository.getFlights()
            val flightsStatus = flights.groupBy { it.status }.toList()
            val flightsStatusCount = mutableListOf<Pair<String,Int>>()
            flightsStatus.forEach { flight ->
                flightsStatusCount.add(
                    Pair(flight.first, flight.second.size)
                )
            }
            _flightsPerStatusList.postValue(flightsStatusCount)
        }
    }

    fun getPieChartCategoriesColors() : List<Int>{
        return pieChartPaletteColors
    }

}