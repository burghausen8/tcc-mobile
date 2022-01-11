package br.com.cwi.rocar.presentation.feature.initial.query.vehicle

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.*
import br.com.cwi.rocar.R
import br.com.cwi.rocar.domain.entity.Vehicle
import br.com.cwi.rocar.presentation.feature.initial.viewholder.QueryVehicleViewHolder

class QueryVehicleAdapter(
    private val list: List<Vehicle>,
    private val onVehicleClick: (Vehicle) -> Unit
) : Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = inflateView(R.layout.item_query_vehicle, parent)
        return QueryVehicleViewHolder(view, onVehicleClick)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val item = list[position]

        (viewHolder as QueryVehicleViewHolder).bind(item)
    }

    override fun getItemCount() = list.size

    private fun inflateView(layout: Int, parent: ViewGroup) = LayoutInflater.from(parent.context)
        .inflate(layout, parent, false)
}