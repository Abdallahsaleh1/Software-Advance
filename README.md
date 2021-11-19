<h1> Code refactor comment </h1>

<h4> Changes </h4>
<h5>
1. delete move variable in line 34, because it declared but it never used.
2. remove magic number in line 52 and replace it with variables (width :integer, height:integer) of window size.
3. remove magic boolean in line 53 and replace it with variables (visibility) of window and it should be boolean.
4. "buildFileMenu" and "buildEditMenu" is too long, it's long than 10 line, we should split it.
5. also split class editor into two classes to mkae it single responsibility for classes and method 
5. "open" object in "buildFileMenu" function, we should set the property then add it to the file.
6. naming of varible in "buildFileMenu" function shouldn't be (n).
7. split "new" and "save" cases in "actionPerformed" function in new functions.
8. reuse function in "loadFile" function.
9. remove javaMenuItem copy, paste, cut and move because it never used.
10. remove 3 - 4 packeges that are not used
  
</h5>
