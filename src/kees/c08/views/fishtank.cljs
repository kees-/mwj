(ns kees.c08.views.fishtank
  (:require [kees.c08.rf :as rf :refer [>evt <sub]]))

(defn style
  []
  [[:#tank {:background "deepskyblue"}]])

(defn main
  []
  (let []
    [:div#tank.full
     [:article "fishtank"]]))

; Todo
; Border
; Fish ..
