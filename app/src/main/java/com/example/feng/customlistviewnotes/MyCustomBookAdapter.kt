package com.example.feng.customlistviewnotes

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class MyCustomBookAdapter(var ctx: Context,
                          var myResource: Int,
                          var BookItems: ArrayList<BookModel>): ArrayAdapter<BookModel>(ctx, myResource, BookItems) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val layoutInflater = LayoutInflater.from(ctx)
        val bookView = layoutInflater.inflate(myResource, null)

        //go to the layout and get the links to all the views
        val name = bookView.findViewById<TextView>(R.id.book_name)
        val author = bookView.findViewById<TextView>(R.id.author_text)
        val genre = bookView.findViewById<TextView>(R.id.genre_text)
        val img = bookView.findViewById<ImageView>(R.id.book_image)

        //set values
        name.text = BookItems[position].name
        author.text = BookItems[position].author
        genre.text = BookItems[position].genre
        img.setImageResource(BookItems[position].image)

        return bookView
    }


}