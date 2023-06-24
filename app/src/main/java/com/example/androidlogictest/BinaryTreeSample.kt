package com.example.androidlogictest

import androidx.compose.ui.unit.max
import java.util.LinkedList
import java.util.Queue

class Node(var data: Int) {
    var left: Node? = null
    var right: Node? = null
}

fun main() {

    println("                       0                         ")
    println("           1           ,       2                 ")
    println("       3     ,  4            5    ,   6          ")
    println("      7,8     9,                     10,11       ")

    val tree = createTree()

    println("___Pre Order:")
    preorder(tree)

    println("\n__post Order:")
    postOrder(tree)

    println("\n__In Order:")
    inOrder(tree)

    println("\n__Height of Tree:")
    println(heightOfTree(tree))

    println("__Print Level Order:")
    levelOrderTraversal(tree)

    println("__Print Level Order with Level :")
    levelOrderTraversalWithLevel(tree)
}

fun heightOfTree(root: Node?): Int {
    if (root == null) return 0

    if (root.left == null && root.right == null) return 0

    return Math.max(heightOfTree(root.left), heightOfTree(root.right)) + 1
}

//Root, Left, Right
fun preorder(root: Node?) {
    if (root == null) return
    print(root.data.toString() + " ")
    preorder(root.left)
    preorder(root.right)
}

//Left,Root, Right
fun inOrder(root: Node?) {
    if (root == null) return
    inOrder(root.left)
    print(root.data.toString() + " ")
    inOrder(root.right)
}

// Left, Right,Root
fun postOrder(root: Node?) {
    if (root == null) return
    postOrder(root.left)
    postOrder(root.right)
    print(root.data.toString() + " ")
}

fun createTree(): Node {

    val tree = Node(0)

    tree.left = Node(1)

    tree.right = Node(2)

    tree.left!!.left = Node(3)

    tree.left!!.right = Node(4)

    tree.right!!.left = Node(5)
    tree.right!!.right = Node(6)

    tree.left!!.left?.left = Node(7)
    tree.left!!.left?.right = Node(8)

    tree.left!!.right?.left = Node(9)

    tree.right!!.right?.left = Node(10)

    tree.right!!.right?.right = Node(11)

    return tree

}

fun levelOrderTraversal(root: Node?) {
    val queue: Queue<Node?> = LinkedList()
    queue.add(root)
    while (queue.isNotEmpty()) {
        val tempNode = queue.poll()
        print(tempNode?.data.toString() + " ")

        if (tempNode?.left != null) {
            queue.add(tempNode.left)
        }

        if (tempNode?.right != null) {
            queue.add(tempNode.right)
        }
    }
}


fun levelOrderTraversalWithLevel(root: Node?) {
    val queue: Queue<Node?> = LinkedList()
    queue.add(root)
    queue.add(null)
    while (queue.isNotEmpty()) {
        val tempNode = queue.poll()
        if (tempNode == null) {
            if (queue.isEmpty()) return
            queue.add(null)
            println()
            continue
        }
        print(tempNode.data.toString() + " ")
        if (tempNode.left != null) {
            queue.add(tempNode.left)
        }

        if (tempNode.right != null) {
            queue.add(tempNode.right)
        }
    }
}