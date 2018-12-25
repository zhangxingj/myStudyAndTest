package com.quickbooks;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class QuickBooksConTest {
	public static void main(String[] args) {
		String token="eyJlbmMiOiJBMTI4Q0JDLUhTMjU2IiwiYWxnIjoiZGlyIn0..vyI5ItoqzAHjHb9DfAk_dw.ompXmDNlI2pWnY5tVueIO-rslPmNps5A-4BEdFuC8IIwwwut-GagD3qTXuxgesalhCGWj3iKxMTsxxZeQeuzCU54vv1mNoc37nxojj41SSJp4LLR5gliVz-R2aR6fWzrfv2nKEM_XZTgzlM4Pxl3fIBcEN2osY--cr1l3KKfSIib4KHWbifhs3nSw6SaZ2R9oguWK2Mb7SryxGwzdwqgdzGCWqX9nPAwZ5kYZjSNvOZS0c_0dbOK2jOTWhP2Rz7nje8lgT-phiYuVuIuStodg8_eembAU3Mbir0tbIe-qqResH6RucvpwfAcz7DYukzzheUuY-he0gFy5DzbsYaXcflQ-795jOuJuXIcqIDXL8mnrB2tjdX3bQJXEFYogJwb8fOWkoUrJ-OeL4JZvyO_I0m4SXlPaoIG2IrN4pEwXaKMr9IWKDmY8e0Z1VUtpZUFY_2WLlKJXEAl5GZ183EJxYOxnRZfropjwWlpOw6UrTRv3b2UckHsUl-lJOqxJKgIkXHLyPly6EOY3_NLyhuLDhyiGxz4EUx7SCfqgcYld9DB83KDXmwwjKPB9lwRzGSs1gDbi34eipo8-lXzCgQMT0YVNtFDgbX_L5Wxp60s76qyZX9gLP1u30PeYinD2cmYfppcDy5V73DaIo7RFmKDtqjcVWJHCmw3bbWmqeJrNR-pCn_4tYwENJupYGuIA06meEEw5SOMSlhuIcepmhibECypmoTiLoVBfa5V7QP2wGHEaKjRspZQD7o9_k7z9IT2a5pv5zISO_1qM1pYGcY_1ig5IgJzEzKHMVWAtyN4MnJP4qnRg5hQbIr3uU6SJtki.w0X9f4iL-q_re1vSgRLaGA";
		try {
			System.setProperty("https.protocols", "TLSv1,TLSv1.2,TLSv1.1,SSLv3");
			HttpURLConnection conn = null;
			//URL url = new URL("https://testdev.cloudcc.com/es/createIndex");
			URL url = new URL("https://quickbooks.api.intuit.com/v3/company/123146219376269/invoice/6/send?sendTo=caption2005@gmail.com");
			conn = (HttpURLConnection) url.openConnection();
			conn.setReadTimeout(20000);
			conn.setRequestMethod("POST");
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setRequestProperty("Authorization", "Bearer "+token);
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
			OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream(),"UTF-8");
			//out.write("");
			out.flush();
			out.close();
			conn.connect();
			int code = conn.getResponseCode();
			System.out.println(code);
			InputStream in = conn.getInputStream();
			BufferedReader read = new BufferedReader(new InputStreamReader(in, "UTF-8"));
			String str=null;
			StringBuffer buf = new StringBuffer();
			while((str=read.readLine())!=null){
				buf.append(str);
			}
			System.out.println(buf.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
