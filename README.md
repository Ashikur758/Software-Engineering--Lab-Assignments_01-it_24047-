# SEPM Lab Assignments

Welcome to my **Software Engineering and Project Management (SEPM) Lab Assignments** repository. This repository contains Java programming tasks, laboratory experiments, source codes, test cases, execution outputs, and result analysis completed as part of my academic coursework.

## About This Repository

The purpose of this repository is to practice Java programming concepts, understand software development principles, and maintain organized documentation of laboratory assignments.

## Repository Contents

| Directory/File | Description |
|---|---|
| `Lab_Thread_Counter/` | Static and non-static counter experiment using Java multithreading |
| `Ashik_Thread.java` | Java source code for the thread counter experiment |
| `README.md` | Documentation and execution instructions |
| `handwritten_code/` | Handwritten Java source code |
| `outputs/` | Actual program execution screenshots |
| `result_analysis.pdf` | Laboratory report and result analysis |

*Note: Some files and directories will be added as the laboratory work progresses.*

## Lab 01: Thread Counter

**Title:** Comparison of Static and Non-Static Variables in Multithreading Using Java

### Objectives

- Understand static and non-static variables in Java.
- Create and execute multiple threads.
- Compare thread-safe and unsynchronized counters.
- Understand race conditions and lost updates.
- Calculate absolute and percentage differences between counter values.
- Analyze the effects of increasing the number of threads.

### Technologies Used

- Java
- Java Development Kit (JDK)
- Git and GitHub
- Command Prompt / Terminal

### Test Cases

The program will be tested with the following numbers of threads:

| Test Case | Threads | Increments per Thread | Expected Count |
|---|---:|---:|---:|
| TC1 | 1 | 1,000 | 1,000 |
| TC2 | 2 | 10,000 | 20,000 |
| TC3 | 5 | 10,000 | 50,000 |
| TC4 | 10 | 50,000 | 500,000 |
| TC5 | 20 | 50,000 | 1,000,000 |
| TC6 | 50 | 50,000 | 2,500,000 |
| TC7 | 100 | 50,000 | 5,000,000 |

### How to Compile and Run

**Step 1: Compile the Java program**

```bash
javac Ashik_Thread.java
```

**Step 2: Run the thread-safe experiment**

```bash
java Ashik_Thread 10 50000 true
```

**Step 3: Run the unsynchronized experiment**

```bash
java Ashik_Thread 10 50000 false
```

### Command-Line Arguments

The program accepts three arguments:

1. `threads` — Number of threads.
2. `increments` — Number of increment operations per thread.
3. `true/false` — Selects the thread-safe or unsynchronized experiment.

For example:

```bash
java Ashik_Thread 5 10000 true
```

This command creates five threads, with each thread performing 10,000 increment operations using the thread-safe counter.

### Result Analysis

The following values will be recorded for each test case:

- Expected count
- Static counter value
- Total non-static counter value
- Absolute difference
- Percentage difference
- Execution time

The unsynchronized experiment will be repeated at least five times for each thread count. Actual outputs will be recorded without modification.

### Observation

A static variable belongs to the class and is shared by all instances. A non-static variable belongs to an individual object. In this experiment, each thread has its own object and therefore its own non-static counter.

`AtomicLong` provides thread-safe atomic increment operations. In contrast, incrementing a shared ordinary `long` without synchronization may cause race conditions and lost updates.

### Conclusion

This laboratory experiment demonstrates the differences between static and non-static variables in Java multithreading. It also highlights the importance of thread safety when multiple threads modify shared data.

The thread-safe experiment should produce matching static and non-static totals. The unsynchronized experiment may produce different results across executions because of concurrent updates and thread scheduling.

## Submission and Documentation

Each laboratory directory will contain the relevant source code, handwritten code, input values, actual output screenshots, result analysis, and documentation required by the instructor.

## Author

**Md. Ashikur Rahman Ashik**

Department of Information and Communication Technology (ICT)

Mawlana Bhashani Science and Technology University (MBSTU), Bangladesh

## License

This repository is intended for academic learning and educational purposes.
