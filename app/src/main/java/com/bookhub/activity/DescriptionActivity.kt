package com.bookhub.activity

import android.content.Context
import android.content.Intent
import android.media.Image
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import com.bookhub.R
import com.bookhub.adapter.DashboardRecyclerAdapter
import com.bookhub.fragment.DashboardFragment

class DescriptionActivity : AppCompatActivity() {



    lateinit var txtBookName : TextView
    lateinit var txtBookAuthor : TextView
    lateinit var txtBookPrice : TextView
    lateinit var txtBookRating : TextView
    lateinit var txtBookImage : ImageView
    lateinit var txtBookDesc : TextView
    lateinit var buyButton : Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_description)

        var backButton: ImageView = findViewById(R.id.back_button)
        val receivedbookName: String? = intent.getStringExtra("bookName")
        val receivedbookAuthor: String? = intent.getStringExtra("bookAuthor")
        val receivedbookPrice: String? = intent.getStringExtra("bookPrice")
        val receivedbookRating: String? = intent.getStringExtra("bookRating")
        val receivedbookDesc: String? = intent.getStringExtra("bookDesc")
        val receivedbookUrl: String? = intent.getStringExtra("bookUrl")


        txtBookName = findViewById(R.id.txtBookName)
        txtBookAuthor = findViewById(R.id.txtBookAuthor)
        txtBookPrice = findViewById(R.id.txtBookPrice)
        txtBookRating = findViewById(R.id.txtBookRating)
        txtBookImage  =  findViewById(R.id.txtBookImage)
        txtBookDesc = findViewById(R.id.txtBookDesc)
        buyButton = findViewById(R.id.buyBookBtn)





        txtBookName.text = receivedbookName
        txtBookAuthor.text = receivedbookAuthor
        txtBookPrice.text = receivedbookPrice.toString()
        txtBookRating.text = receivedbookRating
        txtBookDesc.text = receivedbookDesc

        buyButton.setOnClickListener {
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse(receivedbookUrl)
            startActivity(openURL)
        }


        if (receivedbookName =="Lord of the Rings")
        { txtBookImage.setBackgroundResource(R.drawable.lord_of_the_rings)}

        if (receivedbookName =="Alchemist")
        { txtBookImage.setBackgroundResource(R.drawable.alchemist)}

        if (receivedbookName =="War and Peace")
        { txtBookImage.setBackgroundResource(R.drawable.war_and_peace)}

        if (receivedbookName =="Madame Bovary")
        { txtBookImage.setBackgroundResource(R.drawable.madam_bovary)}

        if (receivedbookName =="P.S I Love You")
        { txtBookImage.setBackgroundResource(R.drawable.ps_i_love_you)}

        if (receivedbookName =="The Great Gatsby")
        { txtBookImage.setBackgroundResource(R.drawable.the_gray_gatsby)}

        if (receivedbookName =="Anna Karenina")
        { txtBookImage.setBackgroundResource(R.drawable.anna_karenina)}



        backButton.setOnClickListener {

            val intent  = Intent(this,MainActivity::class.java)
            startActivity(intent)

        }






        }


}