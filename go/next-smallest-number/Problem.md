# Problem

Given a positive sorted array:

```
a = [ 3, 4, 6, 9, 10, 12, 14, 15, 17, 19, 21 ];
```

Define a function `f(a, x)` that `returns x, the next smallest number, or -1 for errors`.

i.e.

```
f(a, 12) = 12
f(a, 13) = 12
```

## Test cases

```
f(a, 12) = 12    // number found
f(a, 13) = 12    // smaller number found
f(a, 2) = -1     // out of bounds too small
f(a, 22) = 21    // out of bounds too large
f(a, 3) = 3      // exact left boundary
f(a, 21) = 21    // exact right boundary
f([], x) = -1    // empty array
f(null, x) = -1  // invalid input
```
