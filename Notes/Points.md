1. How to run Cucumber test parallel in cucumber in TestNG - by adding the below code in test runner class 
    This is a method of AbstractTestNGCucumberTests class

      @Override
      @DataProvider(parallel = true)
      public Object[][] scenarios() {
      return super.scenarios();
      }
2. How to Implement Extent Reporting
   
   Dependencies: 
   a. extentreports-cucumber7-adapter
   b. extentreports

   Create a extent.properties file
   Add this in Runner Plugins: "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
   
3. HOW to take Screenshot for failed test cases:
   
   STEP: 1
   We need to write a @AfterStep hook method - which will check the status of the scenario after executing each step
   dependency needed : common-io (to convert the file format to bites)
   and attach the ss with scenario using 	scenario.attach(fileContent, "image/png", "image"); (fileContent should be in bite format)

4. How to re-run fail scenarios
   add-> plugin: "rerun:target/failed_scenarios.txt"  -> this will register all the failed scenarios in the folder

   Then create another test runner for re-run failed tests -> set features= @target/failed_scenarios.txt

5. How to tun CUCUMBER  from commandline
   
   mvn test
   https://cucumber.io/docs/cucumber/api/?lang=java#options

   How to pass browser-?
   mvn test -Dbrowser=chrome
   System.getProperty(browser) [See the code in TestBase class for browser selection]

6. Convert TestBg framework to JUnit
   
   1. remove TestNG related 2 dependencies
   2. Junite test runner name should ends with Test (ex: JunitTestRunnerTest.java)
   3. Change in test TestRunner: @RunWith(Cucumber.class) and remove extends AbstractTestNGCucumberTests
   4. Remove @DataProvide, which was used to run the test parallel
   5. Change all the Assertions to JUnit assertions
   6. JUNit Parallel Execution
      Add the SureFire Plugin and it's  configuration
      Trigger the test from maven (Unlike TestNG if we Trigger from TestRunner class it will not trigger parallel)
      JUnite runs Feature files parallely not scenarios unlike TestNG
      
   
   
   

   

   