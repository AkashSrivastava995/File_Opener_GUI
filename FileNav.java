import java.awt.*;
import java.awt.event.*;
import java.awt.Desktop.*;
import java.io.*;
public class filenav{
  Frame f;  static Choice files;static String root,fileSelected="",path;String finalPath;
    
public filenav(){
f=new Frame("File Navigation");
f.setSize(500,500);
f.setVisible(true);
f.setLayout(new GridLayout(3,1));
f.addWindowListener(new WindowAdapter(){
public void windowClosing(WindowEvent we){
System.exit(0);
}
});
Label header=new Label("Welcome to File Navigation System");
header.setAlignment(Label.CENTER);

Label menu=new Label("Choose the File :");
menu.setAlignment(Label.LEFT);
files=new Choice();

root="C:/Users/akash/Downloads";
path=root;
//System.out.println(path);
File f2=new File(path);
String[] paths=f2.list();
for(String temp:paths){
files.add(temp);
}

Button b1=new Button("Submit");
b1.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae)
{
fileSelected=files.getItem(files.getSelectedIndex());
 finalPath=root+"/"+fileSelected;
 try {
            run();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
}
});
Panel p=new Panel();
p.add(b1);
Panel p2=new Panel();
p2.setLayout(new GridLayout(2,1));
p2.add(menu);
p2.add(files);
f.add(header);
f.add(p2);
f.add(p);
f.revalidate();
}
public static void main(String args[])
{
filenav f1=new filenav();
}
public void run()throws IOException
{
File f3=new File(finalPath);    
Desktop.getDesktop().open(f3);
}
}
