package br.vino.flightcontrol.ui.flights

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.vino.flightcontrol.databinding.ItemFlightListBinding
import br.vino.flightcontrol.model.Flight

class FlightListAdapter(private var flightList : List<Flight>) : RecyclerView.Adapter<FlightListAdapter.ViewHolder>() {

    inner class ViewHolder(val binding : ItemFlightListBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemFlightListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return flightList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            with(flightList[position]){
                val path = "${ departureAirport.split(" ")[0] } - ${ arrivalAirport.split(" ")[0] }"

                binding.tvPath.text = path
                binding.tvFlightIdValue.text = flightId
                binding.tvFlightDepartureTimeValue.text = departureTime
                binding.tvFlightArrivalTimeValue.text = arrivalTime
                binding.tvFlightStatusValue.text = status
            }
        }
    }

    fun updateFlightList(newFlightList: List<Flight>) {
        flightList = newFlightList
        notifyDataSetChanged()
    }

}