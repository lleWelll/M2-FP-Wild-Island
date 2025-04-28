# Wild Island
Wild Island is a console simulation where an island with a random landscape is generated and populated by plants and animals.
The program uses multithreading to create a living, dynamic environment where processes happen simultaneously.

## Core Ideas:
- Island Generation: The landscape is created randomly.
- Animal Population: Animals are spawned at the start across the island.
- Plant Growth: Vegetation is generated and keeps growing over time.
- Animal Life: Animals move, eat, reproduce, and interact with their environment.
- Statistics Collection: Real-time data about the island's population is gathered and updated.

## How to Run
Clone the repository:
`git clone https://github.com/lleWelll/M2-FP-Wild-Island.git`

Go to project folder:
`cd M2-FP-Wild-Island`

Compile project:
`javac -d "path-where-to-save-compiled-files" $(find ./src -name "*.java")`

Run:
`java -cp out Main`
