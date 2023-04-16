# VeracityTechnicalTest
This program performs a word search in a given URL and counts the number of occurrences of a target word. It uses the java.io and java.net packages to read the contents of the URL, and the PatternSyntaxException class to handle errors related to regular expressions.

Usage       
To use the program, create an instance of the PerformWordSearchUseCase class and call the execute method, passing two arguments: the URL to search and the target word to count.The execute method will print the number of occurrences of the target word in the URL.

Domain     
The program uses an interface called Domain and an implementation class called DomainImpl to abstract away the details of reading the contents of the URL and counting the occurrences of the target word. The getTargetWordCount method in the DomainImpl class takes two arguments: the URL to search and the target word to count. It returns the number of occurrences of the target word in the URL, or -1 if an error occurs.

Testing    
The main method in the VeracityTechnicalTest class includes some test cases to demonstrate the use of the PerformWordSearchUseCase class. The first test case searches a particular URL, the second test case tests an incorrect URL format, and the third test case tests for empty arguments.

Conclusion     
This program provides a simple way to search for a target word in a given URL and count the number of occurrences. It demonstrates the use of interfaces and implementation classes to abstract away implementation details, and the use of error handling to gracefully handle unexpected conditions.
