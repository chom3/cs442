package genericCheckpointing.server;

import genericCheckpointing.util.SerializableObject;
import genericCheckpointing.server.SerStrategy;
import java.lang.reflect.Method;
import java.io.File;
import java.lang.String;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;


public interface SerStrategy {
    public void processInput(Object sObject, Method m, File output);
}