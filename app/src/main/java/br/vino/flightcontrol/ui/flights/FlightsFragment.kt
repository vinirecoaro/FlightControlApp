package br.vino.flightcontrol.ui.flights

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import br.vino.flightcontrol.databinding.FragmentFlightsBinding
import org.koin.android.ext.android.inject

class FlightsFragment : Fragment() {

    private var _binding: FragmentFlightsBinding? = null
    private val binding get() = _binding!!
    private val viewModel : FlightsViewModel by inject()
    private lateinit var flightListAdapter: FlightListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFlightsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        //Initial selected button
        binding.tbFlightListLine1.check(binding.btAll.id)

        //RecyclerView
        binding.rvFlightList.layoutManager = LinearLayoutManager(requireContext())
        flightListAdapter = FlightListAdapter(emptyList())
        binding.rvFlightList.adapter = flightListAdapter

        setupListeners()

        return root
    }

    private fun setupListeners(){
        val toggleGroup1 = binding.tbFlightListLine1
        val toggleGroup2 = binding.tbFlightListLine2

        toggleGroup1.addOnButtonCheckedListener { group, checkedId, isChecked ->
            if(isChecked){
                binding.rvFlightList.visibility = View.VISIBLE
                toggleGroup2.clearChecked()
            } else if(areNoButtonsSelected()){
                binding.rvFlightList.visibility = View.GONE
            }

        }

        toggleGroup2.addOnButtonCheckedListener { group, checkedId, isChecked ->
            if(isChecked){
                binding.rvFlightList.visibility = View.VISIBLE
                toggleGroup1.clearChecked()
            } else if(areNoButtonsSelected()){
                binding.rvFlightList.visibility = View.GONE
            }
        }

        viewModel.flights.observe(viewLifecycleOwner){ flights ->
            if(flights.isNotEmpty()){
                binding.rvFlightList.visibility = View.VISIBLE
                binding.viewLineSeparator.visibility = View.VISIBLE
                binding.tvEmptyList.visibility = View.GONE
                binding.ivState.visibility = View.GONE

                flightListAdapter.updateFlightList(flights)
            }else{
                binding.rvFlightList.visibility = View.GONE
                binding.viewLineSeparator.visibility = View.GONE
                binding.tvEmptyList.visibility = View.VISIBLE
                binding.ivState.visibility = View.VISIBLE
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun areNoButtonsSelected(): Boolean {
        val toggleGroup1 = binding.tbFlightListLine1
        val toggleGroup2 = binding.tbFlightListLine2

        // Verifica se nenhum botão está selecionado em ambos os grupos
        val noButtonSelectedInGroup1 = toggleGroup1.checkedButtonId == View.NO_ID
        val noButtonSelectedInGroup2 = toggleGroup2.checkedButtonId == View.NO_ID

        return noButtonSelectedInGroup1 && noButtonSelectedInGroup2
    }

}