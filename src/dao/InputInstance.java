package dao;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import entity.Table;

public class InputInstance {
	
	public static Table getInstance(String file) {
        Table table = null;

		InputStream is;
		InputStreamReader isr;
		BufferedReader br;
		
		try {
			
			is = new FileInputStream(file);
			isr = new InputStreamReader(is, StandardCharsets.UTF_8);
			br = new BufferedReader(isr);
			
            int N = Integer.parseInt(br.readLine());
            char[][] tableMap = new char[N][N];
			
            int i = 0;
            String line;
            while( ( line = br.readLine() ) !=null) {
				tableMap[i] = line.toCharArray();
                i++;
            }

            table = new Table(N, tableMap).startGame();
		}catch(IOException e) {
			e.printStackTrace();
		}

        return table;
	}
}
