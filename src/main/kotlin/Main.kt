import kweb.Kweb
import kweb.h1

fun main() {
    Kweb(port = 16097) {
        doc.body {
            h1().text("Hello World!")
        }
    }
}
