# Hazelcast

Hazelcast is an in-memory caching mechanism provided by the spring boot. Spring boot auto-configures the Hazelcast instance if the hazelcast is available in our application’s classpath and the required configuration is available.

Hazelcast is a radical, new approach towards data that was designed from the ground up around distribution

![Architecture](/img/hazelcast-architecture.png)

The overview of application developed as follows

![Architecture](/img/project-architecture.png)


## Features of Hazelcast-

* The data is always stored in-memory (RAM) of the servers.This makes it incredibly fast.
* Multiple copies are stored in multiple machines for automatic data recovery in case of single or multiple server failures. In the event of failure, the overall cluster will not suffer any data loss.
* Major feature of Hazelcast is its masterless nature. Each node is configured to be functionally the same and operates in a peer-to-peer manner.
* The data model is object-oriented and non-relational.
* Servers can be dynamically added or removed to increase the amount of CPU and RAM.
* The data can be persisted from Hazelcast to a relational or NoSQL database.
* A Java Map API accesses the distributed key-value store.

## Dependencies

```xml
<dependency>
  <groupId>com.hazelcast</groupId>
  <artifactId>hazelcast</artifactId>
</dependency>
<dependency>
  <groupId>com.hazelcast</groupId>
  <artifactId>hazelcast-spring</artifactId>
</dependency>
```

## Create Hazelcast Member

When we start the ServerNode application, we can see the flowing text in the console which means that we create a new Hazelcast node in our JVM which will have to join the cluster.

    Members [1] {
        Member [192.168.1.105]:5701 - 899898be-b8aa-49aa-8d28-40917ccba56c this
    }
To create multiple nodes we can start the multiple instances of ServerNode application. Hazelcast will automatically create and add a new member to the cluster.

For example, if we run the ServerNode application again, we will see the following log in the console which says that there are two members in the cluster.

    Members [2] {
    Member [192.168.1.105]:5701 - 899898be-b8aa-49aa-8d28-40917ccba56c
    Member [192.168.1.105]:5702 - d6b81800-2c78-4055-8a5f-7f5b65d49f30 this
    }