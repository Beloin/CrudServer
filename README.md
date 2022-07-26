# Simple CRUD Server

An application which creates a simple CRUD server using parameters in a text file.
The application should work as Plugin Managed, we should add plugins to increase the funcionalitty.

Text File Example:
``` text
# config
auth.roles ADMIN; USER
server.port 8080

media.type s3
defaults.awsId xxxxxx
defaults.awskey xxxx
defaults.awsregion sa-east-1 

defaults.database.type postgres
defaults.database.server xxx.xxx.xxx
defaults.database.password xxxxxx
defaults.database.user xxxxxx
defaults.database.database db

# Models
model name, ...(type name [lenght: int] [nullable: bool])
model user, string name 255, string password lenght:255, date birthdate, media.url photo, role role

# Resources
resource name mappedby model, ...args
resource user mappedby user, name, birthdate, photo

# DTOs
dto name mappedby model, ...args

dto user mappedby user, name, password, birthdate

# endpoints
POST /users, auth.autorization jwt, auth.roles ADMIN, paginated true, dto user, resources.mapper user
GET /users, auth.autorization jwt, auth.roles ADMIN, paginated true, resources.mapper user
```