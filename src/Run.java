import java.io.IOException;

public class Run {

    public Run(String[] string) {

        Request requestInformation = new Request();
        Response responseInformation = new Response();
        makeRequest myMakeRequest = new makeRequest();

        String[] headers = null;
        String[] body = null;
        boolean saveResponseFlag = false;

        for (int j = 0; j < string.length; j++) {

            if (string[j].equals("-h") || string[j].equals("--help")) {
                printHelp();
                System.exit(0);
            }

            if (string[j].equals("-i"))
                requestInformation.setShowHeaderResponse(true);

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
                requestInformation.setFileLoadAddress(string[j + 1]);
            }

            if (string[j].equals("-O") || string[j].equals("--output")) {
                requestInformation.setResponseFileAddress(string[j + 1]);
                saveResponseFlag = true;
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

        responseInformation.print(requestInformation.isShowHeaderResponse());
        if (saveResponseFlag)
            System.out.println("\nresponse body saved in entered path...");
    }

    public void printHelp() {

        System.out.println("Help ");
        System.out.println("-u <>, --url <> \t : set url \t ");
        System.out.println("-i   , \t\t\t\t : show response headers");
        System.out.println("-M <>, --method <> \t : set method \t [--method GET]");
        System.out.println("-H <>, --header <> \t : set headers \t [--header \"key1:value1&key2:value2\"]");
        System.out.println("-d <>, --data <> \t : set message body in form-data \t [--data \"key1:value1&key2:value2\"]]");
        System.out.println("\t , --upload <> \t : set message body with uploaded file \t [--upload E:\\MidTermTest\\note.txt]");
        System.out.println("-O <>, --output <> \t : save response body in entered file \t [--output E:\\MidTermTest\\note.png]]");

    }
}