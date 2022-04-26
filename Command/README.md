# Command Pattern

The Command Pattern encapsulates a request as an
object, thereby letting you parameterize other objects
with different requests, queue or log requests, and
support undoable operations.

We use command pattern to encapsulate command and its receiver into a request object.
This gives us the power to Create various Invoker(*Remote in our case*) and also **UNDO** or **REDO** and operation. 


## Use Case
When you need to decouple an
object making requests(Invoker aka *Remote in our example*) from
the objects that know how to
perform the requests(*In our example Receivers*), use the
Command Pattern.

![UML Diagram for Command Pattern](/Command/UML.png "UML Diagram for Command Pattern")

