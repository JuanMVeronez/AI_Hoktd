package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.List;

import entity.Action;
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

	public static String getSolutionFileName(String instanceFileName) {
		String solutionFileName = instanceFileName.replace("inst", "sol").replace(".in", ".out");
		return solutionFileName;
	}

	public static void writeSolution(List<Action> actions, String file) {
		try {
			String fileName = getSolutionFileName(file);
			FileWriter fileWriter = new FileWriter(fileName);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			
			for(Action action: actions) {
				bufferedWriter.write(action.toString());
			}

			bufferedWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static List<String> getFolderFiles(String folder) {
		List<String> files = new LinkedList<>();
		File[] folderFiles = new File(folder).listFiles();
		for(File file: folderFiles) {
			files.add(folder + "/" + file.getName());
		}
		return files;
	}
}
