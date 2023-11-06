import java.io.File

fun main(args: Array<String>) {
    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    val sourcePath = try {
        args[0]
    } catch (e: Exception) {
        e.printStackTrace()
        println("No args found.")
        return
    }

    val destinationPath = try {
        args[1]
    } catch (e: Exception) {
        e.printStackTrace()
        println("No destination found.")
        return
    }

    val sourceDir = File(sourcePath)
    val destinationDir = File(destinationPath)
    println(sourceDir.path)
    sourceDir.walk().forEach {
        println(it)
        if (!it.isDirectory && it.extension != "jar" && it.extension != "sh" && it.extension != "nomedia") {
            try {
                it.copyTo(File("${destinationDir.path}/${it.name}"))
                it.delete()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}