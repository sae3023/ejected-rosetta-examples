# BuidlerFest 2026

Ticket registration contract deployed on Cardano mainnet for BuidlerFest 2026. Uses a beacon token counter pattern to
mint sequentially numbered ticket NFTs (TICKET0, TICKET1, ...).

## How it works

A single UTxO holds a datum with the number of tickets issued so far. Each `BuyTicket` action mints the next
TICKET{n} NFT and increments the counter. The `AdminWithdraw` action lets the admin reclaim collected ADA.

`BuidlerFest.scala` contains the off-chain transaction builders used for mainnet deployment.
