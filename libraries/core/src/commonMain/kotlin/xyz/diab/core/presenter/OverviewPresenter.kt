/*
 * Copyright (c) 2020 Bevilacqua Joey
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package xyz.diab.core.presenter

import kotlinx.coroutines.flow.Flow
import xyz.diab.core.model.Glucose
import xyz.diab.core.usecase.glucose.DeleteGlucoseUseCaseProducer
import xyz.diab.core.usecase.glucose.GetFlowGlucoseUseCase
import xyz.diab.core.usecase.glucose.GetGlucoseUseCaseProducer
import xyz.diab.core.usecase.glucose.PutGlucoseUseCaseProducer

class OverviewPresenter internal constructor(
    private val flowUseCase: GetFlowGlucoseUseCase,
    private val putUseCaseProducer: PutGlucoseUseCaseProducer,
    private val getUseCaseProducer: GetGlucoseUseCaseProducer,
    private val deleteUseCaseProducer: DeleteGlucoseUseCaseProducer
) {

    val glucoseFlow: Flow<List<Glucose>> by lazy {
        flowUseCase()
    }

    suspend fun deleteItemAtIndex(id: Long): Glucose {
        val item = getUseCaseProducer(id)()
        deleteUseCaseProducer(item)()
        return item
    }

    suspend fun put(glucose: Glucose) {
        putUseCaseProducer(glucose)()
    }
}
