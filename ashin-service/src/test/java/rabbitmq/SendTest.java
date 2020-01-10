package rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class SendTest {

    private final static String QUEUE_NAME = "hello_text";
    private static final String EXCHANGE_NAME = "logs";
    private static final String HOST = "182.61.57.152";
    private static final String EXCHANGE_NAME_DIRECT = "directExchange";

    private static final String EXCHANGE_NAME_TOPIC = "topicExchange";

    public static void main(String[] argv) throws Exception {
        sendTopicExchange(argv);
    }

    /**
     * 简单 点对点 队列
     */
    public static void sendSimpleQueue()
    {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(HOST);
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel();
        ) {

            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            String message = "Hello World!";
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            System.out.println(" [x] Sent '" + message + "'");

        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }

    /**
     * 工作队列，1 produce  2 consumer
     * 模拟发送 11条消息，内容为
     * 1、我是缓慢的消息.....
     * 2、我是快速的消息.
     * 3、我是快速的消息.
     * 4、我是快速的消息.
     */
    public static void sendWorkQueue()
    {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(HOST);
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel();
        ) {
            boolean durable = true;  //消息持久划
            channel.queueDeclare(QUEUE_NAME, durable, false, false, null);
            StringBuffer sb=new StringBuffer("我是缓慢的消息....");
            channel.basicPublish("", QUEUE_NAME, null, sb.toString().getBytes());
            System.out.println(" [x] Sent '" + sb.toString() + "'");
            String a="我是快速的消息.";
            for(int i=0;i<10;i++)
            {

                channel.basicPublish("", QUEUE_NAME, MessageProperties.PERSISTENT_TEXT_PLAIN, a.getBytes());
                System.out.println(" [x] Sent '" + a.toString() + "'");

            }



        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }

    /**
     * 发布订阅模式
     * 交换机 fanout
     */
    public static void sendPublishSubscribe()
    {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(HOST);
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.exchangeDeclare(EXCHANGE_NAME, "fanout");

            String message ="发布/订阅消息";

            channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes("UTF-8"));
            System.out.println(" [x] Sent '" + message + "'");
        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * routkey
     * Direct Exchange
     */
    public static void sendDirectExchange(String []argv)
    {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(HOST);
        if (argv.length < 1) {
            System.err.println("Usage: ReceiveLogsDirect [info] [warning] [error]");
            System.exit(1);
        }
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.exchangeDeclare(EXCHANGE_NAME_DIRECT, "direct");

            String severity = getSeverity(argv);
            String message = getMessage(argv);
            channel.basicPublish(EXCHANGE_NAME_DIRECT, severity, null, message.getBytes("UTF-8"));
            System.out.println(" [x] Sent '" + message + "'");
        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getMessage(String[] argv) {
      return   "我是消息，key为"+argv[0];


    }

    private static String getSeverity(String[] argv) {
        return argv[0];
    }

    /**
     * routkey
     * topic Exchange
     */
    public static void sendTopicExchange(String []argv)
    {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(HOST);
        if (argv.length < 1) {
            System.err.println("Usage: ReceiveLogsDirect [info] [warning] [error]");
            System.exit(1);
        }
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.exchangeDeclare(EXCHANGE_NAME_TOPIC, "topic");

            String severity = getSeverity(argv);
            String message = getMessage(argv);
            channel.basicPublish(EXCHANGE_NAME_TOPIC, severity, null, message.getBytes("UTF-8"));
            System.out.println(" [x] Sent '" + message + "'");
        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
