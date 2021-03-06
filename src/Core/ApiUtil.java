package Core;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;

public class ApiUtil {
    //http://ec2-3-0-97-144.ap-southeast-1.compute.amazonaws.com:8080/article/category/political?token=

    private static String API = "&apiKey=" + "3249e937bdde4f27bc283ab7219b1142";
    private static String cat = "political";
    private static String base_url = "http://ec2-3-0-97-144.ap-southeast-1.compute.amazonaws.com:8080/article/category/";
    private static HttpURLConnection con;
    private static String token = "";
    private static StringBuilder content;
    private static String url = base_url + cat +"?token=" + token;


    public ApiUtil() {

    }


    public static JSONObject callAPI() throws MalformedURLException, ProtocolException, IOException {
        try {

            URL myurl = new URL(url);
            con = (HttpURLConnection) myurl.openConnection();

            con.setRequestMethod("GET");

            try (BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()))) {
                String line;
                content = new StringBuilder();
                while ((line = in.readLine()) != null) {
                    content.append(line);
                    content.append(System.lineSeparator());
                }
            }
//            System.out.println(content.toString());
            return strToJson(content.toString());

        } finally {
            con.disconnect();
        }
    }
    public static JSONObject callAPI(String urll) throws MalformedURLException, ProtocolException, IOException {
        try {

            URL myurl = new URL(urll);
            con = (HttpURLConnection) myurl.openConnection();

            con.setRequestMethod("GET");

            try (BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()))) {
                String line;
                content = new StringBuilder();
                while ((line = in.readLine()) != null) {
                    content.append(line);
                    content.append(System.lineSeparator());
                }
            }
//            System.out.println(content.toString());
            return strToJson(content.toString());

        } finally {
            con.disconnect();
        }
    }
    public static JSONArray callJsonArray(String urll)throws MalformedURLException, ProtocolException, IOException{
        try {
            URL myurl = new URL(urll);
            con = (HttpURLConnection) myurl.openConnection();

            con.setRequestMethod("GET");

            try (BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()))) {
                String line;
                content = new StringBuilder();
                while ((line = in.readLine()) != null) {
                    content.append(line);
                    content.append(System.lineSeparator());
                }
            }
//            System.out.println(content.toString());
            return strToJsonArr(content.toString());

        } finally {
            con.disconnect();
        }
    }
    public static JSONObject callJson(String urll)throws MalformedURLException, ProtocolException, IOException{
        try {
            URL myurl = new URL(urll);
            con = (HttpURLConnection) myurl.openConnection();

            con.setRequestMethod("GET");

            try (BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()))) {
                String line;
                content = new StringBuilder();
                while ((line = in.readLine()) != null) {
                    content.append(line);
                    content.append(System.lineSeparator());
                }
            }
            System.out.println(content.toString());
            return strToJson(content.toString());

        } finally {
            con.disconnect();
        }
    }

    public static JSONObject strToJson(String s) {
        JSONObject jo = new JSONObject(s);
        return jo;
    }
    public static JSONArray strToJsonArr(String s) {
        JSONArray jo = new JSONArray(s);
        return jo;
    }


    public static void setCat(String cat) {
        url = base_url + cat +"?token=" + token;

    }

    public static JSONArray getSelectedArticles(String[] cats) throws Exception {
        JSONArray artPool = new JSONArray();
        boolean isRandom = false;
        for(String cat : cats){
            if(cat.equals("Random")){
                isRandom = true;
            }
        }
        if(isRandom){
            for (int i = 0; i < cats.length; i++) {
                cat = cats[i];
                url = "http://ec2-3-0-97-144.ap-southeast-1.compute.amazonaws.com:8080/article/all?token="+token;
                artPool.put(callAPI().getJSONArray("articles"));
            }
        }else{
            for (int i = 0; i < cats.length; i++) {
                cat = cats[i];
                url = base_url + cat +"?token=" + token;
                System.out.println(url);
                artPool.put(callAPI().getJSONArray("articles"));
            }
        }
        return artPool;
    }

    public static ArrayList<HashMap> getData(JSONArray ja) {
        ArrayList<HashMap> temp = new ArrayList<>();

        for (int i = 0; i < ja.length(); i++) {
            for (int j = 0; j < ja.getJSONArray(i).length(); j++) {
                HashMap<String, String> data = new HashMap<>();
                data.put("title", ja.getJSONArray(i).getJSONObject(j).getString("title"));
                data.put("url", ja.getJSONArray(i).getJSONObject(j).getString("url"));
                data.put("urlToImage", ja.getJSONArray(i).getJSONObject(j).get("urlToImage").toString());
                data.put("id", ja.getJSONArray(i).getJSONObject(j).get("id").toString());
                temp.add(data);
            }
        }
        return temp;
    }


    public static String loginRequest(String email, String password) throws IOException{
        URL url = new URL("http://ec2-3-0-97-144.ap-southeast-1.compute.amazonaws.com:8080/user/auth");
        Map<String, Object> params = new LinkedHashMap<>();
        params.put("email", email);
        params.put("password", password);
        StringBuilder postData = new StringBuilder();
        for (Map.Entry<String, Object> param : params.entrySet()) {
            if (postData.length() != 0) postData.append('&');
            postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
            postData.append('=');
            postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
        }
        byte[] postDataBytes = postData.toString().getBytes("UTF-8");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
        conn.setDoOutput(true);
        conn.getOutputStream().write(postDataBytes);

        Reader in;
        try {
            in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            StringBuilder data = new StringBuilder();
            for (int c; (c = in.read()) >= 0; ) {
                data.append((char) c);
            }
            String intentData = data.toString();
            JSONObject jo = new JSONObject(intentData);
            String token = jo.getString("token");
//        System.out.println(token);
            if (conn.getResponseCode() == 200) {
                return token;
            }else {
                return null;
            }
        }catch (Exception ex){
            return null;
        }

    }
    public static boolean regisRequest(String email, String name, String password, String cat) throws IOException {

//        String payload = "name="+name+"&email="+email+"&password"+password+"&interested_category"+cat[0];
        URL url = new URL("http://ec2-3-0-97-144.ap-southeast-1.compute.amazonaws.com:8080/user/create");
        Map<String, Object> params = new LinkedHashMap<>();
        params.put("email", email);
        params.put("name", name);
        params.put("password", password);
        params.put("interested_category", cat);
        StringBuilder postData = new StringBuilder();
        for (Map.Entry<String, Object> param : params.entrySet()) {
            if (postData.length() != 0) postData.append('&');
            postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
            postData.append('=');
            postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
        }
        byte[] postDataBytes = postData.toString().getBytes("UTF-8");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
        conn.setDoOutput(true);
        conn.getOutputStream().write(postDataBytes);

        Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
        StringBuilder data = new StringBuilder();
        for (int c; (c = in.read()) >= 0; ) {
            data.append((char) c);
        }
        String intentData = data.toString();

//        System.out.println(intentData);
        if (conn.getResponseCode() == 200) {
            return true;
        }else {
            return false;
        }
    }

    public static String updateCat(String cat) throws Exception{
        URL url = new URL("http://ec2-3-0-97-144.ap-southeast-1.compute.amazonaws.com:8080/user/category/update?token="+token);
        Map<String, Object> params = new LinkedHashMap<>();
        params.put("category", cat);
        StringBuilder postData = new StringBuilder();
        for (Map.Entry<String, Object> param : params.entrySet()) {
            if (postData.length() != 0) postData.append('&');
            postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
            postData.append('=');
            postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
        }
        byte[] postDataBytes = postData.toString().getBytes("UTF-8");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
        conn.setDoOutput(true);
        conn.getOutputStream().write(postDataBytes);

        Reader in;
        try {
            in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            StringBuilder data = new StringBuilder();
            for (int c; (c = in.read()) >= 0; ) {
                data.append((char) c);
            }
            String intentData = data.toString();

            if (conn.getResponseCode() == 200) {
                return "Yes";
            }else {
                return null;
            }
        }catch (Exception ex){
            return null;
        }

    }
    public static void setToken(String e) {
        token=e;
    }

    public static String getToken() {
        return token;
    }
    public static void saveId(String id){
        try {
            String tempUrl = "http://ec2-3-0-97-144.ap-southeast-1.compute.amazonaws.com:8080/user/read/save/"+id+"?token="+token;
            System.out.println(tempUrl);
            URL myurl = new URL(tempUrl);
            con = (HttpURLConnection) myurl.openConnection();

            con.setRequestMethod("GET");

            try (BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()))) {
                String line;
                content = new StringBuilder();
                while ((line = in.readLine()) != null) {
                    content.append(line);
                    content.append(System.lineSeparator());
                }
            }catch (Exception xe){xe.printStackTrace();}
//            System.out.println(content.toString());
//            return strToJson(content.toString());

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            con.disconnect();
        }
    }
    public static void readId(String id){
        try {
            String tempUrl = "http://ec2-3-0-97-144.ap-southeast-1.compute.amazonaws.com:8080/user/read/"+id+"?token="+token;
            System.out.println(tempUrl);
            URL myurl = new URL(tempUrl);
            con = (HttpURLConnection) myurl.openConnection();

            con.setRequestMethod("GET");

            try (BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()))) {
                String line;
                content = new StringBuilder();
                while ((line = in.readLine()) != null) {
                    content.append(line);
                    content.append(System.lineSeparator());
                }
            }
//            System.out.println(content.toString());
//            return strToJson(content.toString());

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            con.disconnect();
        }
    }
    public static HashMap<String, String> getReadList() throws Exception{
        HashMap<String, String> temp = new HashMap<>();
        String url = "http://ec2-3-0-97-144.ap-southeast-1.compute.amazonaws.com:8080/user/history?token="+token;
        JSONArray ja = callAPI(url).getJSONArray("articles");
        for(int i=0;i<ja.length();i++){
            temp.put(ja.getJSONObject(i).getString("title"), ja.getJSONObject(i).getString("url"));
        }
        return temp;
    }
    public static HashMap<String, String> getSaveList() throws Exception{
        HashMap<String, String> temp = new HashMap<>();
        String url = "http://ec2-3-0-97-144.ap-southeast-1.compute.amazonaws.com:8080/user/getsave?token="+token;
        System.out.println(url);
        JSONArray ja = callAPI(url).getJSONArray("articles");
        for(int i=0;i<ja.length();i++){
            temp.put(ja.getJSONObject(i).getString("title"), ja.getJSONObject(i).getString("url"));
        }
        return temp;
    }

    public static String getUserCat() throws MalformedURLException, ProtocolException, IOException{
        JSONArray ja = callJsonArray("http://ec2-3-0-97-144.ap-southeast-1.compute.amazonaws.com:8080/user/category?token="+token);

        String temp ="";
        for(int i=0;i<ja.length();i++){
            if(i==0){
                temp = ja.get(i).toString();
            }else{
                temp += ","+ja.get(i).toString();
            }
        }
        return temp;
    }
}
