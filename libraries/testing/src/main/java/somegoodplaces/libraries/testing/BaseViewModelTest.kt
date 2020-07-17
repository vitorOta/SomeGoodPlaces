package somegoodplaces.libraries.testing

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import io.mockk.mockk
import org.junit.Rule


abstract class BaseViewModelTest {
    @get:Rule
    val coroutineTestRule = CoroutineTestRule()

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    fun <T> mockObserver() = mockk<Observer<T>>(relaxed = true)
}