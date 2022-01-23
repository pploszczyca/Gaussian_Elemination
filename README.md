# Gaussian Elemination
Gaussian Elemination with trace theory for concurrency theory classes written in Scala.

## Technologies
* Scala

## Features
* Solve matrix with Gaussian Elemination with data from file,
* Make graph that represents actions concurrency.

## Input/Output file format
First line has number n that represents size of the matrix.

Then the next n-lines represents the matrix.

Last line has n-size column vector.

### Example 1
```
5
2.0 0.0 0.0 0.0 0.0
0.0 2.0 0.0 0.0 0.0
0.0 0.0 2.0 0.0 0.0
0.0 0.0 0.0 2.0 0.0
0.0 0.0 0.0 0.0 2.0
4.0 8.0 10.0 12.0 4.0
```

### Example 2
```
3
2 1 3
4 3 8
6 5 16
6 15 27
```