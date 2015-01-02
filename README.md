# gfc-collection

A library that contains scala collection utility classes. Part of the gilt foundation classes.

## Contents and Example Usage

### com.gilt.gfc.collection.CircularBuffer

Simple non-thread-safe circular buffer implementation that supports adding a new item,
finding the oldest item, the newest item, or iterating from oldest to newest.

    val buffer = new CircularBuffer[Int](5)

    buffer.add(0)
    assert(buffer.oldest == 0)
    assert(buffer.newest == 0)
    assert(buffer.size == 1)

    (1 to 4).foreach(buffer.add(_))
    assert(buffer.oldest == 0)
    assert(buffer.newest == 4)
    assert(buffer.size == 5)

    buffer.add(5)
    assert(buffer.oldest == 1)
    assert(buffer.newest == 5)
    assert(buffer.size == 5)

### com.gilt.gfc.collection.TopN

Utility to select top N items from a collection.

    val numbers = scala.util.Random.shuffle(0 to 1000)
    assert(TopN(5, numbers) == Seq(0, 1, 2, 3, 4))
    assert(TopN(5, numbers)(scala.math.Ordering.Int.reverse) == Seq(1000, 999, 998, 997, 996))

## License
Copyright 2014 Gilt Groupe, Inc.

Licensed under the Apache License, Version 2.0: http://www.apache.org/licenses/LICENSE-2.0
