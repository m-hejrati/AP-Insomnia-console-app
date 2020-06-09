import java.io.IOException;

public class Run {

    public Run(String[] string) {

        Request requestInformation = new Request();
        Response responseInformation = new Response();
        makeRequest myMakeRequest = new makeRequest();
//        Save save = new Save();

        // analyze input
        InputAnalyzer inputAnalyzer = new InputAnalyzer();
        requestInformation = inputAnalyzer.analyze(string);

        // send req
        try {
            responseInformation = myMakeRequest.makeReq(requestInformation);
        } catch (IOException e) {
//            e.printStackTrace();
            System.err.println("Error");
        }

        responseInformation.print(requestInformation.isShowHeaderResponse());
//        if (saveResponseFlag)
//            System.out.println("\nresponse body saved in entered path...");
    }

}