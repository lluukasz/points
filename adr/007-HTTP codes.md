# Context and Problem Statement

What status code is given for successful or unsuccessful CRUD operations?

# Decision

| Operation | Success  | Missing/Duplicate | Error |
|-----------|----------|-------------------|-------|
| Create    | 200 (OK) | 404 (duplicate)   | 400   |
| Read      | 200 (OK) | 404 (not found)   | 400   |
| Update    | 200 (OK) | 404 (not found)   | 400   |
| Delete    | 200 (OK) | 404 (not found)   | 400   |

# Drivers

The processing is synchronous so other 2xx codes are not used.

https://en.wikipedia.org/wiki/List_of_HTTP_status_codes
https://www.moesif.com/blog/technical/api-design/Which-HTTP-Status-Code-To-Use-For-Every-CRUD-App/