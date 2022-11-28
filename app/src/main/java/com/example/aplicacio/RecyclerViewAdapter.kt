package com.example.aplicacio
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.aplicacio.DB.Pelicula
import com.example.aplicacio.DB.PeliculasDBHelper
import com.squareup.picasso.Picasso
//el adaptador para la lista de películas
class RecyclerViewAdapter(llistat: ArrayList<Pelicula>, context: Context?,db:PeliculasDBHelper): RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    var llistat: ArrayList<Pelicula> = llistat
    var context: Context? = context
    var dbHelper = db


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val Image: ImageView = view.findViewById(R.id.imageView)
        val txtTitulo: TextView = view.findViewById(R.id.titulo)
        val txtDirector: TextView = view.findViewById(R.id.director)
        val rmvItem: Button = view.findViewById(R.id.rmvItem);
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_list, parent, false))
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Picasso.get().load(llistat[position].getImage()).into(holder.Image)
        holder.txtTitulo.setText(llistat.get(position).getTitulo())
        holder.txtDirector.setText(llistat.get(position).getDirector())
        holder.itemView.setOnClickListener(object:View.OnClickListener{
            override fun onClick(v: View?) {
                val activity = v!!.context as AppCompatActivity
                activity.supportFragmentManager.beginTransaction().replace(R.id.fragment_container, DetailFragment(llistat.get(position))).commit();
            }
        })

        holder.rmvItem.setOnClickListener(object:View.OnClickListener{
            override fun onClick(v: View?) {
                dbHelper.deletePelicula(llistat.get(position).id!!)
                llistat.removeAt(position)
                notifyItemRemoved(position)
                notifyItemRangeChanged(position, llistat.size)
            }
        })
    }
    override fun getItemCount(): Int {
        return llistat.size
    }


}
