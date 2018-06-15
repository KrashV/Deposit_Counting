# Deposit_Counting
An OpenWay Summerschool contest application for calculating the deposit sum

# Summary
A simple tool that helps to calculate the estimating time of the increase of the deposit sum.

# Requirements
JRE 6 or greater.

# Installation
Download the [latest release](https://github.com/KrashV/Deposit_Counting/releases). That's pretty much it!

# Usage
After installing the jar file, open the command line and execute the following command:

``java -jar [path_to_the_jar_file] -initial [initialSum] -apr [Annual Percentage Rate] -multiplicity [Multiplicity]``
to calculate the estimating time.

For example, assume you deposit $100 at your bank, you earn interest annually, and the account pays 5 percent. How much time will it take to double the sum?
Run the following command:

``java -jar Deposit_Counting.jar -initial 100 -apr 5 -multiplicity 2``

The following result will show up:

*Under the 5,00 annual percentage rate, the initial sum: 100,00 will increase by 2,0 times in approximately 14,2067 years.*

# Issues
Nothing for now
