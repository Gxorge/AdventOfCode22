package uk.hotten.aoc22

import java.io.File
import java.net.URL
import java.nio.charset.StandardCharsets
import java.nio.file.Files
import kotlin.jvm.Throws

abstract class AOCDay(private val input: String) {

    @Throws(Exception::class)
    abstract fun part1()

    @Throws(Exception::class)
    abstract fun part2()

    fun getInput(): List<String> {
        return getFile(input)
    }

    private fun getFile(fileName: String): List<String> {
        val file = getFileFromResource(fileName) ?: return listOf()

        var lines: List<String> = listOf()
        try {
            lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8)
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return lines
    }

    private fun getFileFromResource(fileName: String): File? {
        val classLoader = javaClass.classLoader;
        val resource: URL = classLoader.getResource(fileName) ?: return null

        return File(resource.toURI())
    }
}