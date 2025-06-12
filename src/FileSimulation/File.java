package FileSimulation;

public class File {
    private Directory parent;
    private String name;
    private String content;



    public File(Directory parent, String name, String content){
        this.parent=parent;
        this.name=name;
        this.content=content;
    }
    private void displayFileContent(){
        System.out.println("File name: "+ this.name);
        System.out.println("File content: "+ this.content);
    }
    private Directory moveFile(Directory newParent){
        newParent.getFiles().add(this);
        this.parent.getFiles().remove(this);
        this.parent=newParent;
        return newParent;
    }
    public String getName(){
        return this.name;
    }
    public Directory getParent() { return parent; }

}
