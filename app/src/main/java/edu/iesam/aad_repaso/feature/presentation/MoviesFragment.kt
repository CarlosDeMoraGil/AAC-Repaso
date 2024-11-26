package edu.iesam.aad_repaso.feature.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import edu.iesam.aad_repaso.databinding.FragmentMoviesBinding
import edu.iesam.aad_repaso.feature.domain.Movie
import org.koin.androidx.viewmodel.ext.android.viewModel

class MoviesFragment : Fragment() {

    private var _binding: FragmentMoviesBinding? = null
    private val binding get() = _binding!!

    private val moviesViewModel: MoviesViewModel by viewModel()
    private val saveMovieViewModel: SaveMovieViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMoviesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val movie = Movie("0", "White chicks", "90")

        /**
         *  EN CASO DE SAVEALL
         * val movies = listOf(
         *             Movie("1", "Wicked", "160"),
         *             Movie("2", "The Lord of the Rings", "180"),
         *             Movie("3", "Inception", "148")
         *         )
         *
         */


        saveMovieViewModel.saveMovie(movie)

        moviesViewModel.findAll()

        setUpObserver()
    }

    private fun setUpObserver() {
        val observer = Observer<MoviesViewModel.UiState> { uiState ->
            uiState.movies?.let {
                Log.d("@dev", it.toString())
            }
        }

        moviesViewModel.uiState.observe(viewLifecycleOwner, observer)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
