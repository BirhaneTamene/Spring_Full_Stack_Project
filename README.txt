Configurations: - Database name = blur
                         username = root
                         password = root
                - RabbitMQ server: username = guest  password = guest

1) Bookstore_REST: exposes the api to URIs. here down are some examples ...
               - http://localhost:8080/Bookstore_REST/customers 
               - http://localhost:8080/Bookstore_REST/customers/1  
               - http://localhost:8080/Bookstore_REST/products
               - http://localhost:8080/Bookstore_REST/orders

2) Bookstore_Domain: client application with AOP(logging) and role based authorization
                - RUN edu.mum.main.Main  
                - ADMIN : userName = Bire
                          password = Bire
                - USER : userName = Ujjwol
                         password = Ujjwol

3) Bookstore_Messaging: A PTP producer-consumer messaging application which produces orders from customers to a RabbitMQ server (orderingQueue) and a consumer which listens to orders on the queue. 
                  - RUN edu.mum.main.Main to see a demo of the messaging

4) Bookstore_Eai: a warehouse application listening to orders on orderingQueue which will return a confirmation e-mail to the customer.
Note: it have some errors related to a conflict with listening on the orderingQueue, we tried this application by listening to other queue and it works perfect, But not with the queue we want it to listen to.

5) Bookstore_Batch: A batch processing application which fetches all the list of orders from database daily and creates a daily transaction report on how many orders are made and how much the total sales amount is. And finally commits the report back to the database on a daily transaction table.



