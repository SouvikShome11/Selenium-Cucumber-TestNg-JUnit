1. First Create 3 folders -> 1. features, 2. cucumberOptions , 3. stepDefinitions
2. Create a feature file for a basic flow
3. create a Test Runner  (TestNgTestRunner) with basic setup
4. Create step-def file -> add the steps
5. Run and check it's working or not
6. Now start Breaking down the step-definitions in page wise classes
7. Above step will cause an issue - we are initiating the driver in first step def file. so other step def files won't have the reference of driver  (Null Pointer exception)
8. We need to do dependency Injection (Spring framework EJB ...). We will  use Cucumber PICO Container 
9. add PICOContainer -> Create TestContextSetup -> Add the shared variables (driver, landingPageProductName) -> Initialize TestContextSetup in each step-def class Constructor
10. Now Apply SRP (example -> move the tab switching out from the step-def methods)
11. Apply POM -> Move the x-paths and action methods to respective POM classes
12. While doing that we are creating object of those page classes in Step-Def methods, which is not a good practice
13. SO to resolve thar - we will Implement Factory Pattern
14. Create PageObjectManager Class in which we instantiate the object of page classes (ex: getLandingPage())
15. Then we need to instantiate PageObjectManager class in each step def file - which is not a good practice 
16. We need to resolve this by dependency injection - By instantiating PageObjectManager class through TextContextSetup Constructor (This WIll give null pointer exception)
17. dscv
18. Now it's time to move the driver initialization from a single step-def file to TestBase class
19. The driver object is mainly needed by the page object classes, so we need to initiate a new driver and pass it to Page Object manager
20. To do so we need to create test base class object in TestContextSetup Constructor and send pass the driver by calling its method -> pageObjectManager=new PageObjectManager(testBase.)
21. Move the Common Utility like switching tab to CommonUtils class -> this class also need driver -> Instantiate this class in TestContextSetup 
22. Make WebDriverManager Singleton
23. Now implement the logic to Read URL and Browser form Property file (Create Property file in resource folder -> implement the reading in TestBase class)
24. Implement Hooks to close browser , for driver knowledge in Hooks class we need to use TestContextClass
25. Implemented extent report
26. Implemented Screenshot on failure
27. 