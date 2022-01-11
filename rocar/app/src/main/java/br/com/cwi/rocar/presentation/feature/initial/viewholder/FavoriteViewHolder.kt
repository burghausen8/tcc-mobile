package br.com.cwi.rocar.presentation.feature.initial.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import br.com.cwi.nespresso_app.data.database.entity.ClientEntity
import br.com.cwi.rocar.databinding.ItemFavoriteBinding

class FavoriteViewHolder(
    itemView: View,
    private val onClientClick: (ClientEntity) -> Unit,
) : RecyclerView.ViewHolder(itemView) {
    private val tvname = ItemFavoriteBinding.bind(itemView).tvName
    private val tvstreet = ItemFavoriteBinding.bind(itemView).tvStreet

    fun bind(item: ClientEntity) {
        tvname.text = item.name
        tvstreet.text = (item.street + ", " + item.nHome)

        itemView.setOnClickListener {
            onClientClick(item)
        }
    }
}