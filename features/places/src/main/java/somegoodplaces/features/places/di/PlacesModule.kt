package somegoodplaces.features.places.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import somegoodplaces.features.places.data.PlacesRepository
import somegoodplaces.features.places.data.online.PlacesApi
import somegoodplaces.features.places.data.online.PlacesOnlineRepository
import somegoodplaces.libraries.network.ApiClientBuilder


@Module
@InstallIn(ActivityComponent::class)
abstract class PlacesModule {
    @Binds
    internal abstract fun bindPlacesRepository(repo: PlacesOnlineRepository): PlacesRepository

    @Provides
    internal fun providesPlacesApi() = ApiClientBuilder.createApi(PlacesApi::class.java)
}