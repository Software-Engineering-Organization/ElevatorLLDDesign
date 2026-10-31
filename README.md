# ElevatorLLD

A Java low-level design exercise for modeling elevator requests, assignment rules, and destination queues. It explores how a controller can delegate elevator selection to a strategy while elevator entities maintain their own state and queues. This is a prototype, not a complete or production-ready elevator simulator.

**Development status: Under development**

## Project Overview

The project models parts of a multi-elevator system: an elevator can accept an internal destination request, and a separate controller/strategy path can assign an external request based on elevator direction or idle state. The current `Main` demonstrates two elevator threads and internal requests; it does not assemble or run the external-request assignment path.

## Current Development Status

The codebase is partially implemented. It contains domain entities, direction-aware queue insertion, an elevator-assignment strategy, and a basic threaded runtime demonstration. Elevator movement, queue processing, full request integration, and automated tests are not implemented or configured.

## Features

### Implemented

- `Elevator` stores `UP`, `DOWN`, or `IDLE` state and uses separate `PriorityBlockingQueue` instances for up- and down-direction destinations.
- `InternalButton` chooses a destination queue based on the elevator state and current floor.
- `ElevatorController` delegates external request assignment through the `ElevatorRequestStratergy` interface.
- `SimpleLiftAssignmentStratergy` checks for a same-direction elevator, then an idle elevator, and adds the request floor to a queue.
- `Main` creates two elevator instances, submits internal destinations, and starts one Java thread per elevator.

The external-request classes and logic exist, but `Main` does not instantiate or connect them. The elevator worker currently prints its elevator number and floor once per second; it does not move, consume queued destinations, or update state.

### In Progress

No explicit in-progress work or project roadmap was found in the repository.

### Planned / Potential Next Steps

These are reasonable follow-ups based on missing functionality, not a committed project roadmap:

- Implement elevator movement and destination-queue processing.
- Connect external floor requests to a constructed controller and elevator fleet.
- Replace the controller's indefinite busy-wait retry loop with a bounded or event-driven policy.
- Define lifecycle and synchronization for elevator state shared with worker threads.
- Add automated tests and a repeatable build configuration.
- Correct the Dockerfile's `javac` command to include the source path.

## Tech Stack

- Java 21 (the Docker base image is Eclipse Temurin 21; the source also compiles with JDK 21).
- Java standard library, including `Thread`, `Runnable`, and `PriorityBlockingQueue`.
- A Dockerfile is included, though its current compilation command needs the source-path correction noted below.

## Design and Engineering Concepts

- **Strategy pattern:** `ElevatorRequestStratergy` abstracts assignment policy, and `SimpleLiftAssignmentStratergy` provides one implementation.
- **Separation of concerns:** request assignment is placed in the controller/strategy path, while elevator state and queue selection are represented by entity classes and buttons.
- **Interface-based dependency:** `ElevatorController` receives an `ElevatorRequestStratergy`, keeping its assignment contract independent of a particular strategy implementation. The current `Main` does not construct this graph.
- **Concurrency:** `Elevator` implements `Runnable`, and `Main` starts separate threads. Its destination queues use `PriorityBlockingQueue`, a thread-safe queue implementation; this does not make the elevator's other fields or the whole system thread-safe. The current worker does not process those queues.

## Architecture

See [ARCHITECTURE.md](ARCHITECTURE.md) for class relationships, component views, request flows, and implementation limitations.

## Project Structure

```text
src/
├── Main.java                         # Creates elevators, queues internal requests, starts threads
├── Controller/
│   └── ElevatorController.java       # Delegates external request assignment
├── Entities/
│   ├── Building.java                 # Holds a list of floors
│   ├── Elevator.java                 # Elevator state, queues, and Runnable loop
│   ├── ExternalButton.java            # Forwards an external request to the controller
│   ├── Floor.java                     # Floor number and external button reference
│   ├── InternalButton.java            # Chooses an elevator destination queue
│   └── State.java                     # UP, DOWN, IDLE enum
├── Interfaces/
│   └── ElevatorRequestStratergy.java  # Assignment strategy contract
├── Request/
│   └── UserRequest.java               # Requested floor and direction
└── Stratergies/
    └── SimpleLiftAssignmentStratergy.java # Direction/idle assignment implementation
```

## Getting Started

### Requirements

- JDK 21 or compatible.
- No Maven or Gradle build file is present.

### Compile and Run

From the repository root, in PowerShell or a shell with `javac` and `java` on `PATH`:

```powershell
javac -sourcepath src -d out src/Main.java
java -cp out Main
```

The demo starts two worker threads that continue printing their current floor about once per second. Stop it with `Ctrl+C`. The requested internal destinations are queued, but the worker loop does not move the elevators or process those queues.

### Docker

A Dockerfile is present, but its current command (`javac -d out src/Main.java`) fails to locate packaged sources such as `Entities.Elevator`. The equivalent local compilation succeeds when `src` is supplied as the source path, as shown above. The Docker build was not verified because a Docker daemon was unavailable in the validation environment.

## Future Improvements

- Implement floor-by-floor movement and dispatch from the two priority queues.
- Wire the external button, request, controller, strategy, and elevator fleet into the runnable application.
- Handle unavailable elevators without busy-waiting indefinitely.
- Add concurrency-safe state management and a clean shutdown mechanism for elevator threads.
- Add unit tests for queue selection and assignment behavior.
- Fix and verify the Docker build, and consider adding a standard Java build tool if the project grows.
