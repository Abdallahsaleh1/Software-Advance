<h1> Code refactor comment </h1>

<h4> Changes </h4>
<h5>
1. delete move variable in line 34, because it declared but it never used.
 </h5>
 <h5>
2. remove magic number in line 52 and replace it with variables (width :integer, height:integer) of window size.
  </h5>
3. remove magic boolean in line 53 and replace it with variables (visibility) of window and it should be boolean.
    <h5>
4. "buildFileMenu" and "buildEditMenu" is too long, it's long than 10 line, we should split it.
      </h5>
      <h5>
5. also split class editor into two classes to mkae it single responsibility for classes and method 
        </h5>
        <h5>
5. "open" object in "buildFileMenu" function, we should set the property then add it to the file.
          </h5>
          <h5>
6. naming of varible in "buildFileMenu" function shouldn't be (n).
            </h5>
            <h5>
7. split "new" and "save" cases in "actionPerformed" function in new functions.
              </h5>
              <h5>
8. reuse function in "loadFile" function.
                </h5>
                <h5>
9. remove javaMenuItem copy, paste, cut and move because it never used.
                  </h5>
                  <h5>
10. remove 3 - 4 packeges that are not used
                    </h5>
  
