(ns kees.c08.views
  (:require [kees.c08.rf :as rf :refer [<sub >evt]]
            [kees.c08.views.signup :as views.signup]))

;; ========== INDIVIDUAL VIEWS =================================================
(defn tank
  []
  (let []
    [:div#tank
     [:article "fishtank"]
     [:a {:href "#list"} "list"]]))

;; ========== COMPILATION ======================================================
(defn routes
  "Return the content of a route."
  ; Could be improved, i.e protocol
  [hash]
  (case hash
    "" [tank]
    "list" [views.signup/signup-list]
    [tank]))

(defn main
  "Body in charge of rendering the content of the route detected by handler."
  []
  (let [route (<sub [::rf/current-route])]
    [:main (routes route)]))

(defn root-panel
  "Main panel always rendered by mount-root."
  []
  (let []
    [:<>
     [:header
      [:h1>a {:href "#"} "Home"]]
     [main]]))
