# Context and Problem Statement

It is required to implement CRUD operations with the REST service.

How do REST verbs map to CRUD?

# Decision

| CRUD	   | HTTP   |
|---------|--------|
| CREATE  | POST   |
| READ	   | GET    |
| UPDATE  | PUT    |
| DELETE  | DELETE |

PATCH and OPTIONS are not implemented

# Drivers
https://www.atatus.com/blog/http-status-code-to-use-for-crud-operation/

Alternative approach, which is not implemented here:
https://nordicapis.com/crud-vs-rest-whats-the-difference/ 
or https://en.wikipedia.org/wiki/Create,_read,_update_and_delete