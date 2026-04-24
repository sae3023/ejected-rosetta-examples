# Getting Started

Standalone Scalus example, ejected from
[scalus3/scalus](https://github.com/scalus3/scalus).

## Build

```sh
sbt compile
```

## Test

```sh
sbt test
```

## Generate a CIP-57 blueprint

```sh
sbt blueprint
```

Blueprint JSON is written to
`target/scala-3.3.7/classes/META-INF/scalus/blueprints/<Contract>.json`.

## Deploy as a reference script

Requires a Blockfrost project id and a funded wallet mnemonic on the chosen network.

```sh
sbt "deploy <ContractName> --network preview \
    --blockfrost-key <project-id> \
    --mnemonic '<24 words>'"
```

Or via environment variables:

```sh
export CARDANO_NETWORK=preview
export BLOCKFROST_API_KEY=<project-id>
export CARDANO_MNEMONIC='<24 words>'
sbt "deploy <ContractName>"
```

The contract is deployed as a reference script UTxO at the sender's own base
address; the transaction hash is printed on success.

## Pinned versions

- Scalus: `0.16.0+259-683121c7-SNAPSHOT`
- Scala:  `3.3.7`
- sbt:    `1.12.9`
