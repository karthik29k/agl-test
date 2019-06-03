package au.com.energy.agl.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import au.com.energy.agl.R
import au.com.energy.agl.requests.Pet
import au.com.energy.agl.view.ItemViewUI
import org.jetbrains.anko.AnkoContext
import java.util.*

class PetDetailsAdapter(private var petDetailMutableList: MutableList<Pet>) : RecyclerView.Adapter<PetDetailsAdapter.ViewHolder>() {
    override fun onBindViewHolder(p0: ViewHolder, p1: Int) = p0.bind(petDetailMutableList[p1])

    override fun getItemCount(): Int = petDetailMutableList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
            ViewHolder(ItemViewUI().createView(AnkoContext.create(parent.context)))

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val txtType: TextView = itemView.findViewById(R.id.txtType) as TextView

        fun bind(contributor: Pet) {
            txtType.text = itemView.context.getString(R.string.typeTextString,
                    contributor.name, contributor.type)
        }
    }

    fun update(ls: List<Pet>) {
        petDetailMutableList = ls as MutableList<Pet>
        notifyDataSetChanged()
    }

    fun clearList() {
        petDetailMutableList = Collections.emptyList()
        notifyDataSetChanged()
    }
}