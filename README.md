# PROJECT NAME
<h3> EMPLOYEE REIMBURSEMENT SYSTEM</h3>

# Project Description
<p>Allow employees to login or register and view previous reimbursements and submit new reimbursements for work related expenses.Managers can view all reimbursements that have been submitted and process those reimbursements either approving or denying them.
Reimbursement and User data persists on an AWS RDS database.</p>

# Technologies Used

•	Javalin
•	Java VERSION 8
•	HTML
•	CSS
•	Bootstrap
•	JDBC
•	AWS RDS
•	JavaScript
•	PostgreSQL
•	Postman

# Features

<h5>Interactive Web Page</h5>
<ul>
<li>Login and Register</li>
	<li>Veiw reimbursement by user id</li>
	<li>Veiw all reimbursments as manager</li>
	<li>Submit new reimbursement</li>
	<li>Process reimbursement</li>
	</ul>
<h5> Backend CLI menu</h5>
<ul>
	<li>Login and Register</li>
	<li> Veiw reimbursement by user id</li>
	<li> Veiw all reimbursments as manager</li>
	<li> Submit new reimbursement</li>
	<li> Process reimbursement</li> 
	</ul>

<h3>To-do list:</h3>

•	Adjust CSS values for all HTML pages so that the apperances look well on other type of devices.

# Getting Started
You will need the following programs installed in your computer in oder to make this project run:
<ul>
	<li>Git</li>
	<li>Java</li>
	<li> Spring Tool Suite 4</li>
<li>Maven </li>
<li>PostgreSQL</li>
	<li>DBeaver</li>
	<li>Postman</li>
	</ul>

# Usage
After installing my project, you will need to create a databse connection in DBeaver and Requests in Postman
	<h4>Creating a database connection in DBeaver</h4>
	<ul>
<li>Launch DBeaver. Click on the Database tab and there will be an option to create a new database connection</li> 
		<li>A pop up will appear. Select PostgreSQL</li>
		<li>After clicking next, it will display connection settings.</li>
<li>In the host field, copy and paste the following end point: javafullstackaws.ceboc7nfkw4e.us-east-1.rds.amazonaws.com</li>
<li>Additionally in the Authentication setting, input the correct username and password of the RDS(Which in this case should be postgress and password)</li>
		<li>Click on finish.</li>
	</ul>
<h4>Creating a new schema in DBeaver</h4>
With the database connected created, you'll have to make a schema next. Go to your newly created database, click on database and the drop down arrow.
<ul>
	<li>Right click and hover over Create. Select Schema.</li>
	<li>For this project, name this schema p1schema</li>
	</ul>
If there is no active connection Click on the Select data source button and select your database you're using Another way of doing is this is opening the schema folder in database navigator, right clicking the schema you want to work in, and select the option "set as default"

<h4>Creating requests in Postman</h4>

In order for the front end to interact with the back end and our database, we'll be using requests, JavaScript and JDBC.
<ul>
	<li>Launch Postman. Navigate to File and select New and choose New workspace</li>
	<li>Name your new creation and right click to add a folder (I named it P1)</li>
	<li>Now with in P1 folder, repeat the process and make folders for User and Reimbursement</li>
<li>Right click on the User folder and click on the option to add a request. There are different types of request we will be using.</li>
<li>In order for the requests to go through, there are several parts you are required to fill out</li>
<li>Change the request by selecting the drop down menu on the left. Then input the end point. This is presented in the launcher file, so copy and paste.</li>
	<li>Next click on body and change the option to raw. Each request has a different set of arguments passed in order to function.</li>
<li>Change the raw option to JSON. The following images below show how each requests are set up and the arguments passed.</li>
</ul>
	<h4>Launching front end funtionality</h4>

Now with all that set up, we can now interact with my project! Launch STS and open the project. Click on run and there will be message in the console to notify that you are connected to Javalin. Next, open Visual studio and open the front end folder. Start with login.html and hit the F5 button to run it.
	
<h3>Licenses</h3>

<li>license: postgresql</li>
<li>license: apache-2.0</li>


