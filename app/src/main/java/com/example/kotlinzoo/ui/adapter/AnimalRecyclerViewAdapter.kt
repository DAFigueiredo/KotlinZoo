package com.example.kotlinzoo.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinzoo.R
import com.example.kotlinzoo.business.model.Animal
import com.example.kotlinzoo.ui.activity.AnimalListActivity

/**
 * Created by firetrap on 15/09/2020
 */

class AnimalRecyclerViewAdapter : RecyclerView.Adapter<AnimalRecyclerViewAdapter.ViewHolder> {

    private val parentActivity: AnimalListActivity
    private val values: MutableList<Animal>
    private val twoPane: Boolean

    constructor(parentActivity: AnimalListActivity, values: MutableList<Animal>, twoPane: Boolean) : super() {
        this.parentActivity = parentActivity
        this.values = values
        this.twoPane = twoPane
        this.onClickListener = View.OnClickListener { view ->
//            val item = view.tag as DummyContent.DummyItem
//            if (twoPane) {
//                val fragment = AnimalDetailFragment().apply {
//                    arguments = Bundle().apply {
//                        putString(AnimalDetailFragment.ARG_ITEM_ID, item.id)
//                    }
//                }
//                parentActivity.supportFragmentManager
//                    .beginTransaction()
//                    .replace(R.id.animal_detail_container, fragment)
//                    .commit()
//            } else {
//                val intent = Intent(view.context, AnimalDetailActivity::class.java).apply {
//                    putExtra(AnimalDetailFragment.ARG_ITEM_ID, item.id)
//                }
//                view.context.startActivity(intent)
//            }
        }
    }

    private val onClickListener: View.OnClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.animal_list_content, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val animal = values[position]
        holder.idView.text = animal.name
        holder.contentView.text = animal.getDescription()

        with(holder.itemView) {
            tag = animal
            setOnClickListener(onClickListener)
        }
    }

    override fun getItemCount() = values.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val idView: TextView = view.findViewById(R.id.id_text)
        val contentView: TextView = view.findViewById(R.id.content)
    }
}