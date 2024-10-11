package br.vino.flightcontrol.di

import br.vino.flightcontrol.repository.FlightRepository
import br.vino.flightcontrol.ui.flights.FlightsViewModel
import br.vino.flightcontrol.ui.home.HomeViewModel
import br.vino.flightcontrol.utils.PaletteColors
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

    factory<HomeViewModel>{
        HomeViewModel(
            repository = get(),
        )
    }
}