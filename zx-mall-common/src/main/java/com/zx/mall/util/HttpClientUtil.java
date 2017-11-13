package com.zx.mall.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;

import org.apache.http.HttpHost;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

public class HttpClientUtil {
	
	public static String call(String ip, int port, String url, String request, boolean needContent) throws IOException {
    	CloseableHttpClient httpClient = getHttpClient();
        CloseableHttpResponse httpResponse = null;
        try {
            // 创建请求对象
            HttpHost host = new HttpHost(ip, port);
            HttpPost httpPost = new HttpPost(url);
            if(needContent)
            	httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
            httpPost.setEntity(new StringEntity(request, "utf-8"));

            // 执行请求
            httpResponse = httpClient.execute(host, httpPost);
            // 获取返回结果
            return EntityUtils.toString(httpResponse.getEntity());
        } catch (ClientProtocolException Err) {
            throw Err;
        } catch (UnsupportedEncodingException Err) {
            throw Err;
        } catch (IOException Err) {
            throw Err;
        } finally {
            httpClient.close();
            if (null != httpResponse) {
                httpResponse.close();
            }
        }
    }
	
	private static CloseableHttpClient getHttpClient() {
        PoolingHttpClientConnectionManager clientConnectionMgr = new PoolingHttpClientConnectionManager();
        clientConnectionMgr.setDefaultMaxPerRoute(32);
        clientConnectionMgr.setMaxTotal(64);

        RequestConfig requestConfig = RequestConfig.custom()
            .setConnectTimeout(3 * 1000)
            .setConnectionRequestTimeout(5 * 1000)
            .setSocketTimeout(5 * 1000)
            .build();

        ConnectionConfig connectionConfig = ConnectionConfig.custom()
            .setCharset(Charset.forName("UTF-8"))
            .build();
        return HttpClients.custom()
            .setConnectionManager(clientConnectionMgr)
            .setDefaultRequestConfig(requestConfig)
            .setDefaultConnectionConfig(connectionConfig)
            .build();
    }
	
	public static String doPost(String url, String body) {
 		StringBuilder sb = new StringBuilder();
		OutputStream os = null;
		PrintWriter pw = null;
		BufferedReader in = null;
		HttpURLConnection uc = null;
		try {
			URL httpuser = new URL(url);
			uc = (HttpURLConnection) httpuser.openConnection();
			uc.setConnectTimeout(30000);		// 连接超时设置为30s
			uc.setReadTimeout(40000);			// 读超时设置为40s
			uc.setDoOutput(true);				// 因为这个是post请求，参数要放在http正文内，因此需要设为true，默认情况下是false
			uc.setUseCaches(false);				// post请求不能使用缓存
			// 设定传送的内容类型是可序列化的java对象(如果不设此项,在传送序列化对象时,当WEB服务默认的不是这种类型时可能抛java.io.EOFException) 
			uc.setRequestProperty("Content-type", "application/json;charset=utf-8");
			
			uc.setRequestMethod("POST");	// 设定请求的方法为"POST"，默认是GET  
			uc.connect();
			
			os = uc.getOutputStream();
			OutputStreamWriter out = new OutputStreamWriter(os, "utf-8");
			pw = new PrintWriter(out);
			pw.print(body);
			pw.flush();
			
			// 获取服务器端返回信息
			in = new BufferedReader(new InputStreamReader(uc.getInputStream(), "utf-8"));
			String inputLine = null;
			while((inputLine = in.readLine()) != null){
				sb.append(inputLine).append("\r\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			//释放资源
			try {
				if (pw != null) {
					pw.close();
					pw = null;
				}
				if (os != null) {
					os.close();
					os = null;
				}
				if (in != null) {
					in.close();
					in = null;
				}
				if (uc != null) {
					uc.disconnect();
					uc=null;
				}
			} catch (Exception ex) {
				System.out.println("释放资源异常" + ex);
			}
		}
		return sb.toString();
	}

}