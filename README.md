# OFFENSE MANAGEMENT SYSTEM

## Brief Description
    
Offense Management Systems is a Java app for administrators to file offenses, approve/reject user accounts, and validate appeals. Users can view their offense records, file appeals, and check pending excuses. The system ensures secure login and registration.

# Features
## Details
### _[Login/Registration]_
  * Account Authentication
  * Register

### _[Administrator]_
  * Can file an offense against the user.
             > Add the name of the offense
             > Choose Severity (minor, major, serious)
             > Date committed and date reported
             > Add the name of an individual who reported the offense 
             > Add the users ID

  * Approve/Reject user created account
    > Before the user can officially create his/her account, the admin needs to approve it.


### _[User]_
  * View offense severity, and filing status(filed/not filed)
  * Can file appeal or provide explanation for their offenses
  * Can view pending excuses.
  * Validate appeals or excuses


# Operation
@package offense.management

To run this program in cmd, type "java offense.management.Main"

#Run as ADMINISTRATOR
> username - ADMIN
> password - ADMIN123
