# fork of mqtt-home
- each item has a optional publishTopic for write operations
- fixed startup bug (empty page/workspace null)
- add "clone" function for items

# mqtt-home

MQTT dashboard app that stores its config in MQTT to easily share your dashboard with your family members and friends without the need to configure it every time.

Configuration is stored in "workspace" topic.

Although this project started for personal usage, I've decided to make it public and it is currently in active development. Please let me know what features you would like to see!

Features:

- Different supported widgets: section, text, switch, graph, dropdown, color, button group.
- MQTT used as configuration storage.
- TLS support with CA & client certificates.
- Dark-mode-friendly!
- Free & no ads - forever!

![Image 1](/assets/out.png)
