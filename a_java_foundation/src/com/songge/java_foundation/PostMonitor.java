package com.songge.java_foundation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**  
* @ClassName: PostMonitor  
* @Description: TODO(������һ�仰��������������)  
* @author songge  
* @date 2018��1��30��  
*    
*/
public class PostMonitor {

	/**  
	* @Title: main  
	* @Description: TODO(������һ�仰�����������������)  
	* @param @param args    ����  
	* @return void    ��������  
	* @throws  
	*/
	public static void main(String[] args) {
		PostMonitor postMonitor = new PostMonitor();
		try {
			postMonitor.sendPost("http://localhost:8881/bus/refresh","");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

    /**
     * @���� ʹ��urlconnection
     * @param url
     * @param Params
     * @return
     * @throws IOException
     */
    public String sendPost(String url,String Params)throws IOException{
        OutputStreamWriter out = null;
        BufferedReader reader = null;
        String response="";
        try {
            URL httpUrl = null; //HTTP URL�� �����������������
            //����URL
            httpUrl = new URL(url);
            //��������
            HttpURLConnection conn = (HttpURLConnection) httpUrl.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("connection", "keep-alive");
            conn.setUseCaches(false);//���ò�Ҫ����
            conn.setInstanceFollowRedirects(true);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.connect();
            //POST����
            out = new OutputStreamWriter(
                    conn.getOutputStream());
            out.write(Params);
            out.flush();
            //��ȡ��Ӧ
            reader = new BufferedReader(new InputStreamReader(
                    conn.getInputStream()));
            String lines;
            while ((lines = reader.readLine()) != null) {
                lines = new String(lines.getBytes(), "utf-8");
                response+=lines;
            }
            reader.close();
            // �Ͽ�����
            conn.disconnect();

            System.out.println(response.toString());
        } catch (Exception e) {
        System.out.println("���� POST ��������쳣��"+e);
        e.printStackTrace();
        }
        //ʹ��finally�����ر��������������
        finally{
        try{
            if(out!=null){
                out.close();
            }
            if(reader!=null){
                reader.close();
            }
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
    }

        return response;
    }
}
