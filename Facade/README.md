# Facade Pattern

The Facade Pattern Provides a unified interface to a set of interfaces 
in a sub-system. **Facade Defines a higher level interface which makes the use 
of sub-system easier.**

*Keep your circle of friends(Known Classes) Small.*

### A Youtube Comment Explanation
Facade seems to be even simpler in my view.
All those classes having complex relations is pretty irrelevant to the Facade pattern. The only thing important is that those classes are multiple and the client has to deal with all of them. So the Facade class combines interfaces of all needed classes into one interface. I.e. Client calls Facade.StartEngine, Facade.StopEngine, Facade.TurnLeft, Facade.TurnRight, and Facade class calls Engine.Start, Engine.Stop, Wheel.Left, Wheel.Right. It's useful for example in WCF services, when you have to expose many controllers' methods to an external client.


![UML Diagram for Facade Pattern](/Facade/UML.jpeg "UML Diagram for Facade Pattern")

