Narrative:
My first story

Scenario: test add operation
Given a calculator with value <value>
When add the number <number>
Then the result is <result>
Examples:
|value|number|result|
|1|1|2|

Scenario: test minus operation
Given a calculator with value <value>
When minus the number <number>
Then the result is <result>
Examples:
|value|number|result|
|3|1|2|

Scenario: test add operation
Given a calculator with value 10
When add the number 5
Then the result is 15

Scenario: Tabular data
Given a calculator with this values:
|a|b|c|d|
|1|2|1.2|true|