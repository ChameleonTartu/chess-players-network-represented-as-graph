### Development

We run `Neo4J` in a development mode, so no auth required:


    docker run \
    --publish=7474:7474 --publish=7687:7687 \
    --volume=$HOME/neo4j/data:/data \
    --env=NEO4J_AUTH=none \
    neo4j


### Application

Application has a single endpoint:

`/player/opponent/{nickname}?level={level}`

where `nickname` from chess.com such as

- `hickaru` - [Hikaru Nakamura](https://ratings.fide.com/profile/2016192)
- `MagnusCarlsen` - [Magnus Carlsen](https://ratings.fide.com/profile/1503014)

`level` is depth of the graph of players to retrieve,
- 0 - all players `nickname` played against
- 1 - all players opponents of `nickname` played against

### Limitations

- Requests are synchronous, so you may take some time until all retrievals end
- It was tested only on Neo4J Community Edition and as a result you cannot populate a large database (we reached ~80k nodes and ~100k relationships)
- It is buggy, so player A can be opponent for a player B and otherwise. Ideally, the aim was to have single relationship between A and B
- The modeling is minimalistic, there are no weights on relationships and other type of nodes
- You can catch [`Neo.TransientError.General.OutOfMemoryError`](https://stackoverflow.com/questions/44048898/can-heap-size-be-increased-on-neo4j-community-edition) due to CE version
