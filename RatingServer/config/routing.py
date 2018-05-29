from channels import include

channel_routing = [
    # Include subrouting from an app with predefined path matching.
    include("ratemycode.activities.routing.websocket_routing",
            path=r"^/notifications/$"),
    include("ratemycode.feeds.routing.websocket_routing", path=r"^/feeds/$"),
    include("ratemycode.messenger.routing.websocket_routing",
            path=r"^/")
]
