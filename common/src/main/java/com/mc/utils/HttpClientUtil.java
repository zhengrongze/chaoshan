package com.mc.utils;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * <pre>
 * 描述：Http 请求工具类
 * 作者：xuhaowende@sina.cn
 * 日期：Jul 20, 2016 - 3:45:57 PM
 * </pre>
 */
public class HttpClientUtil {  
    
	protected static Logger logger = Logger.getLogger(HttpClientUtil.class);
	
    /** 
     * 发送GET请求，携带参数 
     * @param url 
     * @param params 
     * @return   
     * @throws Exception 
     */  
    public static String sendGetRequest(String url , Map<String , String> params){
    	long start = System.currentTimeMillis();
    	String result = null;
    	CloseableHttpClient httpClient = null;
		CloseableHttpResponse httpResponse = null;
		httpClient = HttpClients.createDefault();
		url = wrapUrlParams(url, params);
		HttpGet httpGet = new HttpGet(url);
		try {
			httpGet.setHeader("Content-Type","text/html; charset=utf-8");
			httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:34.0) Gecko/20100101 Firefox/34.0");
			httpGet.setHeader("Cache-Control", "no-cache");
			RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(60000).setConnectTimeout(60000).build();
			httpGet.setConfig(requestConfig);
			httpResponse = httpClient.execute(httpGet);
			if (httpResponse.getEntity() != null) {
				result = entityToString(httpResponse.getEntity());
			}
		} catch (Exception e) {
			logger.debug("getData Exception url: {}", url, e);
			logger.debug("http post error,", e);
		} finally {
			HttpClientUtils.closeQuietly(httpResponse);
			long interval = System.currentTimeMillis() - start;
			logger.debug("{} 请求耗时：{} ", url, interval);
		}
		return result;
    }  
    
    private static String wrapUrlParams(String url, Map<String , String> params){
    	StringBuilder sb = new StringBuilder(url);
		if (MapUtils.isNotEmpty(params)) {
			sb.append("?");
			for (Entry<String, String> entry : params.entrySet()) {
				try {
					String val = URLEncoder.encode(StringUtils.isNotBlank(entry.getValue())?entry.getValue():"","utf-8");
					sb.append(entry.getKey() + "=" + val + "&");
				} catch (UnsupportedEncodingException e) {
					continue;
				}
			}
			sb.delete(sb.length()-1, sb.length());
		}
		return sb.toString();
    }

    /**
     * 发送POST请求
     * @param url
     * @param params
     * @return
     * @throws Exception
     */
    public static String sendPostRequest(String url , Map<String , String> params){
    	long start = System.currentTimeMillis();
    	String result = null;
    	CloseableHttpClient httpClient = null;
		CloseableHttpResponse httpResponse = null;
		try {
			httpClient = HttpClients.createDefault();
			HttpPost httpPost = new HttpPost(url);
			//60秒超时
			RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(60000).setConnectTimeout(60000).build();
			httpPost.setConfig(requestConfig);
			if (MapUtils.isNotEmpty(params)) {
				List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
				for (Entry<String, String> entry : params.entrySet()) {
					nameValuePairs.add(new BasicNameValuePair(entry.getKey(), entry.getValue() == null ? "" : entry.getValue()));
				}
				HttpEntity httpEntity = new UrlEncodedFormEntity(nameValuePairs, Consts.UTF_8);
				if (httpEntity != null) {
					httpPost.setEntity(httpEntity);
				}
			}
			httpResponse = httpClient.execute(httpPost);
			if (httpResponse.getEntity() != null) {
				result = entityToString(httpResponse.getEntity());
			}
		} catch (Exception e) {
			logger.debug("http post error,", e);
		} finally {
			HttpClientUtils.closeQuietly(httpResponse);
			long interval = System.currentTimeMillis() - start;
			logger.debug("请求耗时：{} ", interval);
		}
		return result;
    }  

    /** 
     * 将HttpEntity对象转换为字符串 
     * @param entity 
     * @return 
     * @throws Exception 
     */  
    public static String entityToString(HttpEntity entity) throws Exception{
        return entity == null ?null: EntityUtils.toString(entity , "utf-8");
    }  

    public static void main(String[] args)
    {

    }
     
}