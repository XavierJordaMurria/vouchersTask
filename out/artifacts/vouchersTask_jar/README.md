## Task 1

A line of input will take the form of a command and parameters, with the following specification:
• Tokens (command and parameters) are separated by a space.
• Tokens may be wrapped by ""

The application will take a file path from a command line argument, read in the contents of the file and output the result to stdout.

The application should take a command line flag “-d” as specified:
• The “-d” flag is followed by an argument setting the bodyDelimiter
• The bodyDelimiter determines the character used to separate sections of
the output
• The “-d” flag may appear before or after the path in the arguments list
• The flag is optional and if not set the default bodyDelimiter is “-”

Examples:

 Invocation:
     ./task1 command.txt
File Contents:
     "command 1" parameter1 parameter2
     command_2 x y z
Output to stdout:
     "command 1" parameter1 parameter2
     ---------------------------------
     command 1
     parameter1
parameter2
     command_2 x y z
     ---------------
     command_2
     x
    y
     z
Invocation:
     ./task1 command2.txt –d “^”
File Contents:
      “command 3” “a value” “another value”
Output to stdout:
     "command 3" “a value” “another value”
     ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
     command 3
     a value
     another value