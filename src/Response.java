import java.util.List;
import java.util.Map;

/**
 * this class holds information of our response.
 *
 * @author Mahdi Hejarti 9723100
 * @since 2020.05.29
 */

public class Response {

    private int responseCode;
    private String responseMessage;
    private String body;
    private Map<String, List<String>> headers;

    /**
     * setter for response code
     * @param responseCode response code
     */
    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    /**
     * setter for response message
     * @param responseMessage response message
     */
    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    /**
     * setter for body
     * @param body body
     */
    public void setBody(String body) {
        this.body = body;
    }

    /**
     * setter for headers
     * @param headers headers
     */
    public void setHeaders(Map<String, List<String>> headers) {
        this.headers = headers;
    }

    /**
     * print response information
     * @param headerFlag flag to know if show headers or not in response.
     */
    public void print(boolean headerFlag) {

        System.out.println("Response Code: \t\t " + responseCode);
        System.out.println("Response Message: \t " + responseMessage);
        System.out.println("Body: \t\t " + body);
        if (headerFlag)
            System.out.println("Headers: \t " + headers);
        System.out.println();

    }

}