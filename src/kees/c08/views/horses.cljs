(ns kees.c08.views.horses)

(defn style
  []
  [[:html {:background "#432109"}]
   [:main {:padding-top "7rem"}]
   [:#signup-link {:visibility "hidden"}]
   [:#ph {:visibility "hidden"}]
   [:#logo-container {:background "transparent"}]
   [:#horses-outer-wrapper {:display "flex"
                            :max-width "80%"
                            :margin "0 auto"
                            :flex-direction "row"
                            :flex-wrap "wrap-reverse"
                            :align-items "stretch"}]
   [:#horses-inner-wrapper {:display "flex"
                            :margin "0 auto 1rem"
                            :align-items "stretch"
                            :flex-grow 1
                            :flex-direction "column"
                            :background "white"
                            :box-shadow "0 0 0 .25rem white"
                            :padding ".45rem"}
    [:iframe {:border "2rem solid black"
              :-webkit-mask-box-image "url(https://s3-us-west-2.amazonaws.com/s.cdpn.io/3/stampTiles.svg) 25% round"}]]
   [:#horses-pdf {:margin "0 auto"
                  :flex-grow 1
                  :min-width "10rem"
                  :align-self "stretch"}]
   [:#horses-info {:margin-right "2rem"
                   :font-family "sans-serif"
                   :display "flex"
                   :align-self "flex-end"
                   :flex-direction "column"
                   :margin-bottom "4rem"}
    [:span:first-child {:font-size "4rem"
                        :font-style "italic"
                        :font-family "'IM Fell English', serif"
                        :margin-top "1.5rem"
                        :line-height ".7"}]
    [:#date {:font-size "1.5rem"
             :font-weight "900"}]
    [:article {:align-self "flex-end"
               :background "white"
               :color "#432109"
               :margin-top "1.25rem"
               :margin-right "-1.75rem"
               :padding "1.75rem .5rem .3rem"
               :font-size "1.3rem"
               :text-align "right"
               :line-height "1.2"}]
    [:span:last-child {:font-style "italic"
                       :font-size "0.9rem"
                       :font-weight "300"
                       :margin-top "8rem"
                       :max-width "15rem"}]]])

(defn main
  []
  [:div#horses-outer-wrapper
   [:div#horses-info
    [:span "HORSES"]
    [:span#date "July 2022"]
    [:article
     "By Amanda"
     [:br]
     "Shank"]
    [:span
     "HORSES is a creative testimonial of space and transformation."
     [:br]
     "Created in collaboration with MWJ."]]
   [:div#horses-inner-wrapper
    [:iframe#horses-pdf
     {:src "https://drive.google.com/viewerng/viewer?embedded=true&url=mwj-persistent.s3.us-west-1.amazonaws.com%2FHORSES-July-2022-sample.pdf"
      :title "HORSES July 2022"
      :height "450"}]]])
