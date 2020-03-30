# EhCache

Ehcache is an open source, standards-based cache that boosts performance, offloads your database, and simplifies scalability. It's the most widely-used Java-based cache because it's robust, proven, full-featured, and integrates with other popular libraries and frameworks. Ehcache scales from in-process caching, all the way to mixed in-process/out-of-process deployments with terabyte-sized caches

![Architecture](/img/hazelcast-architecture.png)

The overview of application developed as follows

![Architecture](/img/project-architecture.png)

## Setup Database
1. Download the MySQL zip
2. Unzip the downloaded file and open the command line at the unziped location, go to `bin` directory
3. To initialize the MySQL run the below mentioned command, it will create the data directory in the same folder

        mysqld  --initialize-insecure
4. To start the server 

        mysqld.exe --console

    ![MySQL Setup](/img/setup_mysql.png)
5. Done with the setup, we can start with the MySQL to start the SQL

        mysql -u root
    ![MySQL Started](/img/started_mysql.png)
6. Create database 

        CREATE DATABASE hibernate_test;
    
    ![MySQL Started](/img/create_database.png)
7. Create a table name `item`
    ```sql
    CREATE TABLE item(id int NOT NULL, name VARCHAR(20), category VARCHAR(20));
    ```
8. Add the below properties to the application.properties file..

        spring.datasource.url=jdbc:mysql://localhost:3306/hibernate_test
        spring.datasource.username=root

## Dependencies

```xml
<dependency>
	<groupId>javax.cache</groupId>
	<artifactId>cache-api</artifactId>
</dependency>
		
<dependency>
	<groupId>org.ehcache</groupId>
	<artifactId>ehcache</artifactId>
</dependency>
```

## Create Hazelcast Member

To configure EhCache create a ehcache.xml file -refer to /EhCache/src/main/resources/ehcache.xml

1. <cache alias="itemCache">
This will create cache with name `itemCache`

2. <key-type>java.lang.Object</key-type>
This will accept the `Key` of the type Object

## Endpoints

1. Get
    ```curl
    curl --location --request GET 'localhost:9080/item/1' \
    --header 'Content-Type: application/json'
    ```


2. Update Cache

    ```curl
    curl --location --request PUT 'localhost:9080/updateItem' \
    --header 'Content-Type: application/json' \
    --data-raw '{"id":1,"name":"Nokia","category":"Mobile"}'
    ```

3. Delete Single Cache

    ```curl
    curl --location --request DELETE 'localhost:9080/delete/1' \
    --header 'Content-Type: application/json'
    ```

4. Delete All Cache

    ```curl
    curl --location --request DELETE 'localhost:9080/deleteall'
    ```