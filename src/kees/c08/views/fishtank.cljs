(ns kees.c08.views.fishtank)

(defn horse1
  []
  [:a#horse.fish.a
   {:href "#horses"}
   [:img
    {:src "/_asset/tank/seahorse.gif"
     :draggable false}]])

(defn jelly1
  []
  [:div#jelly1.fish
   [:img
    {:src "/_asset/tank/jelly1.gif"
     :draggable false}]])

(defn fish1
  []
  [:div#fish1.fish
   [:img
    {:src "/_asset/tank/fish1.gif"
     :draggable false}]])

(defn style
  []
  [[:main {:background "darkslategrey"}]
   [:#tank {:max-width "85%"
            :margin "auto"}]
   [:#tank2 {:background "deepskyblue"
             :background-image "url(/_asset/tank/bottom.png), url(/_asset/tank/top.png)"
             :background-position "left bottom, left top"
             :background-size "initial"
             :background-repeat "repeat-x, repeat-x"
             :image-rendering "pixelated"
             :border "4px solid grey"
             :height "100%"}]
   [:#tank3 {:margin "110px 0 75px"
             :max-height "50%"}]
   [:.fish {:position "absolute"
            :display "inline-block"}
    [:img {:display "inline"
           :overflow "hidden"}]]
   [:#horse {:top "55%"
             :left "65%"}]
   [:#fish1 {:top "55%"
             :left "20%"}]
   [:#jelly1 {:top "40%"
              :left "45%"}]])

(defn main
  []
  [:div#tank.full
   [:div#tank2
    ;; [:div#tank3]
    [horse1]
    [fish1]
    [jelly1]]])

; Todo
; Border
; Fish ..
