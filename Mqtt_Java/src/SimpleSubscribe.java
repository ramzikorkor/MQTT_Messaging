import org.eclipse.paho.client.mqttv3.*;

public class SimpleSubscribe {

	public MqttClient subscribe;
	public final String brokerUrl = "tcp://localhost:1883";
	
	public SimpleSubscribe(){
		String subscribeID = getClass().getSimpleName() + ((int) (10000*Math.random()));
		
		try {
			subscribe = new MqttClient(brokerUrl, subscribeID);		
			subscribe.connect();
			
		}catch (MqttException e){
			e.printStackTrace();
			System.exit(1);
			
		}
	}
	
	public static void main (String[] args) throws MqttException {
		SimpleSubscribe sub = new SimpleSubscribe();
		
	}
}
