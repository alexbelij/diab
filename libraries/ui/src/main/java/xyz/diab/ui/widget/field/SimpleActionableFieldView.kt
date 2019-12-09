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

package xyz.diab.ui.widget.field

import android.content.Context
import android.util.AttributeSet
import androidx.annotation.AttrRes
import com.google.android.material.R

class SimpleActionableFieldView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    @AttrRes defStyleAttr: Int = R.attr.editTextStyle
) : ActionableFieldView(context, attrs, defStyleAttr) {
    private var listener: OnSimpleSelectedListener? = null

    fun setOnActionListener(listener: OnSimpleSelectedListener) {
        this.listener = listener
    }

    override fun onClick() {
        listener?.invoke()
    }
}
