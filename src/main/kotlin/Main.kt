import kweb.*
import kweb.InputType.text
import kweb.state.KVar
import kweb.state.render

fun main() {
    val list = KVar(listOf("one", "two", "three"))

    Kweb(port = 16097) {
        doc.body {
            h1().text("Hello World!")

            val name = KVar("John")
            li().text(name)
//            p().text("What is your name?")
//            val input = input(type = text)
//            val nameKVar = KVar("Peter Pan")
//            input.value = nameKVar
//            p().text(nameKVar.map { n -> "Hi $n!" })

            render(list) { rList ->
                ul {
                    for (item in rList) {
                        li().text(item)
                    }
                }
            }
        }
    }
    renderLoop(list)
}

private fun renderLoop(list: KVar<List<String>>) {
    var flipped = true
    while (true) {
        flipped = !flipped
        renderLoop(list, flipped)
    }
}

private fun renderLoop(list: KVar<List<String>>, flipped: Boolean) {
    Thread.sleep(100)
    if (flipped) {
        list.value = listOf("four", "five", "six")
    } else {
        list.value = listOf("one", "two", "three")
    }
}
