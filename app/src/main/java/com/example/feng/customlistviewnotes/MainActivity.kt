package com.example.feng.customlistviewnotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var bookList: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bookList = findViewById(R.id.book_listview)

        var books = ArrayList<BookModel>()

        val bookTitles = arrayOf(
            "Kindred",
            "Hamlet",
            "The Awakening",
            "Fireborne",
            "1984",
            "The Poisonwood Bible",
            "Burn",
            "The Raven Boys",
            "The Lightning Thief",
            "The Hunger Games"
        )

        val bookAuthors = arrayOf(
            "Octavia Butler",
            "William Shakespeare",
            "Kate Chopin",
            "Rosaria Munda",
            "George Orwell",
            "Barbara Kingsolver",
            "Patrick Ness",
            "Maggie Stiefvater",
            "Rick Riordan",
            "Suzanne Collins"
        )

        val bookCovers = intArrayOf(
            R.drawable.kindred_cover,
            R.drawable.hamlet_cover,
            R.drawable.awakening_cover,
            R.drawable.fireborne_cover,
            R.drawable.nineteeneightyfour_cover,
            R.drawable.poisonwoodbible_cover,
            R.drawable.burn_cover,
            R.drawable.raven_boys_cover,
            R.drawable.lightning_thief_cover,
            R.drawable.hunger_games_cover
        )

        val bookGenres = arrayOf(
            "Science Fiction",
            "Classics",
            "Classics",
            "Fantasy",
            "Dystopian",
            "Literary",
            "Fantasy",
            "Fantasy",
            "Fantasy",
            "Dystopian"
        )

        for (i in bookTitles.indices)
            books.add(BookModel(bookTitles[i], bookCovers[i], bookAuthors[i], bookGenres[i]))

        bookList.adapter = MyCustomBookAdapter(this, R.layout.custom_booklist_layout, books)

        bookList.setOnItemClickListener{parent, view, index, id ->
            Toast.makeText(this, "You Selected: " + books.get(index).name, Toast.LENGTH_SHORT).show()
        }
    }

}