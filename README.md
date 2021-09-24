![Screenshot](Classdiagram.jpeg)

<h1> Description </h1>

<h4> There's one class called Connection that has 5 intance:  </h4>
<h4> SSH and telnet and http and scp and ftp </h4>
<h4> in the first method(getInstance) in this class we accept the name of the protocol that wants to make a connection and initiate an object of that kind , after we check which type of protocol teh user want to make a connection for , we check if the connection count still under the limit which is 3  after that we check if there was a past connection so we dont make another connection and in the end we return the protocol we made </h4>

<h4> in the Second method (release) we ommit an open connection to make room for another connections that the user can open and we check if the protocol that he wants to release is opened or not after that we return either false or true depending on the case if it's there or not  </h4>

<h4> in the third method (getCurrentConnections) we return all the opened connection that we have </h4>

<h4> in the forth method (send) the user send a message and we check which protocl has sent this message to the function and return the name of this protocl with the message </h4>
