package somegoodplaces.features.places.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import somegoodplaces.features.places.data.PlacesRepository
import somegoodplaces.features.places.data.online.PlacesApi
import somegoodplaces.features.places.data.online.PlacesOnlineRepository
import somegoodplaces.features.places.usecase.GetPlaceDetailsUseCase
import somegoodplaces.features.places.usecase.GetPlaceDetailsUseCaseImpl
import somegoodplaces.features.places.usecase.ListPlacesUseCase
import somegoodplaces.features.places.usecase.ListPlacesUseCaseImpl
import somegoodplaces.libraries.network.ApiClientBuilder


@Module
@InstallIn(ActivityComponent::class)
abstract class PlacesBindsModule {
    @Binds
    internal abstract fun bindPlacesRepository(repo: PlacesOnlineRepository): PlacesRepository

    @Binds
    internal abstract fun bindListPlaceUseCase(useCase: ListPlacesUseCaseImpl): ListPlacesUseCase

    @Binds
    internal abstract fun bindGetPlaceDetailsUseCase(useCase: GetPlaceDetailsUseCaseImpl)
            : GetPlaceDetailsUseCase
}

@Module
@InstallIn(ActivityComponent::class)
class PlacesProvidesModule {
    @Provides
    internal fun providesPlacesApi() = ApiClientBuilder.createApi(PlacesApi::class.java)
}