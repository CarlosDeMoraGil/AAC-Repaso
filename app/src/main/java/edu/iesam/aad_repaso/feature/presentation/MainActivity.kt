package edu.iesam.aad_repaso.feature.presentation

import android.os.Bundle

import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import edu.iesam.aad_repaso.R
import edu.iesam.aad_repaso.feature.data.local.MovieXmlLocalDataSource
import edu.iesam.aad_repaso.feature.domain.Movie

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val movie = Movie("0", "White chicks", "90")

        val movies = listOf(
            Movie("1", "Wicked", "160"),
            Movie("2", "The Lord of the Rings", "180"),
            Movie("3", "Inception", "148")
        )

        val local = MovieXmlLocalDataSource(this)

        local.save(movie)
        local.saveAll(movies)
        Log.d("@dev", local.findAll().toString())
        Log.d("@dev", local.find("1").toString())
        local.removeById("2")
        local.clean()


    }
}
