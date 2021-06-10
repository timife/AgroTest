package com.timife.agromall.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.utils.ColorTemplate

class DashboardViewModel : ViewModel() {
    private val _pieChart: MutableLiveData<PieData> = MutableLiveData()
    val pieChart : LiveData<PieData>
        get() = _pieChart

    init {
//        salesBarData()
//        transactionsBarData()
        pieDataEntry()
    }

    private fun pieDataEntry(): ArrayList<PieEntry>{
        val colorClassArray = listOf(ColorTemplate.rgb("#4E2433"),ColorTemplate.rgb("#274E24"),ColorTemplate.rgb("#50CF46"),ColorTemplate.rgb("#3245F4"),ColorTemplate.rgb("#CD801F"))

        val dataVals : ArrayList<PieEntry> = ArrayList()
        dataVals.add(PieEntry(10F, "Subsistence"))
        dataVals.add(PieEntry(7F,"Commercial"))
        dataVals.add(PieEntry(3F, "Home"))
        dataVals.add(PieEntry(15F,"Container"))
        dataVals.add(PieEntry(10F,"Vertical"))
        val pieDataSet = PieDataSet(dataVals,"Series PieChart")
        pieDataSet.colors = colorClassArray
        val pieData = PieData(pieDataSet)
        _pieChart.value = pieData
        return dataVals

    }
}