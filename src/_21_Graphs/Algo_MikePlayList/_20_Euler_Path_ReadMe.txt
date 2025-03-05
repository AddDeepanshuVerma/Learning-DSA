                                            Euler Path

A Graph has Euler path :
    If we can go through all the given edges from one node to another node while
    we pass through every edge only once.

A Graph has Euler circuit:
    If it has euler path and we end-up at the same node where we started.
    Here if any graph has Euler circuit/circle it means we can start at any node,
    and we will end-up at the same node after generating an euler path.

Key points :
	1. A Graph which has only euler path called 'Semi Euler Graph'
	2. A Graph which has Euler circuit called ' Euler Graph'
	3. If there are two or more separate graph that graph can not be any type of euler graph
		condition : both separate graphs should have edges in them.
	4. Degree count :
		A. When a Graph has euler circuit then all the node will have even numbed of degrees
		   means if a node points to them, they will also be pointing to some node means:
		   if we go inside a node n number of time we'll have the same n number of times exit path
		   as that would be the reason where in Euler circuit we endUp where we started.
		B. When a Graph is a semi euler graph It means: At a valid euler path there will always be two
		   such node whose degree count will be ODD.
		   As these two nodes are the only reason it is Semi Euler Graph.
	5. Odd Degree nodes count  == 0 => Euler Circuit
	   Odd Degree nodes count  == 2 => Euler Path
	   Odd Degree nodes count  >  2 => None

Brief on how to solve : Steps to check weather a Graph is Non-Euler/Semi-Euler/Euler
1. First we have to make sure that all the edges belong to single component, or we can say that
   "All node with degree > 0 are part of same component" if not means we can not form a euler in a single go.
2. To check above point, run a DFS from any one of node whose degree > 0 & check if we have visited all nodes with some degrees
   here those node which has 0 degree will be considered exclude.
3. Now we are sure that all edges belong to same component
4. Now check the count of how many node has odd degree as if :
   odd degree count == 0 means euler circuit coz we can come back where ever we start.
   odd degree count == 2 means euler path    coz we can start from 1st odd and end at 2nd odd.
   odd degree count >  2 means Non - euler   coz some node will be missed while making a path with euler conditions.

Now GFG question can be solved : https://www.geeksforgeeks.org/problems/euler-circuit-and-path/1

		
						