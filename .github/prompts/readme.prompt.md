---
name: readme
description: Analyze the project and create or update a recruiter-friendly README.md that explains its purpose, implementation status, features and setup.
argument-hint: "[optional focus or section]"
agent: agent
---

# Role
Act as a Senior Software Engineer and Technical Documentation Writer.

# Objective
Analyze the existing repository and create or update the root README.md.

The README must help recruiters, hiring managers and developers
quickly understand:
- What the project is about.
- What problem it solves.
- How it is designed and implemented.
- What is already implemented.
- What is currently under development.
- What is planned next.

# 1. Understand the Project
Before writing:
- Explore the repository structure.
- Read the source code and existing documentation.
- Identify the language, frameworks and tools.
- Understand the actual functionality implemented.
- Identify important design patterns and engineering concepts.
- Inspect tests and build configuration.
- Review the existing README, if present.

Do not assume features exist just because they are planned
or mentioned in comments.

# 2. README Structure

Create a professional README with these sections:

## Project Overview
Explain what the project is, its purpose and the problem it solves.

## Current Development Status
Clearly state whether the project is:
- Under development
- Partially implemented
- Feature complete

Be honest and derive this from the actual codebase.

## Features
Separate features into:
- Implemented
- In Progress
- Planned

Never present planned features as completed.

## Tech Stack
Mention only technologies actually used in the project.

## Design and Engineering Concepts
Explain relevant concepts such as:
- SOLID principles
- Separation of concerns
- Design patterns
- Interfaces and abstraction
- Dependency management
- Concurrency and thread safety

Only include concepts supported by the implementation.

## Architecture
Provide a link to ARCHITECTURE.md if it exists.

## Project Structure
Explain the important directories and packages.

## Getting Started
Provide accurate setup, build and execution instructions
based on the actual project configuration.

## Future Improvements
List meaningful features and improvements that are not
yet implemented.

# 3. Recruiter-Friendly Presentation
- Keep the introduction concise and clear.
- Use professional Markdown formatting.
- Use tables or checklists where useful.
- Highlight engineering decisions, not just feature names.
- Make the current development status visible near the top.
- Avoid exaggerated claims and marketing language.
- Do not claim production readiness unless justified.

# 4. Accuracy Rules
- Inspect the source code before documenting features.
- Never invent functionality, technologies or test results.
- Clearly distinguish implemented, in-progress and planned work.
- Do not modify application source code.
- Preserve useful existing README content where appropriate.

# 5. Final Verification
- Verify commands and setup instructions.
- Verify links to documentation and source files.
- Ensure the development status is accurate.
- Ensure the README reflects the current repository state.

Create or update README.md in the repository root.
Finally, summarize what was documented and any missing
information that requires clarification.