package co.wecommit.javatest;

import java.util.LinkedList;
import java.io.*;

public class FileHandler {

    public LinkedList<Member> readFile(String filename) {
        LinkedList<Member> list = new LinkedList();

        String lineRead;
        String[] splitLine;
        Member mem;

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            lineRead = reader.readLine();

            while (lineRead != null) {
                splitLine = lineRead.split(", ");

                switch (splitLine[0]) {
                    case "S":
                        mem = new SingleClubMember(
                            splitLine[0].charAt(0),
                            Integer.parseInt(splitLine[1]),
                            splitLine[2],
                            Double.parseDouble(splitLine[3]),
                            Integer.parseInt(splitLine[4])
                        );
                        list.add(mem);
                        break;
                    case "M":
                        mem = new MultiClubMember(
                            splitLine[0].charAt(0),
                            Integer.parseInt(splitLine[1]),
                            splitLine[2],
                            Double.parseDouble(splitLine[3]),
                            Integer.parseInt(splitLine[4])
                        );
                        list.add(mem);
                        break;
                }

                lineRead = reader.readLine();
            }
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return list;
    }

    public void appendFile(String filename, Member mem) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            writer.write(mem.toString() + "\n");
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void overwriteFile(String filename, LinkedList<Member> members) {
        String str;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename + ".tmp", false))) {
            for (int i = 0; i< members.size(); i++) {
                str = members.get(i).toString();

                writer.write(str + "\n");

            }

            File f = new File(filename);
            File tf = new File(filename + ".tmp");

            f.delete();
            tf.renameTo(f);


        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
