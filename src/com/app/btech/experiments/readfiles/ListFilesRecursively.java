package com.app.btech.experiments.readfiles;

import java.io.File;

public class ListFilesRecursively {

	// Method to recursively list all files
	public static void listAllFiles(File dir) {
		if (!dir.exists()) {
			System.out.println("Directory does not exist.");
			return;
		}

		if (dir.isFile()) {
			System.out.println(dir.getAbsolutePath());
		} else {
			File[] files = dir.listFiles();
			if (files != null) {
				for (File file : files) {
					listAllFiles(file); // recursive call
				}
			}
		}
	}

	public static void main(String[] args) {
		// Specify the directory path here
		String directoryPath = "C:\\Users\\91879\\Desktop\\Experiments"; // change this
		File dir = new File(directoryPath);

		System.out.println("Listing all files in directory: " + directoryPath);
		listAllFiles(dir);
	}
}
