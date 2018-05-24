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
- The height of a tree is important because many tree operations proceed along a path from the root to a leaf, and their efficiency is better expressed by the height of the tree than by the number of elements in the tree.

## Binary Search Tree
- A __binary search tree__ is a binary tree in which _all nodes_ fulfill the following properties:
  - data values of all decedents to the left are less than the data values store in the node, and al descendants to the right have greater data values.
    - the binary search tree should have type `Comparable` not `Object`
### Insertion
- if non-null node reference is encountered then look at its data value.
  - if the data value of the node is larger than the one you want to insert, continue the process with the left(right?) child.
  - if the node's data value is smaller than the one you want to insert, continue the process with the right(left?) child.
- if you encounter a null node reference, replace it with the new node

### Removal
- find node to be removed, do it by:
  - compare data value to root,
    - if smaller then go left
    - else if larger then go right
- if found node
  - if node has no children then set node to null
  - else if node has 1 child then point the parent node to the child node of the node that needs to be removed
  - else if node has 2 children then
    - replace its data with the next larger value in the tree
    - to locate the next larger value, go to the right subtree and find its smallest data value (get the leaf node). Remove that node and store it in the place where the node was to be removed

### Efficiency of Operations
- the operations are proportional to the height of the tree not the number of nodes.
- height of an unbalanced tree is `n`
- height of a balanced tree is `log(n)`
+-----------------------------------------------------+
| operation         | Balanced BST  | Unbalanced BST  |
| finding element   | `O(log(n))`   | `O(n)`          |
| adding element    | `O(log(n))`   | `O(n)`          |
| removing element  | `O(log(n))`   | `O(n)`          |
+-----------------------------------------------------+
