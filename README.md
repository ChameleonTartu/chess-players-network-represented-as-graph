# Graph database application on top on chess.com profile extraction

This guide will go through the process how to choose Graph database. Why to choose one vendor over the other? How can I make sure that database doesn't get obsolete in few years? Example, of chosen database on building portfolios on top of open chess.com API and how to visualize the result. The service layer itself is in Kotlin as we are Kotlin/JVM-based shop and we are interesting in JVM technologies and solving real-world cases as well as integration graph databases with Spring.

In here, we will not discuss why to choose graph database. We assume that you are there because you know you need a change or you know that graph database is capable of solving your problem.


## How to choose Graph database?

We will make educated decisions by searching for the top graph databases, and range them by open-source/proprietary source, stars on Github, number of questions on StackOverflow.


Name | Open-source | Repository| Stars | SO questions\*
------ | ------- | ---- | ---- | -----
ArangoDB | Yes | [GtiHub](https://github.com/arangodb/arangodb) | 10730 | [3692](https://stackoverflow.com/search?page=247&tab=Relevance&q=arangodb)
Neo4J | Yes | [GitHub](https://github.com/neo4j/neo4j) | 8535 | [47116](https://stackoverflow.com/search?q=neo4j)
OrientDB | Yes | [GitHub](https://github.com/orientechnologies/orientdb) | 4253 | [5898](https://stackoverflow.com/search?q=orientdb)
AllegroGraph | No | - | - | [234](https://stackoverflow.com/search?tab=newest&q=AllegroGraph)
Ontotext GraphDB | No | - | - | [1898](https://stackoverflow.com/search?q=graphdb)
Titan | Yes | [GitHub](https://github.com/thinkaurelius/titan) | 5100 | [3718](https://stackoverflow.com/search?q=Titan)
Stardog | No | - | - | [277](https://stackoverflow.com/search?q=Stardog)
Graph Story | No | - | - | [?](https://stackoverflow.com/search?q=Graph+story)
Dgraph | Yes | [GitHub](https://github.com/dgraph-io/dgraph) | 14700 | [295](https://stackoverflow.com/search?q=dgraph)
Blazegraph | Yes | [GitHub](https://github.com/blazegraph/database) | 554 | [268](https://stackoverflow.com/search?q=Blazegraph)
Oracle NoSQL Database | ? | ? | ? | [478](https://stackoverflow.com/search?q=Oracle+NoSQL+Database)
Oracle Spatial and Graph | No | - | - | [14](https://stackoverflow.com/search?q=Oracle+Spatial+and+Graph)
HyperGraphDB | Yes | [GitHub](https://github.com/hypergraphdb/hypergraphdb) | 146 | [42](https://stackoverflow.com/search?q=HyperGraphDB)
Sqrrl Enterprise | Yes | [GitHub](https://github.com/cmu-db/dbdb.io) | 174 | [2](https://stackoverflow.com/search?q=dbdb.io)
Aster | ? | ? | ? | [445](https://stackoverflow.com/search?q=Aster)
Sparksee | No | - | - | [17](https://stackoverflow.com/search?q=Sparksee)
VelocityGraph | Yes | [GitHub](https://github.com/VelocityDB/VelocityDB) | 62 | [2](https://stackoverflow.com/search?q=VelocityGraph)
IBM System G Native Store | No | - | - | [2](https://stackoverflow.com/search?q=IBM+System+G+Native+Store)
Graph Engine | Yes | [GitHub](https://github.com/Microsoft/GraphEngine) | 1900 | [3066](https://stackoverflow.com/search?q=Graph+Engine)
ThingSpan | No | - | - | [0](https://stackoverflow.com/search?q=ThingSpan)
Bitsy | Yes | [GitHub](https://github.com/lambdazen/bitsy) | 97 | [60](https://stackoverflow.com/search?q=Bitsy)
Apache Giraph | Yes | [GitHub](https://github.com/apache/giraph) | 567 | [141](https://stackoverflow.com/search?q=Apache+Giraph)
FlockDB | Yes | [GitHub](https://github.com/twitter-archive/flockdb) | 3300 | [54](https://stackoverflow.com/search?tab=newest&q=FlockDB)
InfoGrid | Yes | [GitHub](https://github.com/infogrid-org/infogrid) | 0 | [79](https://stackoverflow.com/search?q=InfoGrid)
grapholytic | No | - | - | [1](https://stackoverflow.com/search?q=grapholytic)
Weaver | ? | ? | ? | [1528](https://stackoverflow.com/search?q=weaver)
AnzoGraphDB | No | -  | - | [1](https://stackoverflow.com/search?q=AnzoGraphDB)
RedisGraph | Yes | [GitHub](https://github.com/RedisGraph/RedisGraph) | 1200 | [126](https://stackoverflow.com/search?q=redisgraph)
DataStax | Yes | [GitHub](https://github.com/DataStax) | ? | [8920](https://stackoverflow.com/search?q=DataStax)
MarkLogic | Yes | [GitHub](https://github.com/marklogic/marklogic-data-hub) | 112 | [7900](https://stackoverflow.com/search?q=marklogic)
TigerGraph | No | - | - | [21](https://stackoverflow.com/search?q=TigerGraph)
GraphDB Lite | Yes | [GitHub](https://github.com/CodyKochmann/graphdb) | 118 | [8](https://stackoverflow.com/search?tab=newest&q=GraphDB%20Lite)
MapGraph | Yes | [GitHub](https://github.com/stuartsierra/mapgraph) | 61 | [19](https://stackoverflow.com/search?q=MapGraph)
BrightstarDB | Yes | [GitHub](https://github.com/BrightstarDB/BrightstarDB) | 421 | [22](https://stackoverflow.com/search?q=BrightstarDB)
Cayley | Yes | [GitHub](https://github.com/cayleygraph/cayley) | 13700 | [124](https://stackoverflow.com/search?q=Cayley)
WhiteDB | Yes | [GitHub](https://github.com/priitj/whitedb) | 538 | [4](https://stackoverflow.com/search?q=WhiteDB)
Orly | Yes | [GitHub](https://github.com/orlyatomics/orly) | 6 | [?](https://stackoverflow.com/search?q=Orly)
Sones GraphDB | Yes | [GitHub](https://github.com/sones/sones) | 202 | [5](https://stackoverflow.com/search?q=Sones+GraphDB)
Filament | Yes | [GitHub](https://github.com/google/filament) | 10400 | [355](https://stackoverflow.com/search?q=Filament)
AgensGraph | Yes | [GitHub](https://github.com/bitnine-oss/agensgraph) | 1000 | [155](https://stackoverflow.com/search?q=agensgraph)
Amazon Neptune | No | - | - | [139](https://stackoverflow.com/search?q=Amazon+Neptune)
Nebula | Yes | [GitHub](https://github.com/vesoft-inc/nebula) | 5600 | [752](https://stackoverflow.com/search?q=Nebula)
Janusgraph | Yes | [GitHub](https://github.com/JanusGraph/janusgraph) | 3800 | [1358](https://stackoverflow.com/search?q=janusgraph)
Grakn | Yes | [GitHub](https://github.com/graknlabs/grakn) | 2500 | [257](https://stackoverflow.com/search?q=grakn)
Gaffer | Yes | [GitHub](https://github.com/gchq/Gaffer) | 1600 | [53](https://stackoverflow.com/search?q=gaffer)
Fortune | Yes | [GitHub](https://github.com/fortunejs/fortune) | 1400 | ?
Aleph | Yes | [GitHub](https://github.com/alephdata/aleph) | 1400 | [295](https://stackoverflow.com/search?q=aleph)
Tinkerpop | Yes | [GitHub](https://github.com/apache/tinkerpop) | 1300 | [2490](https://stackoverflow.com/search?q=tinkerpop)

Why some databases were disqualified?

- Last commit: Titan (\~5 years ago), HyperGraphDB (\~3 years ago), FlockDB (\~9 years ago), InfoGrid (\~3 years ago), MapGraph (\~4 years ago)

- Proprietary: AllegroGraph, Ontotext GraphDB, Stardog, Graph Story, Amazon Neptune, IBM System G Native Store

- Unlear status: [Oracle NoSQL](https://github.com/oracle-nosql), [Weaver](https://github.com/weaverplatform/weaver-database-graphdb)


\*SO = [StackOverflow](https://stackoverflow.com/)

Articles with range of databases: [Predictive analytics today](https://www.predictiveanalyticstoday.com/top-graph-databases/), [Solutions reviews](https://solutionsreview.com/data-management/the-best-graph-databases-to-consider-in-2020/), 
[Predictive analytics today, top free graph databases](https://www.predictiveanalyticstoday.com/top-free-graph-databases/), [Info world](https://www.infoworld.com/article/3408787/the-best-graph-databases.html), [Awesome open-source](https://awesomeopensource.com/projects/graph-database), [Dzone, top 5 graph databases](https://dzone.com/articles/top-5-graph-databases), [Stackoverflow Survey 2020](https://insights.stackoverflow.com/survey/2020#technology-databases-all-respondents4).


Three the most promising contenders are ArrangoDB, Neo4J and Dgraph. All of them are great choices but on preliminary tests we discovered that Dgraph is unstable under load and ArrangoDB has slightly less active community in StackOverflow, so by total points = stars + so questions we will choose Neo4J.


The code will follow shortly...

