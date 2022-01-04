package br.com.cwi.rocar.presentation.feature.initial.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import br.com.cwi.rocar.databinding.FragmentQueryClientBinding
import br.com.cwi.rocar.databinding.ItemQueryClientBinding
import br.com.cwi.rocar.databinding.ItemQueryVehicleBinding
import br.com.cwi.rocar.domain.entity.Client
import br.com.cwi.rocar.domain.entity.Vehicle
import br.com.cwi.rocar.presentation.feature.initial.query.client.QueryClientFragment

class QueryVehicleViewHolder(
    itemView: View,
    private val onVehicleClick: (Vehicle) -> Unit
) : RecyclerView.ViewHolder(itemView) {
    private val tvmodel = ItemQueryVehicleBinding.bind(itemView).tvModel
    private val tvboard = ItemQueryVehicleBinding.bind(itemView).tvBoard



    fun bind(vehicle: Vehicle) {
        tvmodel.text = (vehicle.brand + "/" + vehicle.model)
        tvboard.text = (vehicle.board)

        itemView.setOnClickListener {
            onVehicleClick(vehicle)
        }


    }


}