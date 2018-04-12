import org.eclipse.paho.client.mqttv3.*;

public class SimplePublish {
	
	public MqttClient publish;
	public final String brokerUrl = "tcp://localhost:1883";
	
	public SimplePublish(){
		String publishID = getClass().getSimpleName() + ((int) (10000*Math.random()));
		
		try {
			publish = new MqttClient(brokerUrl, publishID);
			publish.connect();		
		}catch (MqttException e){
			e.printStackTrace();
			System.exit(1);	
		}
	}
	
	public void createTopic(String topic) throws MqttException{
		
		//Publishes a message 5 times!
		for(int i = 0; i<5; i++){
			String str = "Message - " + i;
			MqttMessage bst = new MqttMessage(str.getBytes());
			publish.publish(topic, bst);
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main (String[] args) throws MqttException {
		SimplePublish publisher = new SimplePublish();
		publisher.createTopic("BloggPostTopic");
	}
}
