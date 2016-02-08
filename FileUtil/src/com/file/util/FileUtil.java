package com.file.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FileUtil {

	public static final int P_SIZE = 256000;

	public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
																			

		String pathName = "seed/sample.ppt";

																			
		createPeices(pathName, "seed/");

		String torrentFilePath = "seed/sample.ppt.torrent";

																			
		Map<String, Object> metainfo = readMetaInfoFile(torrentFilePath);
		

																			// recreate the complete file from parts
		String recreatedDir = "seed";
		String recreatedName = "rec-file.ppt";
		
		recreate(recreatedDir, recreatedName, 6);
	}
	

	
	public static void createMetaInfoFile(String fName, long fLength,
			int pLength, String pHash, String destinationDir) throws IOException {
		
		
		
		StringBuilder Filecontent = new StringBuilder();
		String trackerURL = "http://localhost:8080/Tracker/rest.tracker?file="+ fName;
		
		Filecontent.append("4:info");
		Filecontent.append("d");

		Filecontent.append("3:url");
		Filecontent.append(trackerURL.length() + ":" + trackerURL);
	
		Filecontent.append(fName.length() + ":" + fName + "i" + fLength+ "e" + "i" + pLength + "e");
		Filecontent.append("l");
		Filecontent.append(pHash.length() + ":" + pHash);
		Filecontent.append("e");	Filecontent.append("e");

		

																							
		String torrentFile = destinationDir + fName + ".torrent";
		BufferedWriter bwt = null;
		
			bwt = new BufferedWriter(new FileWriter(new File(torrentFile)));
			bwt.write(Filecontent.toString());
			bwt.close();
		
				if (bwt != null) {
					bwt.close();
					}
	}	
	
	
	
	
	public static Map<String, Object> readMetaInfoFile(String path) throws IOException {
		BufferedReader brd = null;
		File Nfile = new File(path);
		char[] bufer = new char[(int) Nfile.length()];
		
									
			brd = new BufferedReader(new FileReader(new File(path)));
			brd.read(bufer);
			brd.close();		
			
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < bufer.length; i++) {
			sb.append(bufer[i]);
		}
		
		String metaInfo = sb.toString();metaInfo = metaInfo.substring(8);
		String fileNameLengthString = metaInfo.substring(0,metaInfo.indexOf(":"));
		int fileNameLength = Integer.parseInt(fileNameLengthString);
		metaInfo = metaInfo.substring(metaInfo.indexOf(":") + 1);
		String fileName = metaInfo.substring(0, fileNameLength);
		metaInfo = metaInfo.substring(fileNameLength + 1);
		String fileLengthString = metaInfo.substring(0, metaInfo.indexOf("e"));
		int fileLength = Integer.parseInt(fileLengthString);
		metaInfo = metaInfo.substring(fileLengthString.length() + 2);
		String pieceLengthString = metaInfo.substring(0, metaInfo.indexOf("e"));
		int pieceLength = Integer.parseInt(pieceLengthString);
		metaInfo = metaInfo.substring(pieceLengthString.length() + 1);
		String piecesHashLengthString = metaInfo.substring(0,metaInfo.indexOf(":"));
		metaInfo = metaInfo.substring(piecesHashLengthString.length() + 1);
		String piecesHash = metaInfo.substring(0, metaInfo.indexOf("3:url") - 1);
		metaInfo = metaInfo.substring(metaInfo.indexOf("3:url") + 5);
		String urlLengthString = metaInfo.substring(0, metaInfo.indexOf(":"));
		metaInfo = metaInfo.substring(urlLengthString.length() + 1);
		String url = metaInfo.substring(0, metaInfo.length() - 1);

																				
		Map<String, Object> metainfoMap = new HashMap<String, Object>();
		
		metainfoMap.put("filename", fileName);
		metainfoMap.put("fileLength", fileLength);
		metainfoMap.put("pieceLength", pieceLength);
		metainfoMap.put("piecesHash", piecesHash);
		metainfoMap.put("url", url);

		return metainfoMap;

	}
													
	
	public static boolean recreate(String recreatedDir, String recreatedName, int nParts) throws IOException {
		recreatedDir = recreatedDir.replace("/", "");
		FileOutputStream Fstream = null;
		Fstream = new FileOutputStream(new File(recreatedDir + "/" + recreatedName));
			File dir = new File(recreatedDir);
			File[] parts = dir.listFiles(new FilenameFilter() {

				@Override
				public boolean accept(File dir, String name) {
					return name.contains(".part");
				}
			});
			
			if (parts.length != 6) 
				return false;			
			File temp = new File(recreatedDir +"/" + recreatedName + ".part" + (parts.length-1));
			byte[] buffer = new byte[((parts.length - 1) * P_SIZE) + ((int) temp.length())  ];
			for (int part = 0; part < parts.length; part++) {
				String partName = recreatedDir +"/" + recreatedName + ".part" + part;
				File partFile = new File(partName);
				System.out.println("From file: " + partFile.getName()
						+ " of size: " + partFile.length());
				FileInputStream fis = new FileInputStream(partFile);
				fis.read(buffer, part * P_SIZE,(int) partFile.length());// P_SIZE);
				fis.close();
			}
			Fstream.write(buffer);
			System.out.println("Created file successfully : " + buffer.length + " bytes");
		
				if (Fstream != null) {
					Fstream.close();}
				
		return true;
	}
	

	
	
	public static void createPeices(String src, String dest) throws IOException, NoSuchAlgorithmException {

		FileInputStream fips = null;
		byte[] bufer = new byte[P_SIZE];
		StringBuilder pHash = new StringBuilder();
		MessageDigest md = null;
		
			md = MessageDigest.getInstance("SHA-1");
		

		
			File sourceF = new File(src);
			fips = new FileInputStream(sourceF);
			
			int bytesRead = fips.read(bufer, 0, bufer.length);																						
			int part = 0;
			
			for (part = 0; bytesRead == P_SIZE; part++) {
				String pFName = dest + sourceF.getName() + ".part"+ part;
				File pFile = new File(pFName);
				
				FileOutputStream fst = new FileOutputStream(pFile);
				
				fst.write(bufer);
				fst.close();
				
				byte[] mdBytes = md.digest(bufer);
				
				for (int i = 0; i < mdBytes.length; i++) {
					pHash.append(Integer.toHexString(0xFF & mdBytes[i]));
				}
							bytesRead =  fips.read(bufer,0,bufer.length);
				
			}

																							
			if (bytesRead > -1)
			{
																							
				
				bufer = Arrays.copyOf(bufer, bytesRead);
				
				String pFName = dest + sourceF.getName() + ".part"+ part;
				
				File partFile = new File(pFName);
				
				
				FileOutputStream fst = new FileOutputStream(partFile);
				fst.write(bufer);
				fst.close();
				
				System.out.println("File size: " + partFile.length());

																							
				byte[] mdBytes = md.digest(bufer);
				for (int i = 0; i < mdBytes.length; i++) {
					
					
					pHash.append(Integer.toHexString(0xFF & mdBytes[i]));
				
				}

			}
		
			createMetaInfoFile(sourceF.getName(), sourceF.length(),P_SIZE, pHash.toString(), dest);
		
			
			
			
	}

}
