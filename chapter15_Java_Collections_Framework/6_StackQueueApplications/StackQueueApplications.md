# Stack and Queue Applications

## 1 Balancing Parentheses
```
1. When you see an opening
 parenthesis, Push() it to stack.
 2. When you see a closing parenthesis, Pop() the stack.
 3. If the opening and closing parentheses don't match then the parentheses are unbalanced. Exit.
 4. If at the end the stack is empty the parentheses are balanced.
 5. Else, the parentheses are not balanced.  
```

## 2 Evaluating Reverse Polish Expressions
```
1. If you read a number Push() it to stack.
2. Else if you read an operand then Pop() two values off the stack.
  - combine the values with the operand.
  - Push() the result back onto the stack
3. Else if there is no more input, then pop and display the result.
```

## 3 Evaluating Algebraic Expressions
```
1. If you read a number then Push() in to the number stack.
2. Else if you read an opening parentheses, then Push() it on the operator stack.
3. Else if you read an operator op
  - while the top of the stack has a higher precedence than op
    -> evaluate_the_top()
  - Push() op on the operator stack
4. Else if you read a closing parentheses:
  - while the top of the stack is not a closing parentheses
    -> evaluate_the_top()
  - Pop() the closing parentheses
5. Else if no more input
  - while the operator stack is not empty
    -> evaluate_the_top()
```
### evaluate_the_top()
```
1. Pop() two numbers off the number stack
2. Pop() an operator off the operator stack.
3. Combine the 2 numbers with that operator.
4. Push the result to stack.
```

## 4 Backtracking
```
1. Push() all paths from the point on which you are standing on a stack.
2. While stack is not empty:
  - Pop() a path from the stack
  - follow the path until you reach an exit, intersection, or dead end.
  - if you found an exit -> quit()
  - else if you found an intersection
    -> Push() all paths meeting at the intersection, except the current one, onto the stack.
```
