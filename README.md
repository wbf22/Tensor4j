Welcome to the Tensor4j wiki!


This library is meant to provide a similar function to numpy in python, howbeit a little simpler and smaller. 

If you're looking for a lightweight java library for doing multidimensional math, this library is for you!


# Getting Started
Maven dependency:
```
coming soon
```

or in maven central https://mvnrepository.com/artifact/org.tensor4j/comingSoon



Alternatively clone the repo and run `mvn clean install` to build the jar file.
(How to install maven https://www.baeldung.com/install-maven-on-windows-linux-mac)

# Usage
Here's a list of provided methods:
- get
- set
- shape
- slice
- append
- multiply
- matmul
- dot
- reshape
- squeeze
- unsqueeze

 Translations from common methods from other libraries:
 - cat, use append
 - vstack, use append
 - transpose, use reshape

# Table of Contents

- [Creating a tensor](#creating-a-tensor)
- [Multiplication and Dot](#multiplication-and-Dot)
    - [Dot](#dot)
    - [Multiplication](#multiplication)
- [Section Two](#section-two)
    - [Subsection Three](#subsection-three)
    - [Subsection Four](#subsection-four)


## Creating a tensor
Create a random 2d tensor with
```java
Tensor2d myTensor = new Tensor2d(2, 3);
```
This creates a tensor that has this shape after calling the toString method
```
[0.9821, 0.7302]
[0.1656, 0.2469]
```

Create a random 3d tensor with 
```java
Tensor3d myTensor = new Tensor3d(3, 2, 1);
```

Calling toString
```
[
 [0.0939, 0.4056, 0.4940]
 [0.6548, 0.1786, 0.7047]
]
```

All other tensor types (Tensor1d, Tensor2d ...) work the same way.

You can also use this to create a tensor filled with the same number
```java
Tensor3d myTensor = new Tensor3d(2, 2, 3, 10.0);
```

This creates a tensor full of 10.0s of this shape
```
[
 [10.0000, 10.0000]
 [10.0000, 10.0000]
]
[
 [10.0000, 10.0000]
 [10.0000, 10.0000]
]
[
 [10.0000, 10.0000]
 [10.0000, 10.0000]
]
```

Use `Tensor#d.ones(#, #, #...)` and `Tensor#d.zeros(#, #, #...)` to quickly create tensors of all zeros or ones.


Tensor4j supports up to 16 dimensional tensors with constructors that follow the same pattern. Each dimenion can be of any length theoretically. So a matrix/tensor of dimensions 800 x 800 x 800 x 800 x 800 x 800 x 800 x 800 x 800 x 800 x 800 x 800 x 800 x 800 x 800 x 800 is possible. (crazy)

Since java is strongly typed we couldn't do much more than 16 dimensional arrays. Though they may still be a way that we didn't think of.



## Multiplication and Dot

### Dot
Here's an example
```java
Tensor1d a = new Tensor1d(3, .5);
Tensor1d b = new Tensor1d(3, 2.0);
a.set(0, 4.0);

Tensor1d = dot(a,b);
```
Here's what this does
```
 4     2
.5  X  2  =  10
.5     2
```

<br>
<br>

### Multiplication
#### Tensor2d
Here's an example of a multiplication of two 2d tensors
```java
Tensor2d a = new Tensor2d(2, 3, 4);
Tensor2d b = new Tensor2d(1, 2, 2);
a.set(0,0,.5);

Tensor2d c = Tensor2d.matmul(a,b);
```

Does the following matrix multiplication
```
.5  4         2            9
 4  4    X    2      =     16
 4  4                      16

```

#### Tensor3d

Here's an example of a multiplication of two 3d tensors
```java
Tensor3d a = new Tensor3d(3, 1, 2, .5);
Tensor3d b = new Tensor3d(2, 3, 2, 2.0);
a.set(0,0,0,4.0);

Tensor3d c = Tensor3d.matmul(a,b);
```
This performs the following operation
```
 4 .5 .5         2  2           10, 10
            X    2  2     =      3,  3
                 2  2

.5 .5 .5         2  2
                 2  2
                 2  2
```


#### Tensor4d

Here's another in 4d
```java
Tensor4d a = new Tensor4d(2, 3, 2, 2, 3);
Tensor4d b = new Tensor4d(1, 2, 2, 2, 2);
a.set(1,2,1,1,.2);

Tensor4d c = Tensor4d.matmul(a, b);
```
``` 
 3  3         2  2            12
 3  3         2  2            12
 3  3                         12
 
 3  3         2  2            12
 3  3         2  2            12
 3  3                         12
          X             = 
 
 3  3         2  2            12
 3  3         2  2            12
 3  3                         12
 
 3  3         2  2            12
 3  3         2  2            12
 3 .2                         6.4
```

Matrix multiplication after 2d basically just does multiplication of 2d matrices matching up sections of the higher dimensions. (This makes my head
hurt personally)

This generalizes to higher dimensions. It may be helpful to play with this 
and use the toString method to understand what's really going on.


<br>

#### Under the hood
Our algorithm uses a tiling approach to reduce the number of cache misses. This greatly improves the speed of matrix multiplications. There are other methods for multiplications of square matrices that we do not currently use,
but could be faster for those specific cases.














