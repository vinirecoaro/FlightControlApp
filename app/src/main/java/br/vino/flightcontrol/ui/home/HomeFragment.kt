package br.vino.flightcontrol.ui.home

import android.content.res.Configuration
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.vino.flightcontrol.R
import org.koin.android.ext.android.inject
import br.vino.flightcontrol.databinding.FragmentHomeBinding
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.PercentFormatter
import java.text.NumberFormat

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val viewModel : HomeViewModel by inject()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        viewModel.getFlightsInfo()
        setupListeners()

        return root
    }

    private fun setupListeners(){
        viewModel.flightsPerStatusList.observe(viewLifecycleOwner){ flightsList ->
            initExpensePerCategoryChart(flightsList)
            val nOfCategories = flightsList.size
            val colors = viewModel.getPieChartCategoriesColors()
            when (nOfCategories) {
                1 -> {
                    //Visibility
                    binding.ivIconFlightsLegend1.visibility = View.VISIBLE
                    binding.tvTextFlightsList1.visibility = View.VISIBLE
                    binding.ivIconFlightsLegend2.visibility = View.GONE
                    binding.tvTextFlightsList2.visibility = View.GONE
                    binding.ivIconFlightsLegend3.visibility = View.GONE
                    binding.tvTextFlightsList3.visibility = View.GONE
                    binding.ivIconFlightsLegend4.visibility = View.GONE
                    binding.tvTextFlightsList4.visibility = View.GONE
                    binding.ivIconFlightsLegend5.visibility = View.GONE
                    binding.tvTextFlightsList5.visibility = View.GONE

                    //Colors
                    binding.ivIconFlightsLegend1.setColorFilter(colors[0])

                    //Text
                    val text1 = "${flightsList[0].second} Voos:\n${flightsList[0].first}"
                    binding.tvTextFlightsList1.text = text1
                }
                2 -> {
                    //Visibility
                    binding.ivIconFlightsLegend1.visibility = View.VISIBLE
                    binding.tvTextFlightsList1.visibility = View.VISIBLE
                    binding.ivIconFlightsLegend2.visibility = View.VISIBLE
                    binding.tvTextFlightsList2.visibility = View.VISIBLE
                    binding.ivIconFlightsLegend3.visibility = View.GONE
                    binding.tvTextFlightsList3.visibility = View.GONE
                    binding.ivIconFlightsLegend4.visibility = View.GONE
                    binding.tvTextFlightsList4.visibility = View.GONE
                    binding.ivIconFlightsLegend5.visibility = View.GONE
                    binding.tvTextFlightsList5.visibility = View.GONE

                    //Colors
                    binding.ivIconFlightsLegend1.setColorFilter(colors[0])
                    binding.ivIconFlightsLegend2.setColorFilter(colors[1])

                    //Text
                    val text1 = "${flightsList[0].second} Voos:\n${flightsList[0].first}"
                    binding.tvTextFlightsList1.text = text1
                    val text2 = "${flightsList[1].second} Voos:\n${flightsList[1].first}"
                    binding.tvTextFlightsList2.text = text2
                }
                3 -> {
                    //Visibility
                    binding.ivIconFlightsLegend1.visibility = View.VISIBLE
                    binding.tvTextFlightsList1.visibility = View.VISIBLE
                    binding.ivIconFlightsLegend2.visibility = View.VISIBLE
                    binding.tvTextFlightsList2.visibility = View.VISIBLE
                    binding.ivIconFlightsLegend3.visibility = View.VISIBLE
                    binding.tvTextFlightsList3.visibility = View.VISIBLE
                    binding.ivIconFlightsLegend4.visibility = View.GONE
                    binding.tvTextFlightsList4.visibility = View.GONE
                    binding.ivIconFlightsLegend5.visibility = View.GONE
                    binding.tvTextFlightsList5.visibility = View.GONE

                    //Colors
                    binding.ivIconFlightsLegend1.setColorFilter(colors[0])
                    binding.ivIconFlightsLegend2.setColorFilter(colors[1])
                    binding.ivIconFlightsLegend3.setColorFilter(colors[2])

                    //Text
                    val text1 = "${flightsList[0].second} Voos:\n${flightsList[0].first}"
                    binding.tvTextFlightsList1.text = text1
                    val text2 = "${flightsList[1].second} Voos:\n${flightsList[1].first}"
                    binding.tvTextFlightsList2.text = text2
                    val text3 = "${flightsList[2].second} Voos:\n${flightsList[2].first}"
                    binding.tvTextFlightsList3.text = text3
                }
                4 -> {
                    //Visibility
                    binding.ivIconFlightsLegend1.visibility = View.VISIBLE
                    binding.tvTextFlightsList1.visibility = View.VISIBLE
                    binding.ivIconFlightsLegend2.visibility = View.VISIBLE
                    binding.tvTextFlightsList2.visibility = View.VISIBLE
                    binding.ivIconFlightsLegend3.visibility = View.VISIBLE
                    binding.tvTextFlightsList3.visibility = View.VISIBLE
                    binding.ivIconFlightsLegend4.visibility = View.VISIBLE
                    binding.tvTextFlightsList4.visibility = View.VISIBLE
                    binding.ivIconFlightsLegend5.visibility = View.GONE
                    binding.tvTextFlightsList5.visibility = View.GONE

                    //Colors
                    binding.ivIconFlightsLegend1.setColorFilter(colors[0])
                    binding.ivIconFlightsLegend2.setColorFilter(colors[1])
                    binding.ivIconFlightsLegend3.setColorFilter(colors[2])
                    binding.ivIconFlightsLegend4.setColorFilter(colors[3])

                    //Text
                    val text1 = "${flightsList[0].second} Voos:\n${flightsList[0].first}"
                    binding.tvTextFlightsList1.text = text1
                    val text2 = "${flightsList[1].second} Voos:\n${flightsList[1].first}"
                    binding.tvTextFlightsList2.text = text2
                    val text3 = "${flightsList[2].second} Voos:\n${flightsList[2].first}"
                    binding.tvTextFlightsList3.text = text3
                    val text4 = "${flightsList[3].second} Voos:\n${flightsList[3].first}"
                    binding.tvTextFlightsList4.text = text4
                }
                5 -> {
                    //Visibility
                    binding.ivIconFlightsLegend1.visibility = View.VISIBLE
                    binding.tvTextFlightsList1.visibility = View.VISIBLE
                    binding.ivIconFlightsLegend2.visibility = View.VISIBLE
                    binding.tvTextFlightsList2.visibility = View.VISIBLE
                    binding.ivIconFlightsLegend3.visibility = View.VISIBLE
                    binding.tvTextFlightsList3.visibility = View.VISIBLE
                    binding.ivIconFlightsLegend4.visibility = View.VISIBLE
                    binding.tvTextFlightsList4.visibility = View.VISIBLE
                    binding.ivIconFlightsLegend5.visibility = View.VISIBLE
                    binding.tvTextFlightsList5.visibility = View.VISIBLE

                    //Colors
                    binding.ivIconFlightsLegend1.setColorFilter(colors[0])
                    binding.ivIconFlightsLegend2.setColorFilter(colors[1])
                    binding.ivIconFlightsLegend3.setColorFilter(colors[2])
                    binding.ivIconFlightsLegend4.setColorFilter(colors[3])
                    binding.ivIconFlightsLegend5.setColorFilter(colors[4])

                    //Text
                    val text1 = "${flightsList[0].second} Voos:\n${flightsList[0].first}"
                    binding.tvTextFlightsList1.text = text1
                    val text2 = "${flightsList[1].second} Voos:\n${flightsList[1].first}"
                    binding.tvTextFlightsList2.text = text2
                    val text3 = "${flightsList[2].second} Voos:\n${flightsList[2].first}"
                    binding.tvTextFlightsList3.text = text3
                    val text4 = "${flightsList[3].second} Voos:\n${flightsList[3].first}"
                    binding.tvTextFlightsList4.text = text4
                    val text5 = "${flightsList[4].second} Voos:\n${flightsList[4].first}"
                    binding.tvTextFlightsList5.text = text5
                }
            }
        }
    }

    private fun initExpensePerCategoryChart(flightsList : List<Pair<String, Int>>) {

        val pieChart = binding.pcFlightsOverview
        var holeColor = 1

        // Defining chart insede hole color
        when (context?.resources?.configuration?.uiMode?.and(Configuration.UI_MODE_NIGHT_MASK)) {
            Configuration.UI_MODE_NIGHT_YES -> {
                holeColor = Color.rgb(104, 110, 106)
            }
            Configuration.UI_MODE_NIGHT_NO -> {
                holeColor = Color.WHITE
            }
            Configuration.UI_MODE_NIGHT_UNDEFINED -> {}
        }

        // Create a entries list for Pie Chart and set a color for each entry
        val entries = mutableListOf<PieEntry>()
        val paletteColors = viewModel.getPieChartCategoriesColors()
        val colors = mutableListOf<Int>()
        flightsList.forEachIndexed { index, category ->
            entries.add(PieEntry(category.second.toFloat(), category.first))
            colors.add(paletteColors[index])
        }

        // Create a data set from entries
        val dataSet = PieDataSet(entries, "Flights")
        dataSet.colors = colors

        // Data set customizing
        dataSet.sliceSpace = 2f

        // Create an PieData object from data set
        val pieData = PieData(dataSet)
        pieData.setValueFormatter(PercentFormatter(pieChart)) // Format value as percentage

        // Configure the PieChart
        pieChart.data = pieData
        pieChart.setUsePercentValues(false)
        pieChart.description.isEnabled = false
        pieChart.setHoleRadius(55f) // middle chart hole size
        pieChart.setTransparentCircleRadius(60f) // Transparent area size
        pieChart.setHoleColor(holeColor)
        pieChart.legend.isEnabled = false

        // Ocult label values
        pieData.setDrawValues(false)
        pieChart.setDrawEntryLabels(false)

        // Circular animation on create chart
        pieChart.animateY(1400, Easing.EaseInOutQuad)

        // Update the chart
        pieChart.invalidate()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}