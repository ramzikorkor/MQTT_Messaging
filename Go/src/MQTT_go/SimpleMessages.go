package main

import (
	MQTT "github.com/eclipse/paho.mqtt.golang"
	"fmt"
)


func onMessageReceived(client MQTT.Client, message MQTT.Message) {
	fmt.Printf("Received message on topic: %s\nMessage: %s\n", message.Topic(), message.Payload())
}

func createClient(clientID string, broker string) MQTT.Client{
	options := MQTT.NewClientOptions().SetClientID(clientID).AddBroker(broker)
	client := MQTT.NewClient(options)

	if token := client.Connect(); token.Wait() && token.Error() != nil {
		panic(token.Error())
	}
	return client

}

func listen(client MQTT.Client, topic string){
	if token := client.Subscribe(topic, 0, onMessageReceived); token.Wait() && token.Error() != nil {
		fmt.Println(token.Error())
	}
}

func postMessage(client MQTT.Client, topic string){
	if token := client.Publish(topic, 1, false, "example Payload"); token.Wait() && token.Error() != nil {
		fmt.Println(token.Error())
	}
}

func main() {

	theClient := createClient("Blogg", "tcp://localhost:1883")

	listen(theClient, "BloggPostTopic")
	for{

	}
	//postMessage(theClient, "BloggPostTopic")
}