package com.uta.prattle.websocket;

import org.codehaus.jackson.map.ObjectMapper;

import com.uta.prattle.model.Message;

import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The Class MessageDecoder.
 */
public class MessageDecoder implements Decoder.Text<Message> {

    /**
     * @see org.codehaus.jackson.map.ObjectMapper
     */
    private static ObjectMapper objectMapper = new ObjectMapper();

    /**
     * The logger.
     */
    private Logger logger = Logger.getLogger(this.getClass().getName());

    /**
     * Decode.
     * <p>
     * Extracts the text message from a JSON structure.  It's very bad if there's no message.
     *
     * @param s the JSON structure that was sent in the channel
     * @return a Message object
     */
    @Override
    public Message decode(String s) {
        Message message = null;
        try {
            message = objectMapper.readValue(s, Message.class);
        } catch (IOException e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
        return message;
    }

    /**
     * Will decode.
     * <p>
     * Tests if there's a string to decode.
     *
     * @param s the s
     * @return true, if successful
     */
    @Override
    public boolean willDecode(String s) {
        return (s != null);
    }

    /**
     * Custom code if anything special is needed when establishing the session
     * with a particular endpoint (the websocket).  Not used at present.
     *
     * @param endpointConfig the endpoint config
     */
    @Override
    public void init(EndpointConfig endpointConfig) {
        // Custom initialization logic
    }

    /**
     * Destroy.
     * <p>
     * Close the connection.  Nothing implemented in the prototype.
     * But then again, there's no disconnect message.
     */
    @Override
    public void destroy() {
        // Close resources
    }
}
