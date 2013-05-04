;; NOTE!  This project requires leiningen 2.1.0 or later.
(require 'leiningen.core.eval)
;;(println (leiningen.core.eval/get-os)) ;; try lein deps to see this

(def LWJGL-CLASSIFIER
  "Per os native code classifier"
  {:macosx  "natives-osx"
   :linux   "natives-linux"
   :windows "natives-windows"})

(defn lwjgl-classifier
  "Return the os-dependent lwjgl native-code classifier"
  []
  (let [os (leiningen.core.eval/get-os)]
    (get LWJGL-CLASSIFIER os)))

(defproject shadertone "0.1.0"
  :description "shadertoy + overtone"
  :url "http://github.com/rogerallen/shadertoneo"
  :license {:name "MIT License"
            :url "https://github.com/overtone/shadertone/blob/master/LICENSE"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.lwjgl.lwjgl/lwjgl "2.8.5"]
                 [org.lwjgl.lwjgl/lwjgl_util "2.8.5"]
                 [org.lwjgl.lwjgl/lwjgl-platform "2.8.5"
                  :classifier    ~(lwjgl-classifier)
                  :native-prefix ""]
                 [overtone "0.8.1"]
                 [watchtower "0.1.1"]]
  ;; add leipzig for use in examples
  :profiles {:dev {:dependencies [[leipzig "0.4.0"]]}})
