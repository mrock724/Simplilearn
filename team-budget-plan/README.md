# Team Budget Planner.
## DESCRIPTION

## Project objective:
As a developer, write a program using JavaScript to decide the budget of a specific team.

## Background of the problem statement:
Develop a website where program managers of a specific team will add details of professional deals they want to have with vendors.
The finance team will check expenses of those teams and will decide their annual budget.

### You must use the following:
 * JavaScript: A programming language (All business logic should be implemented in client-side javascript).
 * Git: To connect and push files from the local system to GitHub
 * GitHub: To store the application code and track its versions
 * JavaScript concepts: Functions, prototypes, primitives, objects, IIFEs, promises, async, and webpack
 * Client-Side Javascript libraries such as bootstrap, jquery, angular, react, request, etc are all welcome to be used.

### Following requirements should be met:
 * There is no backend required. There is no database required. All business logic should be implemented in client-side javascript.
 * There is no persistence required, so any test data to be loaded at runtime can simply be hardcoded as javascript / json objects.
 * There is no need for security to be implemeted in this project.
 * There are no specific requirments for the UI other than than it be functional to present the business data to the user.
 * Business Functionality should include:
   - There will be (at least) 2 views: Product Manager View and Finance View.
   - The ability to view, edit, add, and delete vendors. (Product Managers primarily do this)
   - The ability to view, edit, add, and delete deals. There may be some kind of "task" or project info.
   - The ability to view, edit, etc cost/budget (Finance Team Members do this).
   - Some test data should be loaded (hardcoded) at page load time in order to have some data to show.
   - Project Managers should be able to edit project details like vendor, name, technology etc.
   - Finance Team should be able to edit project financials such as project cost.
   - One possibility is to implment some degree of detail around expenses or line-item of budget??? (Optional)
 * State only needs to be maintained on the current user view. State maintained between views or session management is not required.
 * Some ways that you can do the two different views:
   - Tabs
   - Separate Pages
   - Toggle Button (toggle views)
   - Simulated "login" page  (one user account goes to finance, other one to project)

#### Example JSON
You may want to store your deals inside a javascript object that looks vaguely like this one:
```javascript
deals = [
{"deal_id" : 0 , "vendor_name" : "Microsoft", "project_name" : "Apollo Project", "project_cost" : 1000},
{"deal_id" : 1, "vendor_name" : "Intel", "project_name" : "Hermes Project", "project_cost" : 10000},
{"deal_id" : 2 , "vendor_name" : "Apple", "project_name" : "Zeus Project", "project_cost" : 100000}
]
```

#### LocalStorage
You may also want to consider using the `localstorage` object in javascript in order to store and persist small amounts of your data.
Here's an example:
```javascript
// localstorage allows us to persist key value pairs in a way that would survive page refreshes, navigation, and user closing browser.
// localstorage has limits to the size of each object stored.
localStorage.setItem("myData", "test")
var myDataTest = localStorage.getItem("myData")
```

#### JSON Server
 * [Json Server](https://www.npmjs.com/package/json-server).
 * It creates a mock API back-end which might make it easier to access your data layer from the front end.
