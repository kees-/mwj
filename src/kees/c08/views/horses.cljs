(ns kees.c08.views.horses)

(defn style
  []
  [[:html {:background "#432109"}]
   [:main {:padding-top "7rem"}]
   [:#signup-link {:visibility "hidden"}]
   [:#ph {:visibility "hidden"}]
   [:#horses-outer-wrapper {:display "flex"
                            :max-width "80%"
                            :margin "0 auto"
                            :flex-display "row"
                            :flex-wrap "wrap-reverse"
                            :align-items "stretch"}]
   [:#horses-inner-wrapper {:display "flex"
                            :margin "0 auto 1rem"
                            :align-items "stretch"
                            :flex-grow 1
                            :flex-direction "column"
                            :background "black"
                            :border-width "1rem"
                            :border-style "solid"
                            :border-image-source "url(//www.w3cplus.com/sites/default/files/blogs/2019/1904/border.svg?id=2)"
                            :border-image-slice "5"
                            :border-image-repeat "round"
                            :border-image-width "2.3"
                            :border-image-outset "1.25"
                            :box-shadow "0 0 0 1rem white"
                            :padding ".45rem"}]
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
               :margin-right "-1rem"
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
     {:src "https://mwj-persistent.s3.us-west-1.amazonaws.com/HORSES-July-2022.pdf#view=fitH&navpanes=0"
      :height "450"}]]])
