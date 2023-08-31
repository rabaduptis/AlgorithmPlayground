/**
 * developed according to https://en.wikipedia.org/wiki/Breadth-first_search
 */

fun main() {

    val vertex = NodeObject()
    val vertex1 = NodeObject()
    val vertex2 = NodeObject()
    val vertex3 = NodeObject()
    val vertex4 = NodeObject()
    val vertex5 = NodeObject()
    val vertex6 = NodeObject()

    vertex.setAsNodes(mutableListOf(vertex1, vertex5, vertex6))
    vertex1.setAsNodes(mutableListOf(vertex3, vertex4, vertex5))
    vertex4.setAsNodes(mutableListOf(vertex2, vertex6))
    vertex6.setAsNodes(mutableListOf(vertex))

    println("here is some tips for you: ${vertex5.data}")
    val value = readln().toInt()
    var queue: MutableList<NodeObject> = mutableListOf()

    queue.add(vertex)

    var step = 0
    var founded = false

    while (queue.isNotEmpty()) {
        step++
        val currentVertex = queue.removeAt(0)
        if (!currentVertex.visited) {
            if (currentVertex.data == value) {
                founded = true
                break
            } else {
                currentVertex.visited = true
                currentVertex.getAllNodes().forEach {
                    queue.add(it)
                }
            }
        }
    }

    println("$step taken")

    if (founded) println("it founded") else println("but it cannot found")

}

class NodeObject() {
    var data: Int = (0..10).random()
    private var nodes: MutableList<NodeObject> = mutableListOf()
    var visited = false

    fun setAsNodes(list: MutableList<NodeObject>) {
        nodes = list
    }

    fun getAllNodes(): MutableList<NodeObject> {
        return nodes
    }
}
