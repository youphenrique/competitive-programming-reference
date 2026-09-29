# Repository guidance

This repository is a collection of standalone competitive programming algorithm examples. Keep changes focused on the relevant example and avoid introducing project-wide build or runtime assumptions.

## Code examples

- Keep each example self-contained and suitable for copying into a contest submission.
- Use the conventions and standard library idioms of the example's language; avoid unnecessary dependencies or abstractions.
- Document important assumptions near the code, especially input format, vertex indexing, directedness, constraints, and complexity when they are not obvious.
- Preserve the existing topic-based filenames and avoid unrelated edits to other algorithm examples.
- When adding another language implementation, make its behavior and documented assumptions consistent with the corresponding existing example unless the language requires a clear difference.

## Changes and verification

- Keep documentation concise and aligned with the code's actual behavior.
- For code changes, compile or run the affected standalone example when a suitable toolchain is available; do not add a shared build system solely for verification.
- Do not add tests or fixtures unless requested or needed to support a specific change.
