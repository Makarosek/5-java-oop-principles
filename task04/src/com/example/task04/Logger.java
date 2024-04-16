package com.example.task04;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Logger {

    public Level LEVEL;
    public Date DATE;
    public String NAME;
    public String MESSAGE;
    public static List<Logger> allLoggers;
    public Level currentLevel;

    public Logger(String name){
        NAME = name;
    }
    public Logger(Level level, String name, String message) {
        LEVEL = level;
        NAME = name;
        DATE = new Date();
        MESSAGE = message;

        allLoggers.add(this);
    }

    public String getName() {
        return NAME;
    }

    public static Logger getLogger(String name){
        for(int i = 0; i < allLoggers.size(); i++){
            if(allLoggers.get(i).NAME == name){
                return allLoggers.get(i);
            }
        }
        return new Logger(name);
    }

    @Override
    public String toString() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
        String str = LEVEL.toString() + DATE + NAME + MESSAGE;


        return "[" + LEVEL + "] "+ format.format(DATE) + " " + NAME + " " + MESSAGE;
    }

    public enum Level {
        DEBUG,
        INFO,
        WARNING,
        ERROR
    }

    public void debug(String message){
        this.MESSAGE = message;
    }

    public void debug(String format, Object ... args){
        this.MESSAGE = String.format(format, Arrays.stream(args).toArray());
    }

    public void info(String message){
        this.MESSAGE = message;
    }

    public void info(String format, Object ... args){
        this.MESSAGE = String.format(format, Arrays.stream(args).toArray());
    }
    public void warning(String message){
        this.MESSAGE = message;
    }

    public void warning(String format, Object ... args){
        this.MESSAGE = String.format(format, Arrays.stream(args).toArray());
    }

    public void error(String message){
        this.MESSAGE = message;
    }

    public void error(String format, Object ... args){
        this.MESSAGE = String.format(format, Arrays.stream(args).toArray());
    }


    public void setLevel(Level level){
        currentLevel = level;
    }

    public Level getLevel(){
        return currentLevel;
    }

}
