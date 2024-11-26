package edu.iesam.aad_repaso.feature.data.local

import android.content.Context
import com.google.gson.Gson
import edu.iesam.aad_repaso.R
import edu.iesam.aad_repaso.feature.domain.Movie

class MovieXmlLocalDataSource(private val context: Context) {

    private val sharedPref = context.getSharedPreferences(
        context.getString(R.string.movie_name_file_xml),
        Context.MODE_PRIVATE
    )

    private val gson = Gson()
    private val editor = sharedPref.edit()

    fun save(movie: Movie){
        editor.apply{
           putString(movie.id, gson.toJson(movie))
            apply()
        }

    }
    
    fun saveAll(movieList: List<Movie>){
        editor.apply{
            movieList.forEach { 
                putString(it.id, gson.toJson(it))
            }
            apply()
        }
        
    }

    fun findAll(): List<Movie>{
        val movies = ArrayList<Movie>()
        val mapMovies = sharedPref.all

        mapMovies.values.forEach { jsonMovie ->
            val movie = gson.fromJson(jsonMovie as String, Movie::class.java)
            movies.add(movie)
        }
        return movies

    }
    
    fun find(movieId: String): Movie?{
        return sharedPref.getString(movieId, null)?.let {
            gson.fromJson(it, Movie::class.java)
        }
    }

    fun removeById(movieId: String){
        editor.remove(movieId).apply()
    }

    fun clean(){
        editor.clear().apply()
    }

}