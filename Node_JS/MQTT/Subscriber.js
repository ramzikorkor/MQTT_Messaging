//A persistent js subscriber that will print incoming messages.

var mqtt = require('mqtt');
var client = mqtt.connect('tcp://localhost:1883');

client.on('connect', function(){
    client.subscribe('BloggPostTopic');
    console.log(client.connected);
});

client.on('message', function(topic, message) {
    console.log("got a message");
    console.log(message.toString());
});
