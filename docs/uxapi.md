API UX Round Two Sketch
=======================

This doc is meant to elaborate on and help establish the design for the next API
refinement, including ergonomic and functional aspects.
 
## Challenges

With the current API, it is difficult to think about *related* data. There are a
few kinds of related data that we can consider. The focus for now is on *nested*
data. For an example, consider 10-to-1 associations over a large set of
entities. It is also difficult

### #1 Associations

It is difficult to express the 10-to-1 association in a way that is intuitive.
The present methods rely too much on knowledge of the underlying math. This
isn't bad for those who have the knowledge, but it is for those who just want to
express an association between values.

### #2 Runtime Representation

It is difficult to efficiently track intermediate state of generated data, such
as a common identifier on the "one" side of a 10-to-1 association.

### #3 Grammar

There is no standard grammar. After some use, the ad-hoc nature of the resolver
interface is starting to become obviously cumbersome and repetitive.

### #4 File Format

There is no common format for sharing a group of data mapping functions. This
means that common recipes that might be useful are not easily reused.

## Design Sketch

Build a proper grammar that allows for DAG-structured function dependencies.
Make it easy to read and modify.

The language of VDS should be a recipe-level language. It should also give some
leverage to the runtime to find the best functions to use in fulfilling the
request. For simple cases, the recipe should be simple and obvious. For more
ambitious efforts, the language should allow for finer control.

### Syntax Examples

**Functions are named.**
~~~
Func1() # simple named function
~~~

Functions are specified by name, but must include parenthesis.

**Input and Output types are both optional.**
~~~
Func1() -> Vampire  # This function yields result of type Vampire (scary)
Human >- Func1() # This one takes a Human as its input (operand)
Human>-Func1()->Vampire # This one take a human and yields a Vampire (very scary)
~~~

They can have either or both the input type and output type, expressed with the
prefix 'name>-' for the input type and the suffix '->name' for the output type.
The reason for specifying either is be more specific about the kind of
data flow you need to support.

**Multiple functions can be specified.**
~~~
Func1() ; Func2()
~~~

Func2() is Unary, Func1() is Unary, and they are composed together automatically.
You don't see the unary operand, because it is implied. When you conjugate two
functions with a semicolon, it is an implied lambda, and the data type and values
flow from the return of the function on the left ot the operand in the function
on the right.

**Function outputs can be assigned to a named variable.**
~~~
dracula=Func1()
~~~

**Functions can reference named variables in their definition.**
~~~
dracula=Func1() ; Func2() ; Func3($dracula)
~~~

Func3() is also unary, but this time it doesn't take it's input directly
from Func2(). Func2() takes its input operand from Func1() implicitly,
and Func3($dracula) takes its input from Func1() via the $dracula variable.

**A metagen recipe provides named access points.**
~~~
output1=UnaryFunc1() ; output2=UnaryFunc2() ; output3=UnaryFunc3($output1)
~~~

In this case, you can ask the generator for the result of any of the named
variables. Since they are all

## Design Approaches

### #1 Intuitive Expression of Associations

In order to represent nested associations of data values in a more intuitive
fashion, any implicit nesting should be banished and replaced with an explicit
nesting format. This simply means that the nesting must be structurally and
visually apparent in the native configuration format, and that the result of
using such configuration should be equally obvious.

In short, make the configuration format nested and structurally equal to the
associations in the values that will be generated.

#### Design Strategy

1. Provide a configuration format that allows different levels of nesting
   to be expressed.

### #2 Efficient Runtime Representation and API

Given the need to organize data mapping functions in a way that can support
nested iteration, there is a scope of data that will remain fixed at outer
levels while inner levels have changing data per iteration.

Nested configuration structure can easily support nested iteration of
mapping functions.

Also, it is reasonable to expect that developers want to access directly
these names, but without paying for a map access every time.

#### Design Strategy


1. Provide a context and API for managing named and nested scopes of mapping 
   functions
1. Provide an internal cache in the runtime for named values.
2. Make the cache design straight-forward enough for 
2. Allow a mapper to use a value from the provided scope as the input value.
3. Enable access to the generated values through an efficient naming interface.
4. Do not rely on maps. If necessary, provide a cachable/reusable lookup
   interface that relies on arrays in the worst case.


### #3 Standard Grammar

### #4 Standard File Format





