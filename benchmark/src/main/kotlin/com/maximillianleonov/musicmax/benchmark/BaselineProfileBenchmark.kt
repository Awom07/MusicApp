
package com.maximillianleonov.musicmax.benchmark

import android.annotation.SuppressLint
import androidx.benchmark.macro.CompilationMode
import androidx.benchmark.macro.MacrobenchmarkScope
import androidx.benchmark.macro.StartupMode
import androidx.benchmark.macro.StartupTimingMetric
import androidx.benchmark.macro.junit4.MacrobenchmarkRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.maximillianleonov.musicmax.benchmark.util.PackageName
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class BaselineProfileBenchmark {
    @get:Rule
    val benchmarkRule = MacrobenchmarkRule()

    @SuppressLint("NewApi")
    @Test
    fun startupNoCompilation() = startup(CompilationMode.None())

    @SuppressLint("NewApi")
    @Test
    fun startupBaselineProfile() = startup(CompilationMode.Partial())

    private fun startup(compilationMode: CompilationMode) = benchmarkRule.measureRepeated(
        packageName = PackageName,
        metrics = listOf(StartupTimingMetric()),
        iterations = 10,
        startupMode = StartupMode.COLD,
        compilationMode = compilationMode,
        setupBlock = MacrobenchmarkScope::pressHome
    ) { startActivityAndWait() }
}
