/*
 * Copyright (c) 2019 Bevilacqua Joey
 *
 * Licensed under the GNU GPLv3 license
 *
 * The text of the license can be found in the LICENSE file
 * or at https://www.gnu.org/licenses/gpl.txt
 */
package it.diab.glucose.util.extensions

import org.junit.Assert.assertEquals
import org.junit.Test

class ArrayExtTest {

    @Test
    fun forEachUntilTrue() {
        val sb = StringBuilder()

        val test = arrayOf({
            sb.append("a")
            false
        }, {
            sb.append("b")
            false
        }, {
            sb.append("c")
            true
        }, {
            sb.append("d")
            false
        })

        test.forEachUntilTrueIndexed { _, func -> func() }

        assertEquals("abc", sb.toString())
    }
}
