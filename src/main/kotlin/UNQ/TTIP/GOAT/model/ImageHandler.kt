package UNQ.TTIP.GOAT.model

import org.springframework.core.io.FileSystemResource
import org.springframework.stereotype.Repository
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import kotlin.io.path.absolutePathString
import kotlin.io.path.pathString

@Repository
class ImageHandler {
    var rESOURCES_DIR = Paths.get("").toAbsolutePath().toString()

    var path : String = "C:/ProgramData/MySQL/MySQL Server 8.0/Data/db_goat/BBDD - IMG/"

    @Throws(Exception::class)
    fun save(content: ByteArray?, imageName: String): String {
        val newFile: Path = Paths.get(path +  imageName)
        Files.createDirectories(newFile.getParent())
        Files.write(newFile, content)
        //return newFile.toAbsolutePath().toString()
        return path +  imageName
    }

    fun findInFileSystem(location: String?): ByteArray {
        return try {
            FileSystemResource(Paths.get(path + location)).inputStream.readBytes()
        } catch (e: Exception) {
            // Handle access or file not found problems.
            throw RuntimeException()
        }
    }
}