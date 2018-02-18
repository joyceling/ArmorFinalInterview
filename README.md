# Armor Final Interview

## Configuration

In order to run this application, create an 'application.properties' file:

Run in terminal:
```
cp src/main/resources/example.properties src/main/resources/application.properties

```

## User Story: As a Customer, I want to submit a ticket so that I can get assistance from Support.

#### Requirements:
- ##### Create form to capture the following information:
    - First and Last Name (required)
    - Email Address (required, valid email address)
    - Subject (required)
    - Priority (optional)
        1. High
        2. Medium
        3. Low
    - Description of Issue (required)

- ##### Notify Customer if they did not provide required information or if it's invalid.

- ##### Once the form is submitted successfully, provide a confirmation message that includes expected response time from Support based on Priority.

    - High: Within 4 hours
    - Medium: Within 24 hours
    - Low: Within 48 hours

- ##### Persist all information to database including the date the ticket was submitted and capture the status of the ticket as "New".

- ##### Persist a field for ResponseTimeAlert that is calculated based on the submission time and the expected response time.
        Example: ResponseTimeAlert for a High priority = Current Time + 4 Hours

## Acceptance Criteria:

- Given a Customer is presented with a form to submit a ticket
    - When they submit the form:
        - Notify the Customer if errors exist/occur and do not persist the ticket to the database.
        - If no errors exist, the ticket information will be stored in the database and the Customer will know when to expect a response from Support.

