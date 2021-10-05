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
