package kr.co.bullets.borutoapp.presentation.screens.home

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kr.co.bullets.borutoapp.domain.use_cases.UseCases
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    useCases: UseCases
): ViewModel() {
    val getAllHeroes = useCases.getAllHeroesUseCase()
}