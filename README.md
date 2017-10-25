# Java engine template

This project is meant to serve as a template with instructions to create your own Riddles.io
game engine. You can copy and edit the files from this project when creating your own engine
more easily.

We highly recommend using the IntelliJ IDE, as the instruction below are specifically for that
IDE. Also, to run the engine, MacOS or Linux is preferred.

## Create the project

Click File -> New -> Project...

Select Gradle on the left side and check Java (and optionally Groovy for testing). Click next.

Leave GroupId empty, in ArtifactId enter the project name. We use the format
'[gamename]-engine-java'. Change Version to 1.0.0. Click next.

Check Use auto-import. Click next.

Click finish.

## Prepare the project

Copy the build.gradle file from this repo and paste it in your own project. Look for the two
FIXME comments and change them to match your project.

Also copy the following stuff from the repo into your own project:

- src/ folder
- test/ folder
- LICENSE file (If needed)
- .gitigore (If you are publishing this project on Github)
- match-wrapper-*.jar file
- run_wrapper.sh file
- wrapper-commands.json file

The last three are needed to run the engine (see below).

## Refactor the project to your own engine name

We're going to do a lot of refactoring here to change file and class names. You can do this
By rightclicking -> Refactor -> Rename. All files in the project should be automatically
updated correctly.

- Refactor the name of the package that contains the project. Default is io.riddles.template.
- Refactor all the class file names. Default is TemplateEngine or TemplateProcessor for instance. 
Our standard is to name it to the game name, so HackManEngine or LightRidersEngine for instance.

## Start coding

The template should be decently documented to see what you should edit and what you shouldn't.
The three main things that need to be edited are Engine to create the initial state, the
processor to create the rest of the game states, and all the state objects and serializers to
store the game.

There are plenty of examples of working engines on our [Github page](https://github.com/riddlesio).
The newer ones are usually the best examples, so [Ms. Hack-man](https://github.com/riddlesio/hack-man-2-engine)
is a good one for instance.

## Compiling the engine

On the far right of your screen should be a Gradle tab. Go to Tasks -> build -> jar and
doubleclick. The engine is now compiled to a .jar file that can be found in `build/libs`.

You can also run `gradle build jar` to create the .jar file.

When updating the version number in `build.gradle`, the version in the name of the .jar file is
also updated.

## Running the engine

The engine and the bots are started up and run by the match-wrapper.

You can use the `run_wrapper.sh` script to easily run a match on your local computer.
This takes the JSON from `wrapper-command.json` and gives it as an argument to the
match wrapper. The contents of wrapper-commands.json determine how a match runs.

The most important thing is that you change the commands of the bots and the engine to something
that is correct. The default is just an example and won't work on your own computer.

See [the match-wrapper Github](https://github.com/riddlesio/match-wrapper) for more information
on how to edit the `wrapper-commands.json` file.

#### IntelliJ tips

If you've never used IntelliJ before, here are some handy tips:

- Put the cursor on a piece of errored code and press Alt+Enter to get some options.
- Use Ctrl+B on anything to find usages of the piece of code. (Also useful if you quickly want
to see the source of an abstract class from the javainterface library.)