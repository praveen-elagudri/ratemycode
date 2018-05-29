from channels.routing import route
from ratemycode.feeds.consumers import ws_connect, ws_disconnect


websocket_routing = [
    route('websocket.connect', ws_connect),
    route('websocket.disconnect', ws_disconnect),
]
