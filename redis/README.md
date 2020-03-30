# Redis
Redis is an open source (BSD licensed), in-memory **data structure store**, used as a database, cache and message broker. It supports data structures such as strings, hashes, lists, sets, sorted sets with range queries, bitmaps, hyperloglogs, geospatial indexes with radius queries and streams. Redis has built-in replication, Lua scripting, LRU eviction, transactions and different levels of on-disk persistence, and provides high availability via **Redis Sentinel** and automatic partitioning with **Redis Cluster**

The overview of application developed as follows

![Architecture](/img/redis-architecture.png)

1. Used `Redis Sentinel` to create several replicas
2. Programs can read data from replicas
3. And write on master

## Advantage of this application

1. Every instance can talk to one replica/slave
2. No memory/space loss or more consumption
3. Reduce load on Master, to read 100 of data by different program through master can increase load that can be reduce by this.
4. In any case if `Master` get down or fails, slave can be consider as Master
5. Data synchronization happens internally between slaves

## Install & Setup Redis

1. We can download Redis from - https://github.com/MicrosoftArchive/redis/releases
2. Download the Zip file and Unzip it
3. Start the Redis Server 
    
        redis-server.exe

    ![Redis Server](/img/redis-server.png)
4. Now to use Redis start `Redis CLI`

        redis-cli.exe
    
    ![Redis Server](/img/redis-cli.png)
5. To check Redis is setuped, try typing

        ping
    ![Redis Server](/img/redis-cli-ping.png)
    
## Redis Notes

https://github.com/aman7797/super-pancake/tree/master/Learn%20Redis%20And%20Utilize%20Jedis%20With%20Spring%20Data%20Redis

## Endpoint

1. To add the programmer string

    ```curl
    curl --location --request POST 'localhost:8080/progrmmer-string/' \
    --header 'Content-Type: application/json' \
    --data-raw '{"id":1,"name":"Aman","company":"Xoriant"}'
    ```

    ![Programmer Output](/img/programmer_output.png)

2. To get the Programmer string 

    ```curl
    curl --location --request GET 'localhost:8080/programmer-string/1' \
    --header 'Content-Type: application/json'

    ```

    ![Get Programmer Output](/img/get_programmer_output.png)

3. To add Programmer List

    ```curl
    curl --location --request POST 'localhost:8080/programmer-list' \
    --header 'Content-Type: application/json' \
    --data-raw '{"id":2,"name":"Manan","company":"Null"}'
    ```
    ![Get Programmer Output](/img/add_programmer_list.png)

4. To get Programmer List

    ```curl
    curl --location --request GET 'localhost:8080/programmer-list' \
    --header 'Content-Type: application/json'
    ```
    ![Get Programmer Output](/img/get_programmer_list.png)

5. To get Programmer List

    ```curl
    curl --location --request GET 'localhost:8080/programmer-list/count' \
    --header 'Content-Type: application/json'
    ```
    ![Get Programmer Output](/img/get_programmer_list_range.png)

6. To add Programmer Set

    ```curl
    curl --location --request POST 'localhost:8080/programmer-set' \
    --header 'Content-Type: application/json' \
    --data-raw '{"id":3,"name":"Aman Lalpuria","company":"Juspay"}'
    ```
    ![Get Programmer Output](/img/add_programmer_set.png)

7. To get Programmer Set
    ```curl
    curl --location --request GET 'localhost:8080/programmer-set' \
    --header 'Content-Type: application/json'
    ```
    ![Get Programmer Output](/img/get_programmer_set.png)

8. To check if the Programmer isEmpty 
    ```curl
    curl --location --request POST 'localhost:8080/programmer-set/isEmpty' \
    --header 'Content-Type: application/json' \
    --data-raw '{"id":3,"name":"Aman Lalpuria","company":"Juspay"}'
    ```
    ![Get Programmer Output](/img/isEmpty_Set.png)