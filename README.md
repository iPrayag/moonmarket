<b>Moon Market</b>

Moon market is for those who want to buy land in the moon. 

<b>To Clone or Contribute </b>

`$ git clone https://github.com/iPrayag/MoonMarket.git`

`$ cd MoonMarket`

<b>install dependencies</b>

`$ mvn install -e`

<b>create database</b>

`mysql> create schema Gwitter`

<b>vi db properties</b>

`vi src/main/resources/props/default.props`


<b>run app at default port 8080</b>

`$ mvn jetty:run`

or run at desired port [Reference : Lift default port](https://groups.google.com/d/msg/liftweb/Bj8xmsctGFk/0bA3xx6QIcwJ)

`$ mvn -Djetty.port=9090 clean jetty:run`



[MORE AT A BLOG](http://prayag-waves.blogspot.com/2012/10/connecting-liftweb-to-mysql.html)
