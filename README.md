leetcode-java
========

My Java solutions for [LeetCode Online Judge](http://oj.leetcode.com/).

## Requirements
* Java >= 1.6
* Gradle >= 1.8.6 (1.8.6 is the only version I have tried)

## Generate an eclipse project

<pre>
$ gradle eclipse
</pre>

## Generate a file for a question

<pre>
$ gradle question "-Pq=Some Question"
</pre>

The above command will generate a source file called `src/main/java/some_question/SomeQuestion.java`, and you can write your solution in this file directly.

Unit tests are also embedded as inner classes of the main code. For an explanation of this design choice see Ben J. Christensen's [JUnit Tests as Inner Classes](http://benjchristensen.com/2011/10/23/junit-tests-as-inner-classes/).

## Run unit tests

If you write some unit tests, you can use the following command to run them.

<pre>
$ gradle test
</pre>

## Build Status
[![Build Status](https://travis-ci.org/zsxwing/leetcode-java.png?branch=master)](https://travis-ci.org/zsxwing/leetcode-java)