# GitBisectKickstarterStatistics

This program compiles various statistics about Kickstarter projects.

#### Clone and Setup instructions: 
	- Clone it from: https://github.com/nico3865/GitBisectKickstarterStatistics.git
	- Import it in Eclipse as a Gradle project
	- Run Gradle 
	- Run the Main: main/PrintKickstarterStats.java
	- Run JUnit (some very bad dummy tests are in the src/test/java folder) 

You will use Git Bisect to find two commits that introduced two bugs in this program.

#### We know that:
	- the two bugs are: 
		1) wrong output for percentage of successful Kickstarters.
		2) wrong output for average for funding goals.
	- those two numbers are returned to the main by two functions in the KickstarterStats class: 
		1) getGlobalAvgOfFundingGoals()
		2) getPercentageThatReachedFundingGoal() 
	- we know that those functions used to work correctly at those commits:
		1) getGlobalAvgOfFundingGoals() --> b68a8b274ef026cd589757629b79d9dc8a73d2c3 (ADD: avg goal function)
		2) getPercentageThatReachedFundingGoal() --> 8413c7801fc83d66b7987265de9b040afdce116a (ADD: function for getting percentage of kickstarters that reached their funding goal)
 
#### Here are the steps to find the bugs with Git Bisect:
	A) Make two Mockito tests for the two buggy functions (This will allow you to isolate the calculations from the csv reader logic and thus determine where each bug comes from).
		- I actually already made one to get you started
		- make a similar test for the second buggy function
	B) Then run Git Bisect: 
		- open a terminal in your local git repo's folder
		- git bisect start
		- git bisect bad // to indicate current head is bad
		- git bisect good b68a8b274ef026cd589757629b79d9dc8a73d2c3 // to indicate last known good commit for this avg goal feature. For the percentage feature: d29668c2b20bb87c8793e0c0c0338c8314f9b6ab
		- then, paste your test back in the test folder --> and run it. depending on the result of the test, type git bisect bad or bisect good
		- repeat until git finds the first bad commit.
		// NB, use: git bisect reset // if you made a mistake and want to start over.

Of course since it's a small repo, with a short history of commit, it would be relatively easy to find the bugs using 
	a) git-grep, or 
	b) visualizing a file's history with git-blame (see feature accessible on GitHub's website)

But the goal here is to get familiar with Git Bisect.
