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
            Book("P.S I Love You","Cecelia Ahren","Rs. 299","4.5",R.drawable.ps_i_love_you,"Holly and Gerry are a married couple who live in Dublin. They are deeply in love, but they fight occasionally. By winter that year, Gerry suddenly dies of a brain tumor and Holly realizes how much he means to her as well as how insignificant their arguments were.\n" +
                    "\n" +
                    "Deeply distraught, Holly withdraws from her family and friends out of grief until her mother calls her informing her of a package addressed to her. Within the package are ten envelopes, one for each month after Gerry died, containing messages from him, all ending with \"P.S. I Love You\". As the months pass, each new message fills her with encouragement and sends her on a new adventure. With Gerry's words as her guide, Holly slowly embarks on a journey of rediscovery.","https://www.amazon.in/P-S-Love-You-Cecelia-Ahern/dp/0007270100"),
            Book("The Great Gatsby","F. Scott Fitzgerland","Rs. 399","4.3",R.drawable.the_gray_gatsby,"Set in what was called the Jazz Age (a term popularized by Fitzgerald), or the Roaring Twenties, The Great Gatsby vividly captures its historical moment: the economic boom of postwar America, the new jazz music, the free-flowing illegal liquor. As Fitzgerald later remarked in an essay about the era, it was “a whole race going hedonistic, deciding on pleasure.”\n"
                    +"\n" +" The brazenly lavish culture of West Egg is a reflection of the new prosperity that was possible during Prohibition, when illegal schemes involving the black-market selling of liquor abounded. Such criminal enterprises are the source of Gatsby’s income and finance his incredible parties, which are probably based on parties Fitzgerald himself attended when he lived on Long Island in the early 1920s.\n" +"\n"+" Even the racial anxieties of the period are evident in the novel Tom’s diatribe on The Rise of the Colored Empires—a reference to a real book published in 1920 by the American political scientist Lothrop Stoddard—points to the burgeoning eugenics movement in the United States during the early 20th century.","https://www.amazon.in/Great-Gatsby-F-Scott-Fitzgerald/dp/0743273567"),
            Book("Anna Karenina","Leo Tolstoy","Rs. 199","4.4",R.drawable.anna_karenina,"Anna Karenina is a long, intricately patterned novel divided into eight parts, each consisting of a series of short chapters. It begins with one of the most famous lines in literature: \"All happy families are alike; each unhappy family is unhappy in its own way.\" This statement sets the tone for the complex plot that follows.\n" +
                    "\n" +
                    "The novel opens in the home of Prince Stepán Arkádyich Oblónsky, known more commonly as Stiva. His is a household in chaos due, in part, to the discovery that Stiva has been unfaithful to his wife Dárya Alexandrovna (Dolly). Dolly is devastated by her discovery of a note that proves without doubt that her husband is an adulterer. Deeply troubled by the situation, Stiva remains oddly unremorseful, a man with a passion for amorous adventure that he cannot control.\n"
                    +"\n"+" To his mind, his behavior is perfectly natural, so he finds the family pressure to apologize to his wife unusual and, in the end, ineffective. When he does finally visit Dolly in her room, Stiva is rejected openly despite his admonitions to remember the good times in their marriage. Hopeful that another woman might influence his wife more positively, Stiva asks his married sister, Anna Karenina, to come from her home in St. Petersburg and convince Dolly not to leave Stiva.","https://www.amazon.in/Anna-Karenina-Penguin-Classics-Tolstoy/dp/0140449175"),
            Book("Madame Bovary","Gustave Fluabert","Rs. 500","4.8",R.drawable.madam_bovary,"Madame Bovary tells the bleak story of a marriage that ends in tragedy. Charles Bovary, a good-hearted but dull and unambitious doctor with a meagre practice, marries Emma, a beautiful farm girl raised in a convent. Although she anticipates marriage as a life of adventure, she soon finds that her only excitement derives from the flights of fancy she takes while reading sentimental romantic novels. She grows increasingly bored and unhappy with her middle-class existence, and even the birth of their daughter, Berthe, brings Emma little joy.\n" +
                    "\n" +
                    "Grasping for idealized intimacy, Emma begins to act out her romantic fantasies and embarks on an ultimately disastrous love affair with Rodolphe, a local landowner. She makes enthusiastic plans for them to run away together, but Rodolphe has grown tired of her and ends the relationship. A shocked Emma develops brain fever and is bedridden for more than a month. She later takes up with Léon, a former acquaintance, and her life becomes increasingly chaotic. She embraces abstractions—passion, happiness—and ignores material reality itself, as symbolized by money. She is utterly incapable of distinguishing between her romantic ideals and the harsh realities of her life even as her interest in Léon wanes. Her debts having spun out of control, she begs for money, but all turn her down, including Léon and Rodolphe. With seemingly nowhere to turn and on the verge of financial ruin and public disclosure of her private life, Emma swallows arsenic and dies a painful death.","https://www.amazon.in/Madame-Bovary-Gustave-Flaubert/dp/812480091X"),
            Book("War and Peace","Leo Tolstoy","Rs. 249","4.2",R.drawable.war_and_peace,"War and Peace is known for its realism, something Tolstoy achieved through intensive research. He visited battlefields, read history books on the Napoleonic Wars, and drew on real historical events to create a novel of living history. Tolstoy had originally planned to write a novel centring on the Decembrists, whose revolution in 1825 against the tsar attempted to end autocratic rule in Russia. The Decembrists failed, however, and those who were spared execution were sent to Siberia.\n" + "\n" + "Tolstoy wanted to depict a Decembrist, now old, returning from exile. As Tolstoy wrote and revised, however, the novel evolved into the War and Peace known today—a novel that takes place more than a decade before the Decembrist movement. The novel’s primary historical setting is the French invasion of Russia in 1812, which was a turning point in the Napoleonic Wars and a period of patriotic significance to Russia. Some historians argue that this invasion was the event that metamorphosed into the Decembrist movement years later.","https://www.amazon.in/War-Peace-Leo-Tolstoy/dp/8175992832"),
            Book("Alchemist","Paulo Coelho","Rs. 349","4.9",R.drawable.alchemist,"The Alchemist follows the journey of an Andalusian shepherd boy named Santiago. Believing a recurring dream to be prophetic, he asks a Gypsy fortune teller in the nearby town about its meaning. The woman interprets the dream as a prophecy telling the boy that he will discover a treasure at the Egyptian pyramids.\n" +
                    "\n" +
                    "Early into his journey, he meets an old king named Melchizedek, or the king of Salem, who tells him to sell his sheep, so as to travel to Egypt, and introduces the idea of a Personal Legend. Your Personal Legend \"is what you have always wanted to accomplish. Everyone, when they are young, knows what their Personal Legend is.\" \n" + "\n" + "Early in his arrival to Africa, a man who claims to be able to take Santiago to the pyramids instead robs him of what money he had made from selling his sheep. Santiago then embarks on a long path of working for a crystal merchant so as to make enough money to fulfill his personal legend and go to the pyramids.\n" +
                    "\n" +
                    "Along the way, the boy meets an Englishman who has come in search of an alchemist and continues his travels with his new companion. When they reach an oasis, Santiago meets and falls in love with an Arabian girl named Fatima, to whom he proposes marriage. She promises to do so only after he completes his journey. Frustrated at first, he later learns that true love will not stop nor must one sacrifice to it one's personal destiny, since to do so robs it of truth.\n" +
                    "\n" +
                    "The boy then encounters a wise alchemist who also teaches him to realize his true self. Together, they risk a journey through the territory of warring tribes, where the boy is forced to demonstrate his oneness with \"the soul of the world\" by turning himself into a simoom before he is allowed to proceed. When he begins digging within sight of the pyramids, he is robbed yet again, but accidentally learns from the leader of the thieves that the treasure he sought all along was in the ruined church where he had his original dream.","https://www.amazon.in/Alchemist-Paulo-Coelho/dp/8172234988"),
            Book("Lord of the Rings","J.R.R Tolkein","Rs. 799","5.0",R.drawable.lord_of_the_rings,"The Lord of the Rings, fantasy novel by J.R.R. Tolkien initially published in three parts as The Fellowship of the Ring (1954), The Two Towers (1955), and The Return of the King (1955).\n" + "\n" +"The novel, set in the Third Age of Middle-earth, formed a sequel to Tolkien’s The Hobbit (1937) and was succeeded by his posthumous The Silmarillion (1977). The Lord of the Rings is the saga of a group of sometimes reluctant heroes who set forth to save their world from consummate evil. Its many worlds and creatures were drawn from Tolkien’s extensive knowledge of philology and folklore.","https://www.amazon.in/Lord-Rings-J-R-Tolkien/dp/0618645616"),

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


