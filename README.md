# quotes-Gson

Lab 08 Quotes - OO Design and GSON
Setup
- Create a new repository for this partnered lab; call it quotes. In that repo, add a .gitignore file from the course repo, and then run gradle init --type java-application.

Feature Tasks
 -
 - Use the file recentquotes.json to show random popular book quotes.
 - Your program should use GSON to parse the .json file.
 - In the build.gradle put this in the dependecies: { implementation 'com.google.code.gson:gson:2.8.6' }
 - To check if the Gson is working type in Gson gson = new Gson(); into the App class.
 - The app needs no functionality other than showing the quote and the author when it is run. The app should choose one quote each time it is run.
 - Ensure that you can test your code by running ./gradlew test.



Lab 09 Quotes - API / web requests
# Feature Tasks:
 
- Start by refactoring anything that you don’t like about your solution from yesterday.
  +  When running the application, don’t read in the quotes file. Instead, make a request to an API to get a random quote.
+ please do not delete your existing code, look at the very next feature task, you will still need that code
        * Some examples of APIs you could choose to use:
            FavQs: sign up for a free API key (takes 2 minutes) to get random quotes
            Formismatic: no API key required, visit http://api.forismatic.com/api/1.0/?method=getQuote&format=json&lang=en to get random quotes
            Star Wars Quotes API
            Ron Swanson Quotes
        Rather than a Quote of the Day, please use an API that allows you to show a random quote.
   + We do still have this quotes file, though, and it might still be useful! Ensure that if your app has errors in connecting to the Internet, you instead display a random quote from your file.
    When we grab a random quote from the Internet, we could add it to our file of quotes, for use if the app goes offline in the future. Add that functionality: when a quote comes back from a request, it’s also cached in the json file.
