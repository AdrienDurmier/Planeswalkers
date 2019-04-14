package com.acka.planeswalkers.Controllers.Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Classe réalisant les appels réseaux
 * @author Adrien Durmier
 */
public class MyHttpURLConnection {

    public static String startHttpRequest(String urlString){
        StringBuilder stringBuilder = new StringBuilder();

        try{
            // Ouverture d'une connexion HTTP
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            // Ouverture d'un canal et récupère le flux de données de cette URL
            conn.connect();
            InputStream in = conn.getInputStream();
            // Lecture du flux de données brut pour le retournée dans une variable de type string
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String line;
            while((line = reader.readLine()) != null){
                stringBuilder.append(line);
            }
        } catch (MalformedURLException exception) {

        } catch (IOException exception) {

        } catch (Exception e) {

        }

        return stringBuilder.toString();
    }
}
