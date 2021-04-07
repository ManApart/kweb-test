import kweb.*
import kweb.InputType.text
import kweb.state.KVar
import kweb.state.render

fun main() {
    val list = KVar(listOf("one", "two", "three"))

    Kweb(port = 16097) {
        doc.body {
            h1().text("Hello World!")

            val label = h1()
            label.text("Click Me")
            label.on.click {
                label.text("Clicked!")
            }

            val clickMe = input(type = InputType.text)
            val nameKVar = KVar("Peter Pan")
            clickMe.value = nameKVar
            p().text(nameKVar.map { n -> "Hi $n!" })

            render(list) { rList ->
                ul {
                    for (item in rList) {
                        li().text(item)
                    }
                }
            }
        }
    }
//    renderLoop(list)
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
