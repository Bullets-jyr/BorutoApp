package kr.co.bullets.borutoapp.domain.use_cases

import kr.co.bullets.borutoapp.domain.use_cases.read_onboarding.ReadOnBoardingUseCase
import kr.co.bullets.borutoapp.domain.use_cases.save_onboarding.SaveOnBoardingUseCase

data class UseCases(
    val saveOnBoardingUseCase: SaveOnBoardingUseCase,
    val readOnBoardingUseCase: ReadOnBoardingUseCase
)
