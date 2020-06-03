import java.io.IOException;

public class Run {

    public Run (String[] string) {

        Request requestInformation = new Request();
        Response responseInformation = new Response();
        makeRequest myMakeRequest = new makeRequest();

        String[] headers = null;
        String[] body = null;
        for(int j = 0; j < string.length; j++) {

            if (string[j].equals("-h") || string[j].equals("--help")) {
                printHelp();
                System.exit(0);
            }

            if (string[j].equals("-u") || string[j].equals("--url"))
                requestInformation.setUrl(string[j + 1]);

            if (string[j].equals("-M") || string[j].equals("--method"))
                requestInformation.setMethod(string[j + 1]);

            if (string[j].equals("-H") || string[j].equals("--headers"))
                headers = string[j + 1].split("&");

            if (string[j].equals("-d") || string[j].equals("--data")) {
                requestInformation.setBodyMethod("--data");
                body = string[j + 1].split("&");
            }

            if (string[j].equals("--upload")) {
                requestInformation.setBodyMethod("--upload");
                requestInformation.setFileAddress(string[j + 1]);
            }
        }

        requestInformation.setHeaders(headers);
        requestInformation.setBody(body);

        // send req
        try {
            responseInformation = myMakeRequest.makeReq(requestInformation);
        } catch (IOException e) {
//            e.printStackTrace();
            System.err.println("Error");
        }

        // set headers if needed
        boolean headerFlag = false;
        for(String str: string)
            if (str.equals("-i")) {
                headerFlag = true;
                break;
            }

        responseInformation.print(headerFlag);

    }

    public void printHelp(){

        System.out.println("Help ");
        System.out.println("u <> , --url <> \t : set url");
        System.out.println("M <> , --method <> \t : set method");
        System.out.println("H <> , --header <> \t : set headers \t [--header \"key1:value1&key2:value2\"]");
        System.out.println("d <> , --data <> \t : set message body in form-data \t [--data \"key1:value1&key2:value2\"]]");
        System.out.println("\t , --upload <> \t : set message body with uploaded file \t [--upload E:\\MidTermTest\\note.txt]");

    }
}