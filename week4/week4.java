/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 *
 * @author harish
 */
public class PS44 {
    int loopcreate;
    public static void PrintDict(Map<String,TreeSet<String>> map)
    {
        System.out.print("SYNONYM DICTIONARY::\n");
        TreeSet<String> temp_set_for_values=new TreeSet<String>();
        for(String key: map.keySet())
        {
            System.out.println(key+"--->");
            temp_set_for_values=(TreeSet)map.get(key);
            Iterator itr_for_valueset=temp_set_for_values.iterator();
            while(itr_for_valueset.hasNext())
            {
                System.out.println("\t\t\t"+itr_for_valueset.next());
            }
            System.out.print("\n");

        }
    }
    public static void PrintDictforkey(Map<String,TreeSet<String>> map,String user_key)
    {
        System.out.print("SYNONYMS FOR THE WORD "+user_key+" ARE::\n");
        TreeSet<String> valueset_for_userinput=new TreeSet<String>();
        System.out.println(user_key+"--->");
        valueset_for_userinput=(TreeSet) map.get(user_key);
        Iterator itr_for_valueset=valueset_for_userinput.iterator();
        while(itr_for_valueset.hasNext())
        {
            System.out.println("\t\t\t"+itr_for_valueset.next());
        }
    }
    public static void main(String args[])
    {
        //creation of the dictionary of the synonyms...
        Map<String,TreeSet<String>> synonyms =new TreeMap<String,TreeSet<String>>();
        try{
            File file=new File("C:\\Users\\hp\\Downloads\\synonym.txt");
            FileReader fr=new FileReader(file);
            BufferedReader br=new BufferedReader(fr);
            String line_from_file;
            line_from_file=br.readLine();
            String key_to_be="";

            while(line_from_file!=null)
            {
                if(line_from_file.equals("-"))
                {
                    line_from_file=br.readLine();
                    key_to_be=line_from_file;

                }
                else{

                    synonyms.computeIfAbsent(key_to_be,k -> new TreeSet<String>()).add(line_from_file);
                }

                line_from_file=br.readLine();
            }
            fr.close();
        }
        catch(Exception e){System.out.println(e);}
        //PrintDict(synonyms);
        //completed creating dictionary of synonyms from file.............
        boolean loop_for_input=true;
        int choice_for_syn,choice_for_add;

        Scanner scnr2= new Scanner(System.in);
        String add_syn;
        boolean is_modified=false;
        while(loop_for_input)
        {
            System.out.println("Select the option You need..\n1.GET SYNONYM.\n2.EXIT");

            choice_for_syn=scnr2.nextInt();
            switch(choice_for_syn)
            {
                case 1: System.out.println("Give the word..");
                    final String user_input=scnr2.next();
                    String temp_ignoringcase;
                    Optional<String> new_temp_ignoringcase=synonyms.keySet().stream().filter(t -> t.equalsIgnoreCase(user_input)).findAny();
                    if(new_temp_ignoringcase.isPresent())
                    {
                        temp_ignoringcase = new_temp_ignoringcase.get();
                    }
                    else
                    {
                        temp_ignoringcase="notfound";
                    }
                    //System.out.println("thevale is "+new_temp_ignoringcase);
                    if(!temp_ignoringcase.equals("notfound"))
                    {
                        PrintDictforkey(synonyms,temp_ignoringcase);
                    }
                    else
                    {
                        System.out.println("Synonyms for the given word are unavailable..Select an option..\n1.ADD THEM\n2.IGNORE");
                        choice_for_add=scnr2.nextInt();
                        switch(choice_for_add)
                        {
                            case 1: System.out.println("Give the Synonyms one after other and type 'q' to stop..");
                                scnr2.nextLine();
                                boolean add_bool=true;
                                //add_syn=scnr2.next();

                                String user_input_toadd = user_input.substring(0, 1).toUpperCase() + user_input.substring(1);
                                while (!(add_syn = scnr2.nextLine()).equals("")){
                                    add_syn=add_syn.substring(0, 1).toUpperCase() + add_syn.substring(1);
                                    synonyms.computeIfAbsent(user_input_toadd,k -> new TreeSet<String>()).add(add_syn);
                                    is_modified=true;

                                }
                                System.out.println("Updated Map Successfully.....");
                                PrintDict(synonyms);
                                //System.out.println("DONE");
                                break;
                            case 2: System.out.println("Ok..Ignoring the word..");
                        }
                    }
                    break;
                case 2: loop_for_input=false;
            }
        }
        if(is_modified)
        {
            System.out.println("Syncing the map");
            TreeSet<String> sync_set_for_values=new TreeSet<String>();
            try{
                FileWriter syncing=new FileWriter("C:\\Users\\harish\\Documents\\NetBeansProjects\\PS34\\src\\ps34\\synonym.txt");
                BufferedWriter sync_buff = new BufferedWriter(syncing);
                for(String key:synonyms.keySet())
                {
                    //System.out.println(key);
                    sync_buff.write("-"+"\n");
                    sync_buff.write(key+"\n");
                    sync_set_for_values=(TreeSet)synonyms.get(key);
                    Iterator sync_itr_for_valueset=sync_set_for_values.iterator();
                    while(sync_itr_for_valueset.hasNext())
                    {
                        sync_buff.write((String) sync_itr_for_valueset.next()+"\n");
                    }
                    System.out.print("\n");
                }
                sync_buff.close();
                syncing.close();
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
            System.out.println("Modified Map");
            PrintDict(synonyms);
        }
        System.out.println("Exiting the program..");

    }

}
