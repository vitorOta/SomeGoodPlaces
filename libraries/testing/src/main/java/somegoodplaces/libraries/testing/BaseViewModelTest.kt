package somegoodplaces.libraries.testing

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Rule


abstract class BaseViewModelTest {
    @get:Rule
    val coroutineTestRule = CoroutineTestRule()

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()
}