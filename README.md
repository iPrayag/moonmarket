Moon Market
------------

Moon market is for those who want to buy land in the moon. 

<b>To Clone or Contribute </b>

```
$ git clone https://github.com/iPrayag/MoonMarket.git
$ cd MoonMarket
```

install dependencies
------------------------

`$ mvn install -e`

The dependencies are 

`scala-compiler 2.9.1`

`lift-mapper_2.9.1`


create database
-------------------

`mysql> create schema Gwitter`

<b>vi db properties</b>

`vi src/main/resources/props/default.props`


run app
------------------------------------

`$ mvn jetty:run`

or run at desired port [Reference : Lift default port](https://groups.google.com/d/msg/liftweb/Bj8xmsctGFk/0bA3xx6QIcwJ)

`$ mvn -Djetty.port=9090 clean jetty:run`



<b>MORE AT A BLOG</b>

1- [Hacking Liftweb with mvn](http://prayag-waves.blogspot.com/2012/10/getting-started-with-liftweb-framework.html)

2- [Connecting Liftweb to MySQL](http://prayag-waves.blogspot.com/2012/10/connecting-liftweb-to-mysql.html)
