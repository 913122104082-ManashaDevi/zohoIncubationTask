package FileSimulation;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String args[])
    {
        HashMap<String,Directory> directoryHashMap=new HashMap<>();
        HashMap<String,File> fileHashMap=new HashMap<>();

        Scanner sc=new Scanner(System.in);
        Directory root= new Directory(null,"C:");
        Directory current=root;
        System.out.println("Enter option 0 to stop 1 to continue...");
        int op=sc.nextInt();
        while(op==1){
            System.out.println("Enter Command :");
            String command=sc.next();
            current=executeCommand(command,current,root,directoryHashMap,fileHashMap);
        }

    }
    private static Directory executeCommand(String command, Directory current,Directory root,
                                            HashMap<String, Directory> directoryHashMap, HashMap<String, File> fileHashMap) {

        Scanner sc = new Scanner(System.in);
        command = command.toLowerCase();

        switch (command) {
            case "md":
                System.out.print("Enter directory name: ");
                String dirName = sc.next();
                if(!current.checkDirExistence(dirName)) {
                    current = current.makeDirectory(dirName);
                    directoryHashMap.put(current.getName(), current);
                    directoryHashMap.put(current.getParent().getName(), current.getParent());
                }
                break;

            case "touch":
                System.out.print("Enter file name: ");
                String fileName = sc.next();
                sc.nextLine();
                System.out.print("Enter file content: ");
                String content = sc.nextLine();
                if(!current.checkFileExistence(fileName))
                {
                    File fl = current.makeFile(fileName, content);
                    directoryHashMap.put(fl.getParent().getName(), fl.getParent());
                    fileHashMap.put(fileName, current.getFiles().get(current.getFiles().size() - 1));
                }
                break;

            case "cd":
                System.out.print("Enter directory name (., .., or name): ");
                String arg = sc.next();
                if (arg.equals(".")) {
                  System.out.println("Current Directory : "+ current.getName());
                } else if (arg.equals(".."))
                {
                    if (current.getParent() != null)
                        current = current.getParent();
                } else if(arg.equals("/"))
                     current=root;
                else{

                }
                break;

            case "pwd":
                current.showPathToRoot();
                break;

            case "list":
                current.showDirectoriesAndFiles();
                break;

            case "tree":
                current.showTree();
                break;

            case "move":
                System.out.print("Enter name of file/directory to move: ");
                String moveName = sc.next();
                System.out.print("Enter destination directory name: ");
                String destName = sc.next();
//                if (!directoryHashMap.contains(destName)) {
//                    System.out.println("Destination not found");
//                    break;
//                }

//                if (directoryHashMap.containsKey(moveName)) {
//                    Directory dirToMove = directoryHashMap.get(moveName);
//                    dirToMove.moveDir(destination);
//                } else if (fileHashMap.containsKey(moveName)) {
//                    File fileToMove = fileHashMap.get(moveName);
//                    fileToMove.moveFile(destination);
//                } else {
//                    System.out.println("No such file or directory to move");
//                }
                break;

            default:
                System.out.println("Unknown command");
                break;
        }

        return current;
    }



}
