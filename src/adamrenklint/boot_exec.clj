(ns adamrenklint.boot-exec
  {:boot/export-tasks true}
  (:require [boot.core :as core]
            [boot.util :as util]
            [clojure.string :as string]))

(core/deftask exec
  "Execute a shell command, without changing the fileset"
  [c cmd     CMD str "Command to execute."
   d dir     DIR str "Directory in which the command is executed, defaults to project root."
   p pred-fn FN  sym "Predicate function to determine if task should be executed or skipped."]
  (assert cmd "Must declare a command to execute.")
  (let [pred? (if pred-fn (resolve pred-fn) (fn [] true))]
    (core/with-pass-thru _
      (when (pred?)
        (binding [util/*sh-dir* (or dir ".")]
          (apply util/dosh (string/split cmd #" ")))))))
