# Pipelined MIPS datapath simulator

- Implemented with Java

## How to use

**Step 1:** Create a file in `root` named `program` and write your MIPS program in it. Use newline\enter to seperate each line of instruction.

**Sample**
```
addi $t3 $0 6
addi $t4, $0, 150
beq $t0 $t3 3
sub $t4 $t4 $t3
addi $t0 $t0 1
```

**Step 2:** Compile the source code by running `javac Main.java` in the `root`.

**Step 3:** Run executable by running `java Main` in the `root`. Follow the prompts on the console from there.

## Description

This simulator is a low-level cycle-accurate pipelined MIPS datapath simulator that simulates the datapath including all of its storage
components (register file, memories, and pipeline registers) and all of its control signals.

## Stages of the pipeline

- IF  : Instruction Fetch Stage
- ID  : Instruction Decode Stage
- EX  : Execution Stage
- MEM : Memory Stage
- WB  : Write Back Stage

## Implemented Instruction Set

- Arithmetic Operations: `add`, `sub`, `addi`
- Logic Operations: `and`, `or`
- Shift Operations: `sll`
- Load/Store: `lw`, `sw`
- Control Flow: `beq`, `j`
- Comparison: `slt`

## Implementation notes

- The register file contains the 32 registers of the MIPS processor, its content is printed at the end of the simulation
- Instruction and data memories are separated in different memory arrays
- The size of the instruction memory is 32KB. It can hold up to 1000 instructions. The size can be changed in the simulator constructor.
- The size of the data memory is 64KB. The size can be changed in the simulator constructor.
- The datapath detects and handles load-use and data hazards appropriately. Hazard-detection and Forwarding units are added.

## Simulation

- Program file must be present within the project folder. When running the simulation, you wil be asked to enter its name.
- Any initialization for the memory or register file contents can be added in the console afterwards.
- The simulator shows the content of the pipeline registers and which instructions are being executed and at which stages in each clock cycle.

