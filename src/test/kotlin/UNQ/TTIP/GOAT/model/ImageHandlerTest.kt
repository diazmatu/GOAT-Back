package UNQ.TTIP.GOAT.model

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.assertDoesNotThrow
import org.springframework.core.io.FileSystemResource
import java.nio.file.Paths

internal class ImageHandlerTest {

    var imageHandler : ImageHandler = ImageHandler()
    var path : String = "C:/ProgramData/MySQL/MySQL Server 8.0/Data/db_goat/BBDD - IMG/"

    @BeforeEach
    fun setUp() {
    }

    @Test
    fun save() {
        var imagePath = imageHandler.save(byteArrayOf(0x2E, 0x38), "Players/-")
        var absolutePath = Paths.get(path + "Players/-").toAbsolutePath().toString()

        assertEquals(absolutePath, imagePath)
    }

    @Test
    fun findInFileSystem() {
        var img = imageHandler.findInFileSystem("Teams/1.jpg")
        var absolutePath = Paths.get(path + "Teams/1.jpg")

        assertEquals(path + "Teams/1.jpg", img?.getPath())
        //assertEquals(path + "Teams/1.jpg", img?.getInputStream().readBytes())

    }
}