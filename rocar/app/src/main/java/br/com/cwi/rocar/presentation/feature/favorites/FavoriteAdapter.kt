package br.com.cwi.rocar.presentation.feature.favorites

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.*
import br.com.cwi.nespresso_app.data.database.entity.ClientEntity
import br.com.cwi.rocar.R
import br.com.cwi.rocar.presentation.feature.initial.viewholder.FavoriteViewHolder

class FavoriteAdapter(
    private val list: List<ClientEntity>,
    private val onClientClick: (ClientEntity) -> Unit,
) : Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = inflateView(R.layout.item_favorite, parent)
        return FavoriteViewHolder(view, onClientClick)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        val item = list[position]
        (viewHolder as FavoriteViewHolder).bind(item)
    }

    override fun getItemCount() = list.size

    private fun inflateView(layout: Int, parent: ViewGroup) = LayoutInflater.from(parent.context)
        .inflate(layout, parent, false)
}