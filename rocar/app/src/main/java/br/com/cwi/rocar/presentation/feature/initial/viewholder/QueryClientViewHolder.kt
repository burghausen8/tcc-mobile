package br.com.cwi.rocar.presentation.feature.initial.viewholder

import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import br.com.cwi.rocar.R
import br.com.cwi.rocar.databinding.ItemQueryClientBinding
import br.com.cwi.rocar.domain.entity.Client

class QueryClientViewHolder(
    itemView: View,
    private val onClientClick: (Client) -> Unit,
    private val onFavoriteClick: (Client) -> Unit
) : RecyclerView.ViewHolder(itemView) {
    private val tvname = ItemQueryClientBinding.bind(itemView).tvName
    private val tvstreet = ItemQueryClientBinding.bind(itemView).tvStreet
    private val ivFavorite = ItemQueryClientBinding.bind(itemView).ivFavorite

    fun bind(item: Client) {
        tvname.text = item.name
        tvstreet.text = (item.street + ", " + item.nHome)

        itemView.setOnClickListener {
            onClientClick(item)
        }

        with(ivFavorite) {
            setImageDrawable(getFavoriteIcon(item))
            setOnClickListener {
                item.isFavorite = !item.isFavorite
                setImageDrawable(getFavoriteIcon(item))
                onFavoriteClick(item)
            }
        }
    }

    private fun getFavoriteIcon(client: Client) = ContextCompat.getDrawable(
        itemView.context,
        if (client.isFavorite) R.drawable.ic_favorite_filled
        else R.drawable.ic_favorite_rounded
    )
}