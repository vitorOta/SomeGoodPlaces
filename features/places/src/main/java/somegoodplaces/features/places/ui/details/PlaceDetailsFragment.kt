package somegoodplaces.features.places.ui.details

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.places_fragment_details.*
import somegoodplaces.features.places.R
import somegoodplaces.features.places.model.PlaceDetails
import somegoodplaces.libraries.common.ViewState
import somegoodplaces.libraries.ui_components.BaseFragment
import somegoodplaces.libraries.ui_components.extensions.loadImage

@AndroidEntryPoint
class PlaceDetailsFragment : BaseFragment(R.layout.places_fragment_details) {
    private val args: PlaceDetailsFragmentArgs by navArgs()
    private val viewModel: PlaceDetailsViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservables()
        viewModel.init(args.placeId)
    }

    private fun setupObservables() {
        viewModel.details.observe(this.viewLifecycleOwner) {
            var shouldHideLoading = true
            when (it) {
                is ViewState.Success -> updateView(it.data)
                is ViewState.Error -> showMessage(
                    it.errorMessage ?: getString(R.string.places_generic_error)
                )
                is ViewState.Loading -> shouldHideLoading = false
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

    private fun updateView(placeDetails: PlaceDetails) {
        toolbar.title = placeDetails.name
        imageToolbar.loadImage(placeDetails.image)
    }
}