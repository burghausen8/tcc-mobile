package br.com.cwi.rocar.presentation.feature.initial.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import br.com.cwi.rocar.databinding.ItemQueryClientBinding
import br.com.cwi.rocar.domain.entity.Client

class QueryClientViewHolder(
    itemView: View,
    private val onClientClick: (Client) -> Unit
) : RecyclerView.ViewHolder(itemView) {
    private val tvname = ItemQueryClientBinding.bind(itemView).tvName
    private val tvstreet = ItemQueryClientBinding.bind(itemView).tvStreet

    fun bind(item: Client) {
        tvname.text = item.name
        tvstreet.text = item.street

        itemView.setOnClickListener {
            onClientClick(item)
        }
    }

}