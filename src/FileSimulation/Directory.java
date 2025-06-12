package FileSimulation;

import java.util.ArrayList;

public class Directory {
    private Directory parent;
    private String name;
    private ArrayList<Directory> subDirectories=new ArrayList<>();
    private ArrayList<File> files=new ArrayList<>();

    public Directory(Directory parent, String name){
        this.parent=parent;
        this.name=name;
    }

    public ArrayList<Directory> getSubDirectories() {
        return this.subDirectories;
    }
    public ArrayList<File> getFiles() {
        return this.files;
    }
    public Directory getParent() {return this.parent;}
    public void setParent(Directory parent) {
        this.parent = parent;
    }
    public String getName() {return this.name; }


    //check exsistence
    public boolean checkDirExistence(String newDirectoryName){
        for(Directory dir :this.getSubDirectories()) {
            if (dir.getName().equals(newDirectoryName))
                return true;
        }
        return false;
    }

    public boolean checkFileExistence(String fileName){
        for(File fl :this.getFiles()) {
            if (fl.getName().equals(fileName))
                return true;
        }        return false;
    }
//    public Directory changeDirectory(String name){
//        if(this.checkDirExistence(name))
//        {
//            for(Directory dir: this.getSubDirectories()){
//                if(dir.getName().equals(name))
//            }
//        }
//    }

    // make subdirectory
    public Directory makeDirectory(String name){
        Directory newDirectory= new Directory(this,name);
        newDirectory.parent=this;
        this.subDirectories.add(newDirectory);
        return newDirectory;
    }
    // make file
    public File makeFile(String name, String content){
        File newfile= new File(this,name,content);
        files.add(newfile);
        return newfile;
    }

    // show list of subDirectory and file
    public void showDirectoriesAndFiles(){
        System.out.println("Directories\n");
        for(Directory dir:this.subDirectories)
            System.out.println(dir.name);
        System.out.println("\nFiles\n");
        for(File fl:this.files)
                System.out.println(fl.getName());
    }
    // show path to root directory
    public void showPathToRoot(){
        StringBuilder path=new StringBuilder();
        while(this.parent!= null){
            path.append("/"+this.name);
            path=path.reverse();
        }
        System.out.println("Path : "+path);
    }

    // move to parent
    public Directory moveToParent(){
        return this.parent;
    }

    public void showTree(){
        System.out.println(this.name+"\n");
        System.out.println("Directories\n");
        for(Directory dir:this.subDirectories)
            dir.showTree();
        System.out.println("\nFiles\n");
        for(File fl:this.files)
            System.out.println(fl.getName());
    }

    public Directory moveDir(Directory newParent){
        newParent.subDirectories.add(this);
        this.parent.subDirectories.remove(this);
        this.parent=newParent;
        return newParent;
    }

}
