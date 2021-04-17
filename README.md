# Jetbrains Academy - Numeric Matrix Processor

My solutions for the Jetbrains Academy Problem: Numeric Matrix Processor

https://hyperskill.org/projects/87

The solution is build up step by step over several stages. 
Stage 1 is the first and simple one. The following stages 
build up on the previous stages and get more and more advanced.
There are six stages in total.

Because each stage is completely independent of the previous one,
IntelliJ might show some warnings about duplicated code between 
the stages.

## Stage 1/6

[click here to see description @ JetBrains Academy](https://hyperskill.org/projects/87/stages/480/implement)

We add two matrices.

just execute this:

    gradle -PmainClass=stage1.MainKt run --console=plain

input

    2 2     # these are the dimensions (2 X 2)
    1 2     # row 1
    2 1     # row 2
    2 2     # these are the dimensions (2 X 2)
    4 0     # row 1
    0 5     # row 2

output

    5 2
    2 6

## Stage 2/6

[click here to see description @ JetBrains Academy](https://hyperskill.org/projects/87/stages/481/implement)

Now we add multiplication of a matrix by a scalar.

just execute this:

    gradle -PmainClass=stage2.MainKt run --console=plain

input

    2 2     # these are the dimensions (2 X 2)
    2 5     # row 1
    3 7     # row 2
    11      # scalar

output

    22 55
    33 77

## Stage 3/6

[click here to see description @ JetBrains Academy](https://hyperskill.org/projects/87/stages/482/implement)

Now we can multiply a matrix with another matrix.
We also add a nice menu, so the user can choose his action.

just execute this:

    gradle -PmainClass=stage3.MainKt run --console=plain

    1. Add matrices
    2. Multiply matrix by a constant
    3. Multiply matrices
    0. Exit
    Your choice: 3
    Enter size of first matrix: 2 2
    1 2
    3 4
    Enter size of second matrix: 2 2
    5 2
    7 2
    The result is:
    19.0 6.0
    43.0 14.0

## Stage 4/6

[click here to see description @ JetBrains Academy](https://hyperskill.org/projects/87/stages/483/implement)

We add transposition of a matrix.

just execute this:

    gradle -PmainClass=stage4.MainKt run --console=plain

    1. Add matrices
    2. Multiply matrix by a constant
    3. Multiply matrices
    4. Transpose matrix
    0. Exit
    Your choice: 4
    1. Main diagonal
    2. Side diagonal
    3. Vertical line
    4. Horizontal line
    Your choice: 1
    Enter size of matrix: 2
    2
    Enter matrix:
    3 7
    1 5
    3.0 1.0
    7.0 5.0

## Stage 5/6

[click here to see description @ JetBrains Academy](https://hyperskill.org/projects/87/stages/484/implement)

Calculate the determinant of a matrix.

just execute this:

    gradle -PmainClass=stage5.MainKt run --console=plain

    1. Add matrices
    2. Multiply matrix by a constant
    3. Multiply matrices
    4. Transpose matrix
    5. Calculate a determinant
    0. Exit
    Your choice: 5
    Enter size of matrix: 3 3
    Enter matrix:
    2 3 4
    6 6 7
    11 2 0
    The result is:
    -13.0

## Stage 6/6

[click here to see description @ JetBrains Academy](https://hyperskill.org/projects/87/stages/485/implement)

Find the inverse of a matrix.

just execute this:

    gradle -PmainClass=stage6.MainKt run --console=plain 
    
    1. Add matrices
    2. Multiply matrix by a constant
    3. Multiply matrices
    4. Transpose matrix
    5. Calculate a determinant
    6. Inverse matrix
    0. Exit
    Your choice: 6
    Enter size of matrix: 3 3
    Enter matrix:
    3 2 1
    2 3 5
    1 1 7
    The result is:
    0.5517241379310345 -0.4482758620689655 0.2413793103448276
    -0.3103448275862069 0.6896551724137931 -0.4482758620689655
    -0.034482758620689655 -0.034482758620689655 0.1724137931034483