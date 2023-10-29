import java.io.File

fun main(args: Array<String>) {
    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    val path = try {
        args[0]
    } catch (e: Exception) {
        e.printStackTrace()
        println("No args found, using current directory.")
        System.getProperty("user.dir")
    }
    val dir = File(path)
    println(dir.path)
    dir.walk().forEach {
        println(it)
        if (!it.isDirectory) {
            try {
                it.copyTo(File("${dir.path}/${it.name}"))
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}