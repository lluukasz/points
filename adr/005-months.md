# Context and Problem Statement

UTC or local time? How many Timezones? DST?
A transaction must be assigned to a month based on the transaction timestamp.
It can be an issue for the 24/7 retailers. It shall be straightforward for regular day-time retailers.

# Decision

The service assumes one timezone and local time - month can be directly extracted from the date object.
Implement a transformer (date to month) just in case.

# Drivers

Transaction time provided by the sales system is local to the store, 
so the time is before or after midnight as per store's working schedule 
and counts towards the specified day.
 