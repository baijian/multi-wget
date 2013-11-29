(ns multi-wget.core
  (:import [java.io File FileOutputStream])
  (:require [clojure.contrib.io])
  (:gen-class))

(defn wget [to from]
  (with-open [out (FileOutputStream. (str to (last (.split from "/"))))]
    (.write out
      (clojure.contrib.io/to-byte-array
        (clojure.contrib.io/input-stream
          (clojure.contrib.io/as-url from)))))
  (println (str "wget " (str to (last (.split from "/"))) " suc!")))

(defn -main
  "wget binary file in parallel using multi-threads"
  [& args]
  (let [futures-list 
        (doall
          (doseq [from (next args)]
            (future (wget (nth args 0) from))))
        results (map deref futures-list)]
    (doseq [r results] (println r))))
;(java.lang.System/exit 0)
