# Context and Problem Statement

The service needs to generate the total (final report) and customer reports based on the purchase transactions.

# Decision

Only persist the purchase information. No need to persist the derived data 
(calculated points or cumulative points per customer or totals).
The derived data can be easily calculated on the fly when needed

# Consequences

Points need to be calculated when needed.
Customer reports may be slow/delayed.
Total/final report may be slow, but it is run occasionally.

# Other considerations
To improve customer report latency it is possible to keep the derived data in memory for quick access 
and update it on each CRUD operation. The cold start of the service can load purchase information 
calculate all derived information and cache it. 
However, this non-functional requirement is not set so it would be a premature optimization. 