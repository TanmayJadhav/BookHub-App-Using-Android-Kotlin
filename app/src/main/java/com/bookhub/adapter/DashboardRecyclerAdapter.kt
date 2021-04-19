package com.bookhub.adapter

import android.content.Context
import android.content.Intent
import android.text.TextUtils.replace
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat.startActivity
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.bookhub.R
import com.bookhub.activity.DescriptionActivity
import com.bookhub.fragment.FavouriteFragment
import com.bookhub.model.Book

class DashboardRecyclerAdapter(val context: Context ,val itemList:ArrayList<Book>) : RecyclerView.Adapter<DashboardRecyclerAdapter.DashboardViewHolder>() {

    class DashboardViewHolder(view:View) : RecyclerView.ViewHolder(view)
    {
        val bookName : TextView = view.findViewById(R.id.txtBookName)
        val bookAuthor : TextView = view.findViewById(R.id.book_author)
        val bookRating : TextView = view.findViewById(R.id.rating)
        val bookPrice : TextView = view.findViewById(R.id.book_price)
        val bookImage : ImageView = view.findViewById(R.id.book_image)
        val book_click_listner : ConstraintLayout = view.findViewById(R.id.book_click)



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashboardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_dashboard_single_row,parent,false)

        return DashboardViewHolder(view)
    }

    override fun onBindViewHolder(holder: DashboardViewHolder, position: Int) {

        val book = itemList[position]
        holder.bookName.text = book.bookName
        holder.bookAuthor.text = book.bookAuthor
        holder.bookPrice.text = book.bookCost
        holder.bookRating.text = book.bookRating
        holder.bookImage.setBackgroundResource(book.bookImage)
//        var bookDescription = book.bookDescription

        holder.book_click_listner.setOnClickListener{
//            Toast.makeText(context,"Clicked on ${bookDescription}",Toast.LENGTH_LONG).show()

//            transition.FragmentManager.beginTransaction().replace(R.id.frameLayout, FavouriteFragment()).commit()
                val intent = Intent(context,DescriptionActivity::class.java)
                intent.putExtra("bookName",book.bookName)
                intent.putExtra("bookAuthor",book.bookAuthor)
                intent.putExtra("bookPrice",book.bookCost.toString())
                intent.putExtra("bookImage",book.bookImage)
                intent.putExtra("bookRating",book.bookRating)
                intent.putExtra("bookDesc",book.bookDescription)
                intent.putExtra("bookUrl",book.url)

            context.startActivity(intent)
        }


    }

    override fun getItemCount(): Int {
        return  itemList.size
    }

}