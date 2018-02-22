# boot-exec

Boot task to execute a shell command, without changing the fileset

[![Clojars Project](https://img.shields.io/clojars/v/adamrenklint/boot-exec.svg?style=flat-square
)](https://clojars.org/adamrenklint/boot-exec) [![CircleCI](https://img.shields.io/circleci/project/github/adamrenklint/boot-exec.svg?style=flat-square
)](https://circleci.com/gh/adamrenklint/boot-exec)

```clojure
[adamrenklint/boot-exec "1.1.0"] ;; latest release
```

## Usage

```
$ boot exec -c "echo hello world"
hello world
```

## Options

```
-c, --cmd      CMD  Command to execute
-d, --dir      DIR  Directory in which the command is executed, defaults to project root
-p, --pred-fn  FN   Predicate function to determine if task should be executed or skipped
```

## License

Copyright (c) 2017 [Adam Renklint](http://adamrenklint.com)

Distributed under the [MIT license](https://github.com/adamrenklint/boot-exec/blob/master/LICENSE)
