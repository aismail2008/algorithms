package com.code.test.problemset.companies.Flex;

import java.io.File;
import java.util.*;

public class Flex {
   // roblem statement: Write an algorithm that will take two dates and tell you if they are more than a month apart,
   // less than a month apart or exactly a month apart.
    // -1 less than a month apart
    // 1 more than a month apart
    // 0 equal

    public int monthApart(Date firstDate, Date secondDate){
        //int firstYear = Calendar.getInstance(date).get(Calendar.YEAR);
        //int secondYear = Calendar.getInstance(date).get(Calendar.YEAR);
        //
        //int firstMonth = Calendar.getInstance(date).get(Calendar.YEAR);
        //int secondMonth = Calendar.getInstance(date).get(Calendar.MONTH);

        if(firstDate.equals(secondDate)){
            return -1; // equal dates
        }

        if(firstDate.after(secondDate)){
            Date tempDate = firstDate;
            firstDate = secondDate;
            secondDate = tempDate;
        }


        //   FS
        Calendar calendarFirst = Calendar.getInstance();
        calendarFirst.setTime(firstDate);
        calendarFirst.add(Calendar.MONTH, 1);

        Calendar calendarSecond = Calendar.getInstance();
        calendarFirst.setTime(secondDate);

        if(calendarSecond.equals(calendarFirst)){
            return  0; // extacly one month apart
        }else if(calendarSecond.before(calendarFirst)){
            return -1; // less than or equal to one month
        }else {
            return 1;// more than one month apart
        }
    }
// ===============================================================================================
    /*
     * - Files that have a given size requirement.
     * - Files with a certain naming pattern.
     */

    /*
     - List<String> listFile(int sizeInBytes, SizeRequirment);

     - List<String> listFile(String pattern);

    */
    static enum SizeRequirment{
        EQUAL, LESS, GREATER, LESS_EUQAL, //..;
    }

    public List<String> listFile(String pattern, File root){
        List<String> filesList = new ArrayList<>();
        Queue<File> filesQueue = new LinkedList<>();
        filesQueue.offer(root);
        while(!filesQueue.isEmpty()){
            File dir = filesQueue.poll();

            File[] fileList = dir.listFiles();
            for(File f : fileList){
                if(f.isDirectory()){
                    filesQueue.offer(f);
                }else if(f.getAbsolutePath().matches(pattern)){
                    filesList.add(f.getAbsolutePath());
                }
            }
        }
        return filesList;
    }


//    private List<String> findFiles(Directory root, Predecator<File> Predecator){
//        List<String> filesList = new ArrayString<>();
//        Queue<File> filesQueue = new LinkedList<>();
//        filesQueue.offer(root);
//        while(!filesQueue.isEmpty()){
//            Directory dir = filesQueue.poll();
//
//            Files[] fileList = dir.listFiles();
//            for(File f : fileList){
//                if(f.isDirectory()){
//                    filesQueue.offer(f);
//                }else if(Predecator.check(f)){
//                    filesList.add(f.fullPath());
//                }
//            }
//        }
//        return filesList;
//    }
//
//    interface Checker{
//        abstract boolean check(File f);
//    }
//
//    class SizeRequirementChecker implements Checker{
//        abstract boolean check(File f);
//    }
//
//    public List<String> listFile(int sizeInBytes, SizeRequirment sizeReq, Directory root){
//        return findFiles(root, new Checker(){
//            boolean check(file){
//                switch(sizeReq):
//                case EQUAL:
//                if(fsizeInBytes() == sizeInBytes)
//                    return true;
//                break;
//                case LESS:
//                if(fsizeInBytes() < sizeInBytes)
//                    true
//                break;
//                case GREATER:
//                if(fsizeInBytes() > sizeInBytes)
//                    filesList.add(f.fullPath());
//                break;
//                    ...
//
//            }
//        })
//    }
//
//    public List<String> listFile(int sizeInBytes, SizeRequirment sizeReq, Directory root){
//        List<String> filesList = new ArrayString<>();
//        Queue<File> filesQueue = new LinkedList<>();
//        filesQueue.offer(root);
//        while(!filesQueue.isEmpty()){
//            Directory dir = filesQueue.poll();
//
//            Files[] fileList = dir.listFiles();
//            for(File f : fileList){
//                if(f.isDirectory()){
//                    filesQueue.offer(f);
//                }else{
//                    switch(sizeReq):
//                    case EQUAL:
//                        if(fsizeInBytes() == sizeInBytes)
//                            filesList.add(f.fullPath());
//                        break;
//                    case LESS:
//                        if(fsizeInBytes() < sizeInBytes)
//                            filesList.add(f.fullPath());
//                        break;
//                    case GREATER:
//                        if(fsizeInBytes() > sizeInBytes)
//                            filesList.add(f.fullPath());
//                        break;
//                    ...
//                }
//            }
//        }
//
//        return filesList;
//    }
}
