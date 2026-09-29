# Challenge workspace template

Copy the `cpp` or `kotlin` folder when starting a challenge. Put sample or custom
test input in `input.in`; write and compare program output in `output.out`.

From the copied language folder, for example:

```sh
g++ -std=c++17 -O2 -Wall -Wextra sol.cpp -o sol && ./sol < input.in > output.out
```

For Kotlin, compile and run with the Kotlin compiler:

```sh
kotlinc sol.kt -include-runtime -d sol.jar && java -jar sol.jar < input.in > output.out
```

Both starter programs use standard input and standard output, so they can be
submitted without changing file paths or using `freopen`.
