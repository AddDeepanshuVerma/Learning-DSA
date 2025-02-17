


                                                                Euler Path

A Graph has Euler path :
    If we can go through all the given edges from one to another vertices while
    we pass through an edge only once.

A Graph has Euler circuit:
    If it has euler path and we end-up at the same vertex where we started.
    Here if any graph has Euler circuit/circle it means we can start at any vertex,
    and we will end-up at the same vertex after generating an euler path.

Key points :
	1. A Graph which has only euler path called 'Semi Euler Graph'
	2. A Graph which has Euler circuit/circle called ' Euler Graph'
	3. If there are two or more separate graph that graph can not be any type of euler graph
		condition : both separate graphs should have edges in them.
	4. Degree count :
		A. When a Graph has euler circuit/circle then all the vertices must be having even number
		   of degrees means if someone points to them they will also be pointing to someone means:
		   if we go inside a vertex n number of time we'll have the same n number of times exit path
		   as that would be the reason where in Euler circuit we endUp where we started.
		B. When a Graph is a semi euler graph It means: At a valid euler path there will always be two
		   such vertex whose degree count will be ODD.
		   As these two vertices are the only reason it is Semi Euler Graph.
	5. Odd Degree vertex count  == 0 => Euler Circuit
	   Odd Degree vertex count  == 2 => Euler Path
	   Odd Degree vertex count  >  2 => None
	   
Now GFG question can be solved : https://www.geeksforgeeks.org/problems/euler-circuit-and-path/1

		
						