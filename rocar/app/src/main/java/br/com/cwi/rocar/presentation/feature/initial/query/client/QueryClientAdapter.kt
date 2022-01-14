package br.com.cwi.rocar.presentation.feature.initial.query.client

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.*
import br.com.cwi.rocar.R
import br.com.cwi.rocar.domain.entity.Client
import br.com.cwi.rocar.presentation.feature.initial.viewholder.QueryClientViewHolder

class QueryClientAdapter(
    private val list: List<Client>,
    private val onClientClick: (Client) -> Unit,
    private val onFavoriteClick: (Client) -> Unit,
) : Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = inflateView(R.layout.item_query_client, parent)
        return QueryClientViewHolder(view, onClientClick, onFavoriteClick)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        val item = list[position]
        (viewHolder as QueryClientViewHolder).bind(item)
    }

    override fun getItemCount() = list.size

    private fun inflateView(layout: Int, parent: ViewGroup) = LayoutInflater.from(parent.context)
        .inflate(layout, parent, false)
}