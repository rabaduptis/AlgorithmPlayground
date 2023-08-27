import kotlin.random.Random

/**
 * developed according to https://en.wikipedia.org/wiki/Breadth-first_search
 */

fun main() {
    var nodeObject = NodeObject()
    val queue: ArrayList<NodeObject> = ArrayList()
    val value: Int = 3

    queue.forEach { item ->
        if (item.property == value) {
            println("founded  $value at ${item.property}")
        } else {
            item.nodes.forEach { nodes -> queue.add(nodes) }
        }
    }
}

class NodeObject() {
    val property: Int = Random.nextInt()
    lateinit var nodes: ArrayList<NodeObject>
}


