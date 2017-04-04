package Prepare;

import java.io.*;
import java.util.ArrayList;

/**
 * the class that operate with the file
 * @author Tianyi Chen
 * @version 2015-5-1
 */
public abstract class FileOperator{
    /**
     * the split word to separate different columns in the file
     */
    public final static String SPLIT_WORD=";";
    /**
     * the file that the FileOperator is operating
     */
    public File file;

    /**
     * the FileReader of file
     */
    public FileReader fr;

    /**
     * the BufferedReader of the file
     */
    public BufferedReader br;
    /**
     * path of the file;
     */
    private String path;
    /**
     * the file's name
     */
    private String fileName;
    /**
     * constructor of the class FileOperator
     * construct a file with given file name
     * @param path
     */
    public FileOperator(String path){
        File dir=new File(path);
        dir.mkdir();
        this.path=dir.getAbsolutePath();
    }  
    /**
     * constructor of the class FileOperator
     * construct a file with given file name
     * @param fileName 
     * @param path
     */
    public FileOperator(String fileName,String path){
        File dir=new File(path);
        dir.mkdir();
        this.path=dir.getAbsolutePath();
        this.fileName=this.path+"/"+fileName;
        file=new File(this.fileName);
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }  
    /**
     * setter of fileName
     * @param fileName 
     */
    public void setFileName(String fileName){
        this.fileName=this.path+"/"+fileName;
        file=new File(this.fileName);
    }
    /**
     * append one record at the end of the file
     * @param record 
     */
    protected void appendRec(String record){
    	try{
            file=new File(fileName);
            FileWriter fr=new FileWriter(file,true);
            PrintWriter br=new PrintWriter(fr);
            br.println(record);
            fr.close();
        }catch(Exception e){
            System.out.println("append file error");
        }            
    }
    
    /**
     * refresh the file with current record list
     * @param recordList 
     */
    protected void refresh(ArrayList<String> recordList){
    	try{    //first delete the file
                file=new File(fileName);
        	file.delete();
        	file.createNewFile();
    		FileWriter fr=new FileWriter(file);
                BufferedWriter buff=new BufferedWriter(fr);
                for (String recordList1 : recordList) {
                    buff.write(recordList1);
                    buff.newLine();
                }
            buff.flush();
            buff.close();
            fr.close();
        }catch(Exception e){
            System.out.println("refresh account file error");
        }            
    }
    
    /**
     * get record from the file;
     * @return record list
     */
    public ArrayList<String> getRecord(){
    	ArrayList<String> recordList=new ArrayList<>();
    	try{	
            file=new File(fileName);
            FileReader fr=new FileReader(file);
            BufferedReader buff=new BufferedReader(fr);
            String tmp=buff.readLine();
            while(tmp!=null){
            	recordList.add(tmp);
            	tmp=buff.readLine();
            }
            buff.close();
            fr.close();
        }catch(Exception e){
            System.out.println("open account file error");
        }
    	return recordList;
    }
    
    /**
     * deleteFile
     * @return file delete successful or not
     */
    public boolean deleteFile(){
        file=new File(this.fileName);
    	if (file.exists())
    		return file.delete();
    	return true;
    }
}
