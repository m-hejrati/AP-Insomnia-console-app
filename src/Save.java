import javax.xml.parsers.SAXParser;
import java.io.*;
public class Save {

    public Save(){

    }

    public void save(String name, String group, Request requestInformation) {

        String path = "requests/" + group;

        if (new File(path).exists()) {
            try {
                File file = new File(path + "/" + name);
                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
                out.writeObject(requestInformation);
                System.out.println("Request saved.");

            } catch (IOException e) {
                e.printStackTrace();
                System.err.println("Impossible to save request");
            }
        } else
            System.err.println("there is no group with this name to save");
    }

    public void list(String group) {

        if (group.charAt(0) != '-') {

            String path = "requests/" + group;
            if (new File(path).exists()) {

                File[] files = new File(path).listFiles();
                if (files != null) {
                    Request requestInformation = new Request();
                    for (int i = 0; i < files.length; i++) {
                        System.out.print(i + 1 + ". name: " + files[i].getName());
                        requestInformation = load(path + "/" + files[i].getName());
                        requestInformation.print();
                    }
                }

            } else
                System.err.println("there is no group with this name to load");

        } else {

            File[] files = new File("requests").listFiles();
            if (files != null) {
                for (int i = 0; i < files.length; i++)
                    System.out.println(i + 1 + ". " + files[i].getName());
            } else
                System.out.println("there is not any group for requests");
        }

    }

    public Request load(String fileAddress) {

        Request requestInformation = new Request();

        try {
            File file = new File(fileAddress);
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
            requestInformation = (Request) in.readObject();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.err.println("Impossible to load request");
        }

        return requestInformation;
    }

    public void createGroup(String str) {

        String path = "requests/" + str;
        boolean isSuccessful = new File(path).mkdirs();
        System.out.println("Creating directory is successful: " + isSuccessful);

    }

    public Request fire(String group, String name){

        Request requestInformation = new Request();
        String path = "requests/" + group;

        if (new File(path).exists()) {
            requestInformation = load(path + "/" + name);

        } else
            System.err.println("there is no group with this name to fire");

        return requestInformation;
    }

}