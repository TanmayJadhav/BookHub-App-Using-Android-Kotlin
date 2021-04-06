package com.bookhub.fragment


import android.content.Context
import android.os.Build.VERSION_CODES.P
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.bookhub.R
import com.bookhub.adapter.DashboardRecyclerAdapter
import com.bookhub.model.Book
import java.util.*

class  DashboardFragment : Fragment() {


    lateinit var recyclerDashboard: RecyclerView
    lateinit var layoutManager: RecyclerView.LayoutManager

    val bookList = arrayListOf(
        "P.S I Love You",
        "The Gray Gatsby",
        "Anna Karenina",
        "Madam Bovary",
        "War and Peace",
        "The Alchemist",
        "Lord of the Rings"
    )

    val bookInfoList = arrayListOf<Book>(
            Book("P.S I Love You","Cecelia Ahren","Rs. 299","4.5",R.drawable.ps_i_love_you,"asdsdafsad"),
            Book("The Gray Gatsby","F. Scott Fitzgerland","Rs. 399","4.3",R.drawable.the_gray_gatsby,""),
            Book("Anna Karenina","Leo Tolstoy","Rs. 199","4.4",R.drawable.anna_karenina,""),
            Book("Madam Bovary","Gustave Fluabert","Rs. 500","4.8",R.drawable.madam_bovary,""),
            Book("War and Peace","Leo Tolstoy","Rs. 249","4.2",R.drawable.war_and_peace,""),
            Book("Alchemist","Paulo Coelho","Rs. 349","4.9",R.drawable.alchemist,""),
            Book("Lord of the Rings","J.R.R Tolkein","Rs. 799","5.0",R.drawable.lord_of_the_rings,""),

    )

    lateinit var recyclerAdapter: DashboardRecyclerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_dashboard, container, false)

        recyclerDashboard = view.findViewById(R.id.recyclerDashboard)

        layoutManager = LinearLayoutManager(activity);

        recyclerAdapter = DashboardRecyclerAdapter(activity as Context , bookInfoList)

        recyclerDashboard.adapter = recyclerAdapter

        recyclerDashboard.layoutManager = layoutManager

        recyclerDashboard.addItemDecoration(
                DividerItemDecoration(
                        recyclerDashboard.context,
                        (layoutManager as LinearLayoutManager).orientation
                )
        )



        return view
    }
}


