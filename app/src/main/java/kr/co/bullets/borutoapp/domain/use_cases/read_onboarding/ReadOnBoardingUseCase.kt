package kr.co.bullets.borutoapp.domain.use_cases.read_onboarding

import kotlinx.coroutines.flow.Flow
import kr.co.bullets.borutoapp.data.repository.Repository

class ReadOnBoardingUseCase(
    private val repository: Repository
) {
    operator fun invoke(): Flow<Boolean> {
        return repository.readOnBoardingState()
    }
}