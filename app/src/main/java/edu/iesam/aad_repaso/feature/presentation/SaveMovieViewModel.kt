package edu.iesam.aad_repaso.feature.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.iesam.aad_repaso.feature.domain.Movie
import edu.iesam.aad_repaso.feature.domain.SaveMovieUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class SaveMovieViewModel(private val saveMovieUseCase: SaveMovieUseCase) : ViewModel() {

    fun saveMovie(movie: Movie) {
        viewModelScope.launch(Dispatchers.IO) {
            saveMovieUseCase.invoke(movie)
        }

    }
}