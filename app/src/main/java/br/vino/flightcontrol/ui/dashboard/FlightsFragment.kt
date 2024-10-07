package br.vino.flightcontrol.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import br.vino.flightcontrol.databinding.FragmentFlightsBinding

class FlightsFragment : Fragment() {

    private var _binding: FragmentFlightsBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<FlightsViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFlightsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}