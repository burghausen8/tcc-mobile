package br.com.cwi.rocar.presentation.feature.initial.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import br.com.cwi.rocar.databinding.ItemQueryVehicleBinding
import br.com.cwi.rocar.domain.entity.Vehicle

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