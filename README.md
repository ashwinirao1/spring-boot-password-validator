# spring-boot-password-validator

Password Validator API Description

The password validation RESTful API takes a plaintext password as input and validate it against the following rules:

- Must be at least 8 characters
- Must be less than 20 characters
- Must include both upper and lowercase letters, plus at least one number 0-9
- Must not include the same sequence of two or more characters repeated twice consecutively (aabbaa is valid, but aabbaabb, aaa and acac are not)

-How to run

> Pre requisites :

-Mac OS /Unix (Needs to be tested for Windows) 
-Java 8 on classpath
Check that could be performed for this ,execute as following:
Ashwini-Rao $ java -version
java version "1.8.0_45"
Java(TM) SE Runtime Environment (build 1.8.0_45-b14)
Java HotSpot(TM) 64-Bit Server VM (build 25.45-b02, mixed mode)
If Java 8 not on classpath,then got terminal and edit .bash_profile file and add below :

export JAVA_HOME=$(/usr/libexec/java_home)

OR

export JAVA_HOME=$(path to JDK 1.8 Home)

-Access to Terminal/Command Prompt

> Running the application :

Start the application via :

/validator.sh start

Stop the application via :

/validator.sh stop

Run the validation password service via passing the password text as an argument :

/validator.sh  passwordToBeTested1

@See Example API Runs (Refer EXAMPLE_API_RUNS_TERMINAL.txt) for more examples
