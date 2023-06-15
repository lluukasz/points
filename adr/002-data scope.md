# Context and Problem Statement

Given the functional requirements (calculate points and make aggregated reports), 
what source information we need to have in the service? 

# Decision
The following data subset is stored in the service:
* reference to the externally stored purchase information,
* customer id
* purchase date 
* amount (price)

The external reference is not used by the service for eny purpose
other than identifying the record for the CRUD operations.

Customer ID is needed to group and filter records for a report on customer's request.

Purchase date is used to identify the month of the purchase.

# Other considerations

### Transaction
Whole transaction information or just a reference to it. - This would be too much data (risk of PII), and reaching to an external system for details adds complexity to the system and is unnecessary. 

### Date/Month
Keep only the month number (as required).
It is easier to pass the date, and also we are flexible in
case the requirement changes for instance to weeks or fortnights.

### Amount/Points
only keep points earned in a transaction. 
The original amount is kept in case of the change of the calculations and also for the possibility to validate the calculated points.

### Anonymization

Customer ID is not anonymized in the service because it will be used 
to access the customer's report. It can be though anonymized 
by the sales system and the real customer id shall never be shared with the service.
