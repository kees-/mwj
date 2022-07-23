(ns kees.c08.views.fishtank
  (:require [kees.c08.rf :as rf :refer [>evt <sub]]))

(defn fish1
  []
  [:a.fish
   {:href "#horses"}
   [:img
    {:src "/_asset/tank/seahorse.gif"
     :draggable false}]])

(defn style
  []
  [[:main {:background "darkslategrey"}]
   [:#tank {:margin-top "8rem"
            :max-width "85%"
            :margin "auto"}]
   [:#tank2 {:background "deepskyblue"
             :background-image "url(/_asset/tank/bottom.png), url(/_asset/tank/top.png)"
             :background-position "left bottom, left top"
             :background-size "initial"
             :background-repeat "repeat-x, repeat-x"
             :image-rendering "pixelated"
             :border "4px solid grey"
             :height "100%"}]
   [:.fish {:position "relative"
            :display "inline-block"
            :top "50%"
            :left "65%"
            :cursor "pointer"}
    [:img {:display "inline"}]]])

(defn main
  []
  [:div#tank.full
   [:div#tank2
    [fish1]]])

; Todo
; Border
; Fish ..
