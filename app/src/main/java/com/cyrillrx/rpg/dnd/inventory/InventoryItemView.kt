package com.cyrillrx.rpg.dnd.inventory

import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cyrillrx.android.utils.inflate
import com.cyrillrx.rpg.R
import com.cyrillrx.rpg.api.inventory.InventoryItem
import com.cyrillrx.rpg.setHtmlText

class InventoryItemView(parent: ViewGroup) :
    RecyclerView.ViewHolder(parent.inflate(R.layout.item_inventory)) {

    private var tvTitle: TextView = itemView.findViewById(R.id.tvTitle)
    private var tvSubtitle: TextView = itemView.findViewById(R.id.tvSubtitle)
    private var tvContent: TextView = itemView.findViewById(R.id.tvContent)

    fun bind(inventoryItem: InventoryItem) {

        tvTitle.text = inventoryItem.title
        tvSubtitle.text = """${inventoryItem.type}
            |${inventoryItem.rarity}
            |${inventoryItem.attunement}"""
            .trimMargin()
        tvContent.setHtmlText(inventoryItem.content)
    }
}
