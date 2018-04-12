var mqtt = require('mqtt');
var client = mqtt.connect('tcp://localhost:1883');

client.on('connect', function(){
    client.publish('OtherBloggTopic');
})

client.on('message', function(topic, message){
    client.publish('bst', message.toString())
})
