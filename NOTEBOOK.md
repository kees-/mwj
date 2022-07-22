<details>
  <summary>
    Dynamic style :white_check_mark:
  </summary>
  
  ---
  Considering redoing the CSS with the following flow.
  
  Dynamic styles manually adding and removing classes got very tired quickly.
  - Static CSS files are served containing sitewide settings and are referenced in html.
  - Sets of page-specific selectors are defined inline with [garden](https://github.com/noprompt/garden/).
  - Html head contains an empty style tag with id e.g `page-style`, placed after external sheets
  - Route is changed. New content is mounted. The style tag is unmounted and re-mounted with the content specific to the page. I am only wondering whether page updates will work

  I think styles should be organized on their respective views pages. `kees.c08.views.fishtank/styles`, `kees.c08.views.fishtank/html`.
 
  ---
</details>

<details>
  <summary>
    Assets
  </summary>
  
Large assets (needing persistent storage) will be outsourced from the repo.

This is due to github file size limits and privacy, not putting people's content in a clone-able repo.

The main downside is this will require maintaining asset URLS manually, no big deal
</details>
