
---
name: architecture
description: Analyse the codebase and generate a detailed class architecture document with relationships and Mermaid diagrams.
argument-hint: "[optional module or folder name]"
agent: agent
---

# Task: Generate Codebase Architecture Documentation

Act as a Senior Software Architect conducting a detailed codebase analysis.

Your objective is to analyse the existing source code and generate a comprehensive `ARCHITECTURE.md` file at the root of the workspace.

If the user provides a module or folder name after the command, restrict the primary analysis to that scope while including relevant dependencies outside it.

## 1. Codebase Analysis

Before generating documentation:

- Explore the project directory and understand its structure.
- Identify all important classes, interfaces, abstract classes, enums and records.
- Read the actual source code instead of relying only on filenames.
- Identify each class's responsibility and its role in the system.
- Identify constructors, important fields, methods and dependencies.
- Trace how objects are created and how dependencies are injected.
- Identify the entry points and execution flow.
- Identify design patterns used in the implementation.
- Understand how different components communicate with each other.

Do not invent classes, methods, relationships or design patterns.

## 2. Class Relationships

Identify and document the following relationships wherever applicable:

- Inheritance (IS-A)
- Interface implementation
- Composition (strong HAS-A)
- Aggregation (weak HAS-A)
- Association
- Dependency / usage
- Factory and object creation relationships

For every relationship, explain:
- Which class is connected to which class.
- The type of relationship.
- Why the relationship exists.
- Whether the dependency is direct or indirect.

Distinguish actual relationships found in code from architectural assumptions.

## 3. Class Responsibility Analysis

For every important class, document:

- Class name
- Responsibility
- Important attributes / fields
- Important methods
- Dependencies
- Collaborating classes
- Why the class exists in the architecture

Pay particular attention to Single Responsibility Principle and separation of concerns.

Identify potential:
- Tightly coupled classes
- Circular dependencies
- God classes
- Unnecessary dependencies
- Violations of SOLID principles

Do not suggest changes unless there is a concrete reason in the code.

## 4. Architecture Diagrams

Use Mermaid diagrams so that the documentation can be rendered directly in VS Code and GitHub.

Generate:

### A. Class Diagram
Use Mermaid `classDiagram`.

Include:
- Important classes and interfaces.
- Inheritance and implementation.
- Composition and aggregation.
- Associations and dependencies.
- Important relationship labels.

### B. Component / Layer Diagram

Show the architectural layers and how they interact.

For example:
- Controller / Entry Point
- Service
- Domain / Model
- Repository
- Infrastructure
- External Services

Only include layers that actually exist.

### C. Execution Flow

Show the sequence of interactions between important classes for the main application workflow.

Use Mermaid `sequenceDiagram` where appropriate.

## 5. Architecture Explanation

Document:

1. Project overview.
2. Overall architecture.
3. Directory structure.
4. Important classes and their responsibilities.
5. Relationships between classes.
6. Dependency flow.
7. Object creation and dependency injection.
8. Main execution flow.
9. Design patterns used.
10. SOLID principles and separation of concerns.
11. Potential architectural issues and improvement opportunities.

## 6. Output Requirements

Create or update:

`ARCHITECTURE.md`

Requirements:

- Use clean Markdown formatting.
- Use Mermaid diagrams instead of ASCII diagrams.
- Keep diagrams readable and avoid unnecessarily large diagrams.
- Group related classes into logical sections.
- Use consistent terminology throughout.
- Explain WHY classes interact, not just THAT they interact.
- Link important classes to their source files using relative Markdown links.
- Avoid documenting trivial getters, setters and boilerplate methods.
- Include actual method names where they help explain interactions.
- Do not duplicate the same information in multiple sections.

## 7. Accuracy Rules

These rules are mandatory:

1. Never assume a relationship based on class names alone.
2. Verify relationships by reading constructors, fields, method calls and actual implementations.
3. Do not invent missing architectural layers.
4. Do not claim a design pattern is used unless the implementation supports it.
5. Clearly mark uncertain or inferred relationships.
6. Do not modify application source code.
7. Do not generate unrelated documentation.
8. Do not omit important classes just to keep the diagram small. Split large diagrams into logical groups instead.

## 8. Final Execution

After completing the analysis:

1. Generate `ARCHITECTURE.md` at the workspace root.
2. Ensure all Mermaid blocks are syntactically valid.
3. Cross-check class names and relationships against the source code.
4. Report the generated file path.
5. Provide a short summary of the architecture and any important findings.

The primary deliverable must be the actual `ARCHITECTURE.md` file, not just an explanation in chat.


## 9. GitHub-Ready Documentation (MANDATORY)

The generated ARCHITECTURE.md will be committed to a public GitHub repository. It must be understandable and visually rendered directly on GitHub.

### Mermaid Diagrams

Use GitHub-supported Mermaid syntax.

Generate the following diagrams wherever applicable:

1. **Class Diagram (`classDiagram`)**
   - All important classes and interfaces.
   - Inheritance and interface implementation.
   - Composition and aggregation.
   - Associations and dependencies.
   - Relationship labels.

2. **Component Diagram (`flowchart LR`)**
   - Architectural layers.
   - Components and their responsibilities.
   - Communication and dependency direction.

3. **Sequence Diagram (`sequenceDiagram`)**
   - Important application workflows.
   - Method interactions between classes.
   - Request and response flow.

### Diagram Quality

- Never use ASCII diagrams.
- Never use screenshots of diagrams.
- Never require external tools to view diagrams.
- Use Mermaid code blocks so GitHub renders them natively.
- Split large diagrams into smaller logical diagrams.
- Avoid overlapping or unnecessarily complicated relationships.
- Ensure all class names match actual source code.
- Validate Mermaid syntax before saving.

### GitHub Navigation

At the beginning of ARCHITECTURE.md, include:

1. Project name and short overview.
2. Table of contents with working Markdown anchors.
3. Links to important source files using relative paths.
4. Clear sections for class architecture, relationships and execution flows.

### Public Repository Safety

- Never include credentials, API keys, passwords or tokens.
- Never expose private environment variables.
- Do not expose confidential infrastructure details.
- Document only information appropriate for public repository access.

### README Integration

If a README.md already exists:

- Add an Architecture section near the top.
- Add a relative link to ARCHITECTURE.md.
- Preserve all existing README content.
- Do not duplicate the entire architecture documentation in README.md.

The README section should look like:

## Architecture

Explore the complete system design, class relationships,
component interactions and execution flows.

[View Architecture Documentation](ARCHITECTURE.md)

If README.md does not exist, do not create one unless explicitly requested.

### Final Verification

Before finishing:

1. Verify all referenced source files exist.
2. Verify all Mermaid code blocks are properly closed.
3. Check that class relationships match the implementation.
4. Check all internal Markdown links.
5. Confirm ARCHITECTURE.md is located at the repository root.
6. Confirm README.md links to ARCHITECTURE.md.
7. Report all files created or modified.

