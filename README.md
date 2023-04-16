# VeracityTechnicalTest
This program performs a word search in a given URL and counts the number of occurrences of a target word. It uses the java.io and java.net packages to read the contents of the URL.

Application Architecture    
The usecase communicates between the main java class (presentation layer) and the domain layer. The usecase decides how the data can be sent to the presentation layer.

Domain Layer      
The domain implementation implements the Domain inetrface. The interface encapsulates the file read operations from the usecase on the prsentation layer.The usecase holds the main buisness logic. The getTargetWordCount method in the DomainImpl class takes two arguments: the URL to search and the target word to count. It returns the number of occurrences of the target word in the URL, or -1 if an error occurs.

Testing    
The main method in the VeracityTechnicalTest class includes some test cases to demonstrate the use of the PerformWordSearchUseCase class. The first test case searches a particular URL, the second test case tests an incorrect URL format, and the third test case tests for empty arguments.

Instructions for Running    
The command to run : java VeracityTechnicalTest.java

Error Handling        
The code includes several error-handling mechanisms to prevent the program from crashing or producing incorrect results in case of unexpected inputs or errors. Here are some details:

If no parameters are provided, only one parameter is provided,  first parameter is not a valid URL, the program displays an error message.    
If there is an error while reading the web page content, error with the regular expression used for splitting the web page content or if unexpected exception occurs the program catches the exception and displays an error message instead of crashing.

By handling these errors, the code becomes more robust and user-friendly, as it provides clear feedback when something goes wrong.

Bonus point    
As for the bonus question, the example may produce either 0 or 122 results depending on whether or not you include the word "blog" that is part of the URL which is given as input. If its been included, it will generate the the result as 122 because the word "blog" appears 122 times in the page content. If its been excluded, it will generate the the result as 0 because the word "blog" does not appear in the page content.

