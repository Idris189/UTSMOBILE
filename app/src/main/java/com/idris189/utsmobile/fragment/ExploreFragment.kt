package com.idris189.utsmobile.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.idris189.utsmobile.DetailMovieActivity
import com.idris189.utsmobile.Movie
import com.idris189.utsmobile.MovieAdapter
import com.idris189.utsmobile.R


class ExploreFragment : Fragment() {

    companion object {
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    private lateinit var adapter: MovieAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var movieArrayList: ArrayList<Movie>

    lateinit var image: Array<Int>
    lateinit var title: Array<String>
    lateinit var descriptions: Array<String>


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_explore, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.rv_movie)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = MovieAdapter(movieArrayList){
            val intent = Intent(context, DetailMovieActivity::class.java)
            intent.putExtra(INTENT_PARCELABLE, it)
            startActivity(intent)
        }
    }
    private fun dataInitialize() {
        movieArrayList = arrayListOf<Movie>()

        image = arrayOf(
            R.drawable.bruno,
            R.drawable.casemiro,
            R.drawable.dalot,
            R.drawable.degea,
            R.drawable.fred,
            R.drawable.garnacho,
            R.drawable.martinez,
            R.drawable.rashford,
            R.drawable.shaw,
            R.drawable.varane,



        )
        title = arrayOf(
            getString(R.string.Bruno),
            getString(R.string.Casemiro),
            getString(R.string.Dalot),
            getString(R.string.DeGea),
            getString(R.string.Fred),
            getString(R.string.Garnacho),
            getString(R.string.Martinez),
            getString(R.string.Rashford),
            getString(R.string.Shaw),
            getString(R.string.Varane),

        )
        descriptions = arrayOf(
            getString(R.string.Bruno),
            getString(R.string.Casemiro),
            getString(R.string.Dalot),
            getString(R.string.DeGea),
            getString(R.string.Fred),
            getString(R.string.Garnacho),
            getString(R.string.Martinez),
            getString(R.string.Rashford),
            getString(R.string.Shaw),
            getString(R.string.Varane),
        )
        for (i in image.indices) {

            val movie = Movie(image[i],title[i], descriptions[i])
            movieArrayList.add(movie)
        }
    }
}


