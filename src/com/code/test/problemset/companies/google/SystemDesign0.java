package com.code.test.problemset.companies.google;

public class SystemDesign0 {
    /*
    Design a fn the generates numbers randomly based on probability of occurrence. That function should be fast

    for example
    obj 1 happens 0.1 of the time
    obj 2 happens 0.3 of the time
    obj 3 happens 0.6 of the time
    ..


    My first approach is to create array duplicates elements on it based on its probability
    and then return random number based on index
    [obj1, obj1, .., obj2, obj2, obj2, ...]


    Second approach to make it space efficient.
    Store ranges instead of actual values. This also will cover cases like 0.33333
    // search here could happen using binary search
    [1, 10] obj1
    [11, 43] obj2
    ..

    generate random number and check in which range it lies and return that object.


    Third Solution I came with is those ranges are actually probabilities.
    first generate random number that select probability. then under this prob bucket there all objects
        that has same probability you can generate another random number to select on random from them

    0.1  - [obj1]
    0.2 - [obj2, obj7 , ..etc]
    0.6
    ....


================

Follow up
we have queries are stored in n disk (no in memory)
and each machine/disk has sublist of queries happened in last 24 with occurance
M1
    "facebook" - 1000000
    "how to repair my lawnmower" - 300
M2
    "blabla" - 12332000
    "xoxoxox" - 222


How to return random query from those on normal distribution.

My Solution is to have a webproxy in front of those machines and applying same approaches in mentioned earlier in first problem

    */


}
