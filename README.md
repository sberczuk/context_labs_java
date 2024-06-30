# Java Version

The UML diagram is essentially similar to the GoLang Version
## Build and Run

`gradlew build`
`gradlew run`

I didn't get to coming with with a better cli use model.


Since I've been away from Java for a couple of years, and you said you didn't have current experience with Go, I wanted to do a version of  this is Java.
## Assumptions

- if an attribute is NOT present assume that a condition passes/does not apply. We'd want to discuss this in real life.


## Caveats

- My Experience with Gradle and the java build ecosystem is a bit rusty, but having been The Build Person at past jobs (all of them) I  think I can catch up/adapt to what you do at Context Labs
- I went back and forth between using interfaces and generics v Objects and dynamic typing. This seems safer. But I think this would be a design conversation.
- What's missing is serialization/loading of data. In real life attributes could come from either some sort of data entry/Database or a JSON file. If the latter, we'd want a type field and factory methods
- My style (casing, naming) might be not ideal. IME style varies by org/team anyway, and it's easy enough to fix.

## What's missing

Since this is the second implementation (v the Go one) I did go lighter on tests than I might have.

See comments in the code to address some design decisions I was unsure were idiomatic.

Attribute names should probably be enums/consts

## Other Notes

- I made a pass at reproducing the GoLang table test idiom with `MethodSource` (see `EqualsTest` for an example). I didn't do that everywhere because I wasn't sure it if was idiomatic.