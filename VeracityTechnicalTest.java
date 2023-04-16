import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.PatternSyntaxException;

public class VeracityTechnicalTest {

public static void main(String[] args) {

    System.out.println();
PerformWordSearchUseCase usecase = new PerformWordSearchUseCase();
usecase.execute(args);

unitTesting(usecase);
    }

public static void unitTesting(PerformWordSearchUseCase usecaseTest){
   System.out.println("\n-------------Unit Testing-------------");     
    // Testing for a particular url
System.out.println("Testing for a particular url");
String[] test1 = {"https://www.veracitytrustnetwork.com/blog/", "blog"};
usecaseTest.execute(test1);

// Testing for a incorrect url format
System.out.println("Testing for a incorrect url format");
String[] test2 = {"www.krowtentsurtyticarev.org/news/how-to-exit-vim/", "vim"};
usecaseTest.execute(test2);

// Testing for empty arguments
System.out.println("Testing for empty params");
String[] test3 = {};
usecaseTest.execute(test3);
    }


public static class PerformWordSearchUseCase{

static Domain domain = new DomainImpl();
   
public void execute(String[] args) {

int argsCount = args.length;
if(argsCount == 0) {
System.out.println("Error: No arguments passed. Please provide two params: url & target word");
}
else if(argsCount == 2) {
String firstArgument = args[0];
String secondArgument = args[1];

if(firstArgument.startsWith("https")) {
int count = domain.getTargetWordCount(firstArgument, secondArgument);
displaySearchCount(firstArgument, secondArgument, count);
}
else if(secondArgument.startsWith("https")) {
int count = domain.getTargetWordCount(secondArgument, firstArgument);
displaySearchCount(secondArgument, firstArgument, count);
}
else {
System.out.println("ERROR: Incorrect target url");
}
}else {
System.out.println("ERROR: Please provide two params: url & target word");
}
System.out.println("----------------------------");
}
}

public static void displaySearchCount(String targetUrl, String targetWord, int count) {
if(count != -1) {
String displayMessage = String.format("Number of occurances of the target word '%s' in the url '%s' is %d", targetWord, targetUrl, count );
System.out.println(displayMessage);
}
}

public interface Domain {
public int getTargetWordCount(String url, String target);
}

public static class DomainImpl implements Domain {

@Override
public int getTargetWordCount(String targetUrl, String targetWord) {
try {
           URL url = new URL(targetUrl);
           InputStreamReader in = new InputStreamReader(url.openStream());
           BufferedReader reader = new BufferedReader(in); //BufferedReader object is created to read the contents of the URL link
           String inputLine;
           int count = 0;
           while ((inputLine = reader.readLine()) != null) { // Looping with " while" through each line of the content
               count += (inputLine.split(targetWord).length - 1); // Counting the number of occurrences of the target word in each line and adding it to the counter
           }
           reader.close(); // Closure of the BufferedReader
           return count;
       }
catch (MalformedURLException e) { // Catching any exception that may occur
e.printStackTrace();
           System.out.println("ERROR: Incorrect url error: " + e.getMessage()); // Printing the error message
           return -1;
} catch (IOException e) { // Catching any exception that may occur
        e.printStackTrace();
           System.out.println("ERROR: in reading the content " + e.getMessage()); // Printing the error message
           return -1;
}catch (PatternSyntaxException e) { // Catching any exception that may occur
        e.printStackTrace();
           System.out.println("Error message: " + e.getMessage()); // Printing the error message
           return -1;
}
}
}


}

