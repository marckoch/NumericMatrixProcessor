package stage4

import java.util.*

val scanner = Scanner(System.`in`)

fun main() {
    do {
        printMenu()
        val choice = getChoice("Your choice: ")

        when (choice) {
            1 -> add()
            2 -> scalarMultiplication()
            3 -> multiply()
            4 -> transpose()
        }
    } while (choice in 1..4)
}


fun transpose() {
    println("1. Main diagonal")
    println("2. Side diagonal")
    println("3. Vertical line")
    println("4. Horizontal line")

    val choice = getChoice("Your choice: ")

    val (r, c) = requestDimensions("Enter size of matrix: ")
    val m = readMatrix(r, c)

    val transformation: (Int, Int) -> Pair<Int, Int> =
        when (choice) {
            1 -> { x, y -> Pair(y, x) } // mainDiagonal
            2 -> { x, y -> Pair(m.rowCount - y - 1, m.rowCount - x - 1) } // sideDiagonal
            3 -> { x, y -> Pair(x, m.rowCount - y - 1) } // verticalLine
            4 -> { x, y -> Pair(m.rowCount - x - 1, y) } // horizontalLine
            else -> { x, y -> Pair(x, y) } // do nothing
        }

    println(m.transpose(transformation))
}

fun add() {
    val (r1, c1) = requestDimensions("Enter size of first matrix: ")
    val m1 = readMatrix(r1, c1)

    val (r2, c2) = requestDimensions("Enter size of second matrix: ")
    val m2 = readMatrix(r2, c2)

    println("The result is:")

    println(m1 + m2)
}

fun scalarMultiplication() {
    val (r, c) = requestDimensions("Enter size of matrix: ")
    val m = readMatrix(r, c)

    print("Enter constant: ")
    val scalar = scanner.nextDouble()

    println("The result is:")

    println(m * scalar)
}

fun multiply() {
    val (r1, c1) = requestDimensions("Enter size of first matrix: ")
    val m1 = readMatrix(r1, c1)

    val (r2, c2) = requestDimensions("Enter size of second matrix: ")
    val m2 = readMatrix(r2, c2)

    println("The result is:")

    println(m1 * m2)
}

class Matrix(private var state: Array<Array<Double>>) {
    val rowCount: Int
        get() {
            return state.size
        }

    val colCount: Int
        get() {
            return state[0].size
        }

    fun getRow(r: Int): Array<Double> {
        return state[r]
    }

    fun getCol(c: Int): Array<Double> {
        return Array(state.size) { i -> state[i][c] }
    }

    operator fun times(n: Double): Matrix {
        val newState = Array(rowCount) { Array(colCount) { 0.0 } }

        for (r in 0 until rowCount) {
            for (c in 0 until colCount) {
                newState[r][c] = state[r][c] * n
            }
        }

        return Matrix(newState)
    }

    operator fun plus(other: Matrix): Matrix {
        if (rowCount != other.rowCount ||
            colCount != other.colCount
        ) {
            throw IllegalArgumentException("Can't add matrices: Dimensions don't match!")
        }

        val newState = Array(rowCount) { Array(colCount) { 0.0 } }

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

    operator fun times(other: Matrix): Matrix {
        if (colCount != other.rowCount) {
            throw IllegalArgumentException("Can't multiply matrices: Dimensions don't match!")
        }

        val newState = Array(rowCount) { Array(other.colCount) { 0.0 } }

        for (r in 0 until rowCount) {
            for (c in 0 until other.colCount) {
                newState[r][c] = dotProduct(this.getRow(r), other.getCol(c))
            }
        }

        return Matrix(newState)
    }

    private fun dotProduct(a1: Array<Double>, a2: Array<Double>): Double {
        if (a1.size != a2.size) {
            throw IllegalArgumentException("Can't multiply dotproduct: Dimensions don't match! $a1 X $a2")
        }

        return a1.zip(a2) { a, b -> a * b }.sum()
    }

    fun transpose(transformation: (Int, Int) -> Pair<Int, Int>): Matrix {
        val newState = Array(rowCount) { Array(colCount) { 0.0 } }

        for (r in 0 until rowCount) {
            for (c in 0 until colCount) {
                val pair = transformation(r, c)
                newState[r][c] = state[pair.first][pair.second]
            }
        }

        return Matrix(newState)
    }
}

fun requestDimensions(msg: String): Pair<Int, Int> {
    print(msg)
    return Pair(scanner.nextInt(), scanner.nextInt())
}

fun getChoice(msg: String): Int {
    print(msg)
    return scanner.nextInt()
}

fun printMenu() {
    println("1. Add matrices")
    println("2. Multiply matrix by a constant")
    println("3. Multiply matrices")
    println("4. Transpose matrix")
    println("0. Exit")
}

fun readMatrix(row: Int, col: Int): Matrix {
    val m = Array(row) { Array(col) { 0.0 } }
    println("Enter matrix:")
    for (r in 0 until row) {
        for (c in 0 until col) {
            m[r][c] = scanner.nextDouble()
        }
    }
    return Matrix(m)
}