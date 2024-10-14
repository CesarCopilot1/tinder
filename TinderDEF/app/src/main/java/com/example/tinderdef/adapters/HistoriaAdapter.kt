package com.example.tinderdef.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.PagerAdapter
import com.example.tinderdef.R
import com.example.tinderdef.models.Historia
import java.util.*
// Interface para manejar interacciones de "Like" y "Dislike"
interface OnInteractionListener {
    fun onLiked(image: Int)
    fun onDisliked(image: Int)
}

class HistoriaAdapter(
    val context: Context,
    val imageList: MutableList<Int>,
    val listener: OnInteractionListener  // Listener para las interacciones
) : PagerAdapter() {

    override fun getCount(): Int {
        return imageList.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object` as RelativeLayout
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val mLayoutInflater =
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val itemView: View = mLayoutInflater.inflate(R.layout.historia_adapter, container, false)

        val imageView: ImageView = itemView.findViewById(R.id.idIVImage)
        val btnLike: Button = itemView.findViewById(R.id.idLike)
        val btnDislike: Button = itemView.findViewById(R.id.idDislike)

        imageView.setImageResource(imageList[position])

        // Click en el botón "Like"
        btnLike.setOnClickListener {
            listener.onLiked(imageList[position])
        }

        // Click en el botón "Dislike"
        btnDislike.setOnClickListener {
            listener.onDisliked(imageList[position])
        }

        container.addView(itemView)
        return itemView
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as RelativeLayout)
    }


}
