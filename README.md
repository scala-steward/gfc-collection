# gfc-collection [![Maven Central](https://maven-badges.herokuapp.com/maven-central/org.gfccollective/gfc-collection_2.12/badge.svg?style=plastic)](https://maven-badges.herokuapp.com/maven-central/org.gfccollective/gfc-collection_2.12) [![Build Status](https://github.com/gfc-collective/gfc-collection/workflows/Scala%20CI/badge.svg)](https://github.com/gfc-collective/gfc-collection/actions) [![Coverage Status](https://coveralls.io/repos/gfc-collective/gfc-collection/badge.svg?branch=master&service=github)](https://coveralls.io/github/gfc-collective/gfc-collection?branch=master)

A library that contains scala collection utility classes. 
A fork and new home of the now unmaintained Gilt Foundation Classes (`com.gilt.gfc`), now called the [GFC Collective](https://github.com/gfc-collective), maintained by some of the original authors.

## Getting gfc-collection

The latest version is 1.0.0, released on 21/Jan/2020 and cross-built against Scala 2.12.x and 2.13.x.

If you're using SBT, add the following line to your build file:

```scala
libraryDependencies += "org.gfccollective" %% "gfc-collection" % "1.0.0"
```

For Maven and other build tools, you can visit [search.maven.org](http://search.maven.org/#search%7Cga%7C1%7Corg.gfccollective).
(This search will also list other available libraries from the GFC Collective.)

## Contents and Example Usage

### org.gfccollective.collection.CircularBuffer

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

### org.gfccollective.collection.TopN

Utility to select top N items from a collection.

    val numbers = scala.util.Random.shuffle(0 to 1000)
    assert(TopN(5, numbers) == Seq(0, 1, 2, 3, 4))
    assert(TopN(5, numbers)(scala.math.Ordering.Int.reverse) == Seq(1000, 999, 998, 997, 996))

## License

Licensed under the Apache License, Version 2.0: http://www.apache.org/licenses/LICENSE-2.0
