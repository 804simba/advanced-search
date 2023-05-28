## Criteria
By writing a `Criteria` for a domain class, you are defining the `WHERE` clause for your query;
Which is to say, you can specify conditions such as equality, inequality, comparison, and other operations to narrow down
the results based on a certain criteria.

For example, let's say you have an entity called "Product" with attributes like "name," "price," and "category." Using the criteria API, you can define conditions like "name equals 'Apple'," "price greater than 50," or "category in ['Electronics', 'Appliances']."

These criterias act as predicates and determine whether a particular entity should be included in the query results;
The API provides methods to help build these customizable queries for your domain class based on the conditions you specify at runtime.


## Specification
This is another interface that is built on Criteria API, that allows developers
to build atomic predicates and combine these predicates together to build complex
dynamic queries.
### How to use this interface:
- Create a class that implements the Specification interface.
- Inside the `toPredicate` method, implement different reusable predicates depending on the on the search operation.
    - `filterKey`: It represents the property of the entity that is being searched.
    - `value`: It represents the actual value or pattern that is used for the search.
    - `operation`: It represents the type of search operation to be performed and defines how the search should be conducted.