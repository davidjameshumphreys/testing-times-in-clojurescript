# example-project

This project doesn't do much; it demonstrates different ways to test your Clojurescript application.

The project was created based on the figwheel-template: `lein new figwheel example-project`

## Overview

There are some different builds in the project and also some aliases set up to try the different builds.

* try-doo-phantom
* try-speclj-auto
* try-speclj
* try-devcards
* try-figwheel

Each will start a different auto build using the build type.

You will need to install phantomjs to use Doo and Speclj

## Setup

To get an interactive development environment run:

    lein figwheel

(or `rlwrap lein figwheel` to get input history)    
and open your browser at [localhost:3449](http://localhost:3449/).
This will auto compile and send all changes to the browser without the
need to reload. After the compilation process is complete, you will
get a Browser Connected REPL. An easy way to try it is:

    (js/alert "Am I connected?")

and you should see an alert in the browser window.

To clean all compiled files:

    lein clean


## License

Copyright © 2015 David Humphreys

Distributed under the Eclipse Public License either version 1.0 or (at your option) any later version.
