package com.example.lab5

import android.content.ClipData.Item
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class task2 : AppCompatActivity(), ItemAdapter.OnItemClickListener {

    var counter = 1
    private lateinit var itemAdapter: ItemAdapter
    private val listItems = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task2)

        itemAdapter = ItemAdapter(listItems, this)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = itemAdapter

        findViewById<Button>(R.id.buttonAdd).setOnClickListener {
            val textItem = "Item " + counter
            itemAdapter.addItem(textItem)
            counter++
        }
    }

    override fun onItemClicked(item: String) {
        itemAdapter.removeItem(item)
    }
}

class ItemAdapter(private val items:MutableList<String>, private val itemClickListener: OnItemClickListener) : RecyclerView.Adapter<ItemAdapter.MyViewHolder>() {
    class MyViewHolder(itemView: View, private val itemClickListener: ItemAdapter.OnItemClickListener) : RecyclerView.ViewHolder(itemView) {
        val textView = itemView.findViewById<TextView>(R.id.textListColor)
        val itemClick = itemClickListener
    }

    fun addItem(item : String) {
        items.add(item)
        notifyDataSetChanged()
    }

    fun removeItem(item : String) {
        items.remove(item)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item, parent, false)
        return MyViewHolder(itemView, itemClickListener)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.textView.text = items[position]
        holder.textView.setOnClickListener {
            holder.itemClick.onItemClicked(items[position])
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    interface OnItemClickListener{
        fun onItemClicked(item : String)
    }
}