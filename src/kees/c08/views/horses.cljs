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
   [:.pdf-outbound {:display "block"
                    :margin "0 .25rem 0 auto"
                    :width "max-content"}
    [:i {:font-size "2rem"
         :padding ".25rem"
         :color "black"
         :background "white"}]]
   [:#horses-inner-wrapper {:display "flex"
                            :margin "0 auto 1rem .75rem"
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
   [:#horses-info {:font-family "sans-serif"
                   :display "flex"
                   :flex-direction "column"
                   :margin-bottom "6rem"}
    [:span:first-child {:font-size "4rem"
                        :font-style "italic"
                        :font-family "'IM Fell English', serif"
                        :margin-top "1.5rem"
                        :line-height ".7"
                        :margin-right "1.25rem"}]
    #_[:#date {:font-size "1.5rem"
             :font-weight "900"}]
    #_[:article {:align-self "flex-end"
               :background "white"
               :color "#432109"
               :margin-top "1.25rem"
               :margin-right "-1.75rem"
               :padding "1.75rem .5rem .3rem"
               :font-size "1.3rem"
               :text-align "right"
               :line-height "1.2"}]
    [:div:last-child {:margin-top "3.75rem"
                      :font-style "italic"
                      :font-size "0.9rem"
                      :font-weight "300"
                      :max-width "15rem"
                      :align-self "flex-end"}
     [:p {:margin-bottom "1.25rem"
          :line-height 1.25
          :text-align "justify"
          :text-align-last "right"
          :max-width "96%"}]
     [:p:last-of-type {:margin-bottom "3rem"}]]]])

(defn main
  []
  [:div#horses-outer-wrapper
   [:div#horses-info
    [:span "HORSES"]
    #_[:span#date "July 2022"]
    #_[:article
     "By Amanda"
     [:br]
     "Shank"]
    [:div
     [:p "I’ll say everything that I see while we poke around and you take notes before we circle back at the end to pick the three to five action items that will move the most energy for you/your declared intent/story."]
     [:p "Amanda did everything. She went to Paris, came home, did more, and then sent me this."]]]
   [:div
    [:a.pdf-outbound
     {:href "https://mwj-persistent.s3.us-west-1.amazonaws.com/HORSES.pdf"
      :target "_blank"}
     [:i.bx.bx-link-external]]
    [:div#horses-inner-wrapper
     [:iframe#horses-pdf
      {:src "https://mwj-persistent.s3.us-west-1.amazonaws.com/HORSES.pdf#view=fitH&navpanes=0"
       :title "HORSES"
       :height "450"}]]]])
