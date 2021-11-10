**Her is comming how i am used the Quick Start Project:**
from first, this project handle about the APi-Restful endpoint,
plus the security algorithm,bcrypt.
and we can see this anotation (@RolesAllowed),
work with endpoint like a key for gate to all useres, its stop all useres,
when they passing the apllication without registering.
so we make hashing(bcrypt) to all users passwords, 
to covering your database from different attacks,
like them how try to access user data.
so we covered every useres password,
with this statment(BCrypt.checkpw(pw,userPass)).
this jbcypt change the user-password to three statment(header,payload,signtuer),
and there is a dot between them, so it dosnot come back like a string.
so difficult to all kinds of hackers tekniq  at find it. 
**the other solve problem in this project:**
 it is when project API send requests to another apis, how we fetches data quickly.
 so i am use the run Parallel method to fetches data from all apis in the same time.
so we define new executoer to fix thread pool, then we make  list of all URLs,
 so we make for eatch loop throw the list og we called the method doWork,
to disply all ditailes like behavior, and ouer fecheching from all other APIs done queckly,
than normal secuaintial methods.


