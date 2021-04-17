package stage1

import java.util.*

val scanner = Scanner(System.`in`)

fun main() {
    val m1 = readMatrix()
    val m2 = readMatrix()

    try {
        val result: Matrix = m1 + m2

        println(result)
    } catch (e: java.lang.IllegalArgumentException) {
        println("ERROR")
    }
}

class Matrix(private var state: Array<Array<Int>>) {
    val rowCount: Int
        get() {
            return state.size
        }

    val colCount: Int
        get() {
            return state[0].size
        }

    operator fun plus(other: Matrix): Matrix {
        if (rowCount != other.rowCount ||
            colCount != other.colCount) {
            throw IllegalArgumentException("Can't add matrices: Dimensions don't match!")
        }

        val newState = Array(rowCount) { Array(colCount) { 0 } }

        for (r in 0 until rowCount) {
            for (c in 0 until colCount) {
                newState[r][c] = state[r][c] + other.state[r][c]
            }
        }

        return Matrix(newState)
    }

    override fun toString(): String {
        var s = ""
        for (row in state) {
            s += row.joinToString(" ", postfix = "\n")
        }
        return s
    }
}

fun readMatrix(): Matrix {
    val row = scanner.nextInt()
    val col = scanner.nextInt()

    val m = Array(row) { Array(col) { 0 } }
    for (r in 0 until row) {
        for (c in 0 until col) {
            m[r][c] = scanner.nextInt()
        }
    }
    return Matrix(m)
}