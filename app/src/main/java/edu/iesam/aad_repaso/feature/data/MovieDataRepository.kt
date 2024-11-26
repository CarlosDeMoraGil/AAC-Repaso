package edu.iesam.aad_repaso.feature.data

import android.util.Log
import edu.iesam.aad_repaso.feature.data.local.MovieDbLocalDataSource
import edu.iesam.aad_repaso.feature.domain.Movie
import edu.iesam.aad_repaso.feature.domain.MovieRepository
import org.koin.core.annotation.Single

@Single
class MovieDataRepository(
    private val localDbDataSource: MovieDbLocalDataSource,
    private val localXmlDataSource: MovieDbLocalDataSource

) : MovieRepository {

    override fun findAll(): List<Movie> {
        val localRoom = localDbDataSource.findAll()

        if (localRoom.isEmpty()) {
            val localXml = localXmlDataSource.findAll()

            localDbDataSource.saveAll(localXml)

            Log.d("@dev", "XML-DATA")
            return localXml
        } else {
            Log.d("@dev", "ROOM-DATA")
            return localRoom
        }
    }


}