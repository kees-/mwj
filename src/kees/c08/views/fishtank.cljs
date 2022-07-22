(ns kees.c08.views.fishtank
  (:require [kees.c08.rf :as rf :refer [>evt <sub]]))

(defn tank
  []
  (let []
    (>evt [::rf/remove-class "signup-link" "hidden"])
    (>evt [::rf/logo-light-mode])
    [:div#tank.full
     [:article "fishtank"]]))

; Todo
; Make blue
; Border
; Fish ..
