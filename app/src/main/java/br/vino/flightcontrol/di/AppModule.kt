package br.vino.flightcontrol.di

import br.vino.flightcontrol.repository.FlightRepository
import br.vino.flightcontrol.ui.flights.FlightsViewModel
import org.koin.dsl.module

val appModule = module {

    single {
        FlightRepository()
    }

    factory<FlightsViewModel>{
        FlightsViewModel(
            get()
        )
    }
}