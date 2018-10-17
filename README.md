# Assignment-1-Solution
## Programming Methodology II
### Gradeigh Clark

Solutions to Assignment 1 for Programming Methdology I, 2018.

# Problem 1 - Arbitrary Queue Linked List
Implement a double ended queue (effectively, a Deque) that allows for arbitrary insertion at either the head or tail. 
The data structure needs to be supported by a linked list and have a Traverse(int index) function as a substitute for returning an Iterator.

# Problem 2 - Arbitrary Queue Dynamic Capacity Array
Implement the same data structure above, this time using an array as the storage method. The challenge here is correctly handling the modulo operations for the array.

# Problem 3 - Sorting
Implement a Stack data structure that is backed by a linked list and accepts integers. Program insertion sort on it and show the swaps.
Solution is quickly obtained by using the ArbitraryQueue data structure and writing one or two helper functions to facilitate implementation.

# Problem 4 - Problem Solving
This part consists of 3 separate challenge problems.

## Problem 4 A - Palindromes
Write a function that reverses a string using a data structure from the course or this assignment. 
Solution is to insert a string character by character into a stack then pop it off.

## Problem 4 B - Perfect Sum Problem
Find all subsets of numbers inside a 2D array that sum to a given value, K.
One solution, as shown here, involves:
* Transforming the 2D array into a 1D array
* Without knowing how many possible values could sum together, use recursion over a loop of the array
* Store prior values on a stack and pop them off when you've finished with it
** Finishing occurs when a sum is found

## Problem 4 C - Kth Smallest Factors
Find the Kth smallest number with factors that are powers of 9, 15, and 7.
Optimal solution is to use 3 queues to store combinations of the most recent solution and output the minimum. 
Update these queues until you've reached the Kth value.

