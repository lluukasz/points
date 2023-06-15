# Context and Problem Statement

What system owns the purchase transactions information?

# Decision

The loyalty programme system isn't the system of records for the purchase or customers.
The service only holds a subset of the information (see ADR 002).

# Anticipated Outcome

The external reference is the foreign key of a purchase transaction, and it can be used by the sales system to manipulate purchase records in the loyalty programme service.
