package somegoodplaces.features.places.ui.details

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.NavigationUI
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.places_layout_details_comments.*
import kotlinx.android.synthetic.main.places_layout_details_photos_and_about.*
import kotlinx.android.synthetic.main.places_layout_details_schedule_and_address.*
import kotlinx.android.synthetic.main.places_layout_details_toolbar.*
import somegoodplaces.features.places.R
import somegoodplaces.features.places.model.PlaceDetails
import somegoodplaces.features.places.ui.details.adapters.CommentsAdapter
import somegoodplaces.features.places.ui.details.adapters.PhotosAdapter
import somegoodplaces.libraries.common.ViewState
import somegoodplaces.libraries.common.extensions.toString
import somegoodplaces.libraries.ui_components.BaseFragment
import somegoodplaces.libraries.ui_components.extensions.loadImage

@AndroidEntryPoint
internal class PlaceDetailsFragment : BaseFragment(R.layout.places_fragment_details) {
    private val args: PlaceDetailsFragmentArgs by navArgs()
    private val viewModel: PlaceDetailsViewModel by viewModels()

    private val navController by lazy { findNavController() }

    private val photosAdapter by lazy { PhotosAdapter() }
    private val commentsAdapter by lazy { CommentsAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
        setupObservables()
        viewModel.init(args.placeId)
    }

    private fun setupView() {
        NavigationUI.setupWithNavController(toolbar, navController)
        imageToolbar.loadImage(args.imageUrl)
        rvPhotos.adapter = photosAdapter
        rvComments.adapter = commentsAdapter
    }

    private fun setupObservables() {
        viewModel.details.observe(this.viewLifecycleOwner) {
            var shouldHideLoading = true
            when (it) {
                is ViewState.Success -> updateView(it.data)
                is ViewState.Error -> showMessage(
                    it.errorMessage ?: getString(R.string.places_generic_error)
                ) { _, _ -> navController.navigateUp() }
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

    private fun updateView(details: PlaceDetails) {
        toolbar.title = details.name
        ratingBar.rating = details.review
        rating.text = details.review.toString(1)
        imageToolbar.loadImage(details.image)

        photosAdapter.submitList(details.photos)

        tvAbout.text = details.about
        tvSchedule.text = viewModel.formatSchedule(details.schedule).getValue(requireContext())
        tvPhone.text = details.phone
        tvAddress.text = details.address

        commentsAdapter.submitList(details.comments)
    }
}