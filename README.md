# Software-Advance 
# Errors Handeling

<h2> <strong>Explanation part 1 & part 2 </strong></h2>
<h4> i made a constraints file that refer to the system status if it's busy or available ..etc</h4>
<h4> and depend on the status i throw a diffrent exceptions that handel the diffrent errors you gaved to us in the pdf in every protocol file </h4>
<h4> in the demo file that call the protocols functions i build the try and catch to catch the errors taht can happen when calling the release and the send function , so the user tries if it's not succes he will go to diffrenet catches until the exact error that happend will return to him </h4>
<h4> and when catch , catches the error it return it by the logs whith it's diffrent kind , so if the try is success the logs will be INFO , if the catch catches an error it will give an error logs , if it's just that the program couldn't do something but it's not an error it's beacuase of the functionallity of the program so it will give the exception with warnning log</h4>


<h2><strong> Explain why the logger uses a singleton design pattern.</strong>
<h4> Suppose we have an event-based logging service: Client objects request that text be logged by sending a message to the logging service. Other objects actually log the text somewhere (console, file, whatever) by listening to the logging service for these logging requests and handling them. First, notice that the logging service passes the classic test for being a singleton:
The requesters need a well-known object to which to send requests to log. This means a global point of access.
Since the logging service is a single event source to which multiple listeners can register, there only needs to be one instance.</h4>
