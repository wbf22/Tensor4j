Welcome to the Tensor4j wiki!


This library is meant to provide a similar function to numpy in python, howbeit a little simpler and smaller. 

If you're looking for a lightweight java library for doing multidimensional math, this library if for you!


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

### Creating a tensor
Create a random 3d tensor with 
```
Tensor3d myTensor = new Tensor3d(3, 1, 2);
```

This creates a tensor that has this shape after calling the toString method
```
[
 [0.0939, 0.4056, 0.4940]
 [0.6548, 0.1786, 0.7047]
]
```

All other tensor types (Tensor1d, Tensor2d ...) work the same way.

You can also use this to create a tensor filled with the same number
```
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


Tensor4j supports up to 16 dimensional tensors of any length theoretically. So a matrix/tensor of dimensions 800 x 800 x 800 x 800 x 800 x 800 x 800 x 800 x 800 x 800 x 800 x 800 x 800 x 800 x 800 x 800 is possible. (crazy)

Since java is strongly typed we couldn't do much more than 16 dimensional arrays. Though they may still be a way that we didn't think of.



### Multiplication and Dot
Here's an example of a multiplication of two 3d tensors
```
Tensor3d a = new Tensor3d(3, 1, 2, .5);
Tensor3d b = new Tensor3d(2, 3, 2, 2.0);
a.set(0,0,0,4.0);

Tensor3d c = matmul(a,b);
```
This performs the following operation
<pre>
 4 .5 .5    x    2  2           10, 10
                 2  2     =      3,  3
                 2  2

.5 .5 .5         2  2
                 2  2
                 2  2
</pre>
This generalizes to higher dimensions.









