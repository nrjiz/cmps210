/*Problem1:
Disk size
Operating systems organize directories and files as trees. The internal nodes of the tree represent directories.
Each directory has children directories and children files. Leaf-nodes are either empty directories or files. A node
representing a file also keeps the size of the file on disk.
a) Write a data structure that represents the directory-file tree.
b) Write a traversal algorithm that traverses a directory-file tree and returns the total size of the content of
the top-level directory on disk. Assume that the data of each directory requires a total of 1KB of disk
storage*/
import java.util.*;
 class node{
  String name;
  boolean isFile;
  int size;
  List<node> children;

public node (String name, boolean isFile, int size){
  this.name=name;
  this.isFile=isFile;
  this.size=size;
  children=new ArrayList<node>();
}
}
 class tree{
  node root;
  public tree(node root){
    this.root=root;
  }
  int getTotalSize(){
    return getTotalSize(root);
  }
  int getTotalSize(node root){
    if(root==null)return 0;
    int size_ = root.isFile?root.size:0;
    for (node child:root.children){
        size_+=getTotalSize(child);
    }
    return size_;
  }
}

public class Main{
  public static void main (String[]args){
    node file1 = new node("something",true,2000);
    node file2 = new node("cute",true,500);
    node dir1 = new node("dir",false,0);
    node dir2 = new node("dir",false,0);


    dir1.children.add(file1);
    dir2.children.add(file2);

    node direMain = new node("main",false,0);
    direMain.children.add(dir1);
    direMain.children.add(dir2);
    
    tree os = new tree(direMain);    

    int totalSize = os.getTotalSize();
    System.out.println("Total size of top-level directory: " + totalSize + "KB");
  
  }
}
