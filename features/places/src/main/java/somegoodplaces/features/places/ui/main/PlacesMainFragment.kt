package somegoodplaces.features.places.ui.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.places_fragment_main.*
import somegoodplaces.features.places.R
import somegoodplaces.features.places.model.Place
import somegoodplaces.libraries.common.RequestState
import somegoodplaces.libraries.ui_components.BaseFragment

@AndroidEntryPoint
class PlacesMainFragment : BaseFragment(R.layout.places_fragment_main) {

    private val viewModel by viewModels<PlacesMainViewModel>()

    private val adapter: PlacesAdapter by lazy {
        PlacesAdapter { navigateToDetails(it) }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
        setupObservables()
    }

    private fun setupView() {
        recyclerView.adapter = adapter
    }

    private fun setupObservables() {
        viewModel.places.observe(this.viewLifecycleOwner) {
            var shouldHideLoading = true
            when (it) {
                is RequestState.Success -> adapter.submitList(it.data)
                is RequestState.Error -> showMessage(
                    it.errorMessage ?: getString(R.string.places_generic_error)
                )
                is RequestState.Loading -> shouldHideLoading = false
            }

            if (shouldHideLoading) {
                loadingDialog.dismiss()
            } else {
                if (!loadingDialog.isShowing) {
                    loadingDialog.show()
                }
            }
        }
    }

    private fun navigateToDetails(place: Place) {
        val directions =
            PlacesMainFragmentDirections.placesNavActionMainToDetails(place.id, place.image)
        findNavController().navigate(directions)
    }
}