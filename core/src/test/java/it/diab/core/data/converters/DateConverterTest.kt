/*
 * Copyright (c) 2019 Bevilacqua Joey
 *
 * Licensed under the GNU GPLv3 license
 *
 * The text of the license can be found in the LICENSE file
 * or at https://www.gnu.org/licenses/gpl.txt
 */
package it.diab.core.data.converters

import org.junit.Assert.assertEquals
import org.junit.Test
import java.util.Date

class DateConverterTest {
    private val converter = DateConverter()

    @Test
    fun convertToDate() {
        val now = System.currentTimeMillis()
        assertEquals(now, converter.toDate(now).time)

        assertEquals(0, converter.toDate(null).time)
    }

    @Test
    fun convertToLong() {
        val now = Date()
        assertEquals(now.time, converter.toLong(now))

        assertEquals(0, converter.toLong(null))
    }
}