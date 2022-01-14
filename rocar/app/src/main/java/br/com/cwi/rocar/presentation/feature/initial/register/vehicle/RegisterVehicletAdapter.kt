package br.com.cwi.rocar.presentation.feature.initial.register.vehicle

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.*
import br.com.cwi.rocar.R
import br.com.cwi.rocar.domain.entity.Client
import br.com.cwi.rocar.presentation.feature.initial.viewholder.RegisterVehicleViewHolder

class RegisterVehicletAdapter(
    private val list: List<Client>,
    private val onClientClick: (Client) -> Unit
) : Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = inflateView(R.layout.item_query_client, parent)
        return RegisterVehicleViewHolder(view, onClientClick)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val item = list[position]

        (viewHolder as RegisterVehicleViewHolder).bind(item)
    }

    override fun getItemCount() = list.size

    private fun inflateView(layout: Int, parent: ViewGroup) = LayoutInflater.from(parent.context)
        .inflate(layout, parent, false)
}