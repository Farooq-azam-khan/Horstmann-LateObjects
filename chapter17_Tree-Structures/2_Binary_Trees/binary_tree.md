# Binary Tree
- have at most 2 children

## Decision Tree
- each non-leaf node has a question
- binary because of the two children
  - if it is a decision then 2 children and if it is a conclusion then no children

## Huffman Tree
- Gives the shortest code for the most frequent numbers
- the leaves contain the letters and the roots are either `0` or `1`

## Arithmetic Expression
- Binary trees can also be used to evaluate arithmetic expressions. The leaves contain numbers while the interior nodes contain operators.

## Balanced Trees
- With binary trees, to store data, we need __balanced__ trees. These are trees in which all paths from the root to one of the leaf nodes have approximately the same length.
- __Height__ of a tree is the number of nodes in the longest path from the root to the leaf.
  - Binary tree of height, _h_ can have `2^h-1` nodes.
  - inversely, `h = log_2(n+1)`. 
- A balanced tree can hold more nodes than an unbalanced tree.
- The height of a tree is important because many tree operations proceed along a path from the root to a leaf, and their efficiency is better expressed by the height of the tree than by the number of elemetns in the tree.
