(def project 'adamrenklint/boot-exec)
(def version "1.0.2")

(set-env!
 :source-paths #{"src"}
 :dependencies '[[adzerk/bootlaces      "0.1.13" :scope "test"]
                 [tolitius/boot-check   "0.1.6"  :scope "test"]
                 [adamrenklint/boot-fmt "1.3.0"  :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[adamrenklint.boot-exec :refer [exec]]
         '[adamrenklint.boot-fmt  :refer [fmt]]
         '[tolitius.boot-check :as check])

(bootlaces! version)

(ns-unmap 'boot.user 'test)
(ns-unmap 'boot.user 'format)

(deftask deps [])

(deftask release []
  (comp (build-jar)
        (push-release)
        (exec :cmd "git push --tags")))

(deftask check []
  (comp (check/with-yagni)
        (check/with-eastwood)
        (check/with-kibit)
        (check/with-bikeshed)))

(deftask format []
  (fmt))

(deftask test []
  (exec :cmd "cat boot_exec.clj"
        :dir "src/adamrenklint"))

(task-options!
  pom {:project     project
       :version     version
       :description "Boot task to execute a shell command, without changing the fileset"
       :url         "https://github.com/adamrenklint/boot-exec"
       :scm         {:url "https://github.com/adamrenklint/boot-exec"}
       :license     {"MIT" "https://github.com/adamrenklint/boot-exec/blob/master/LICENSE"}})
