# Adapter Pattern

The Adapter Pattern converts the interface of a class into
another interface the clients expect. Adapter lets classes work
together that couldn't otherwise because of incompatible interfaces

## Use Case

One use case of adapter pattern that i can think of other than providing backward 
compatible API, is Imagine if we want to achieve a task like fetching data from an API.
Now to achieve this goal we have lets say 3 libraries- 
- Library1
- Library2
- Library3

Now these three have separate API and we don't know which one to use, or we want to make them interchangeable. What we can do is to create an Interface
defining API we want and make a adapter which will convert each of the three Libraries
usage into our defined common API, so usage of these libraries will become our
Adaptee.

so Adapter pattern will help us to change internal library we will use for fetching data
without changing our client code (i.e code where we are using the Fetch calls).

![UML Diagram for Adapter Pattern](/Adapter/UML.png "UML Diagram for Adapter Pattern")
