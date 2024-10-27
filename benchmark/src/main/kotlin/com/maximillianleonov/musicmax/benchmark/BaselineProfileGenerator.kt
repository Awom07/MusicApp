

package com.maximillianleonov.musicmax.benchmark

import android.annotation.SuppressLint
import androidx.benchmark.macro.junit4.BaselineProfileRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.maximillianleonov.musicmax.benchmark.util.PackageName
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class BaselineProfileGenerator {
    @SuppressLint("NewApi")
    @get:Rule
    val baselineProfileRule = BaselineProfileRule()

    @SuppressLint("NewApi")
    @Test
    fun generate() = baselineProfileRule.collect(packageName = PackageName) {
        pressHome()
        startActivityAndWait()
    }
}
