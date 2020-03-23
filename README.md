# Robot_Game_Java
<h1>Robot Game</h1>

<p>The task is to accept a set of commands and then simulate whether an object can move
   according to these commands without falling off the table it stands on.
   The table can be seen as a matrix where the object will have an x and y position.The object always occupies exactly one cell and can be seen as a point without mass. Origo
   is at the top left.</p>
   
<h3>Protocol</h3>

<h5>First, your solution reads a header from stdin text file like this:</h5>
<ul>
<li>The size of the table as two 16-bit little-endian integers [width, height]</li>
<li>The objects starting position as two 16-bit little-endian integers [x, y]</li>
</ul>

<h5>This is followed by an arbitrarily long stream of commands of 8-bit integers.</h5>

<h5>When the simulation is complete, your program outputs the answer to stout text file as per
    below:</h5>
<ul>
<li>If the simulation succeeded: The objects final position as two 16-bit little-endian
    integers [x, y].</li>
<li>If the simulation failed (the object falls off the table): Position [-1, -1] should be
    returned</li>
</ul>

<h3>Commands</h3>
<p>The object always has a direction (north, east, south or west). A simulation always starts
   with direction north. North means that if the object sits on [2, 4] and moves forward one
   step, the object will now stand on [2, 3].</p>
   
   <h5>The commands are:</h5>
   <ul>
   
   <li>0 = quit simulation and print results to stout text file</li>
   <li>1 = move forward one step</li>
   <li>2 = move backwards one step</li>
   <li>3 = rotate clockwise 90 degrees (eg north to east)</li>
   <li>4 = rotate counterclockwise 90 degrees (eg west to south)</li>
   </ul>

<h3>Example</h3>
<p>If the program gets 4,4,2,2 as input, the table is initiated to size 4 x 4 with the object in
   position [2, 2] with direction north. Then, commands 1,4,1,3,2,3,2,4,1,0 are read
   from stdin and executed. The final output would then be the end position of the object,
   in this case [0, 1].</p>
   
   
   
   
