# SurveyApp
This is a web application. In the application, users create a survey. 
They leave and save points and messages about the brands they choose in the survey. 
After doing this, the data is saved in the database. Then the user can see the feedback about the brands given on other pages. 
In addition, in order to understand whether the given brands are positive or negative among users, a transaction is carried out between those who support and those who do not, as a result of which we can understand whether that brand receives positive responses. 
Apart from that, if we need to talk about the content of the project, the project is a spring boot project. 
With Spring boot, thymleaf, mysql, hibernate technologies are used. 
The structure of the project was created using the mvc design pattern. 
It has a double layer structure. 
Since it is a double layer, access is provided through a service layer instead of directly accessing the class we call data access objects. 
Thus, our project becomes more secure. 
Within the entity structure, there is a class suitable for the structure of the tables we created in the database and an enum class where the names of the brands are kept. 
Interaction with the data in the database is provided within the DAO structure. 
Then, these processes are transferred to the service layer and then to the controller layer with dependency injection. 
Controller classes interact with html pages in the project.