
/**
 * @author  TollscheinAle
 * @version V1.0
 */

import java.io.File;
import java.util.*;

public class ModelCheck {

    List<String> allFiles = new ArrayList<>();

    public void FolderAnalyse() {
        /**
         * Set Variables
         */
        String folderPath = "actual/Models"; // folderPath is the location of the Models

        /**
         * Instanzen
         */
        xml xml = new xml();

        /**
         * Set all Lists
         */
        List<String> non3DFiles = new ArrayList<>();
        List<String> STLFiles = new ArrayList<>();
        List<String> OBJFiles = new ArrayList<>();
        List<String> THREEMFFiles = new ArrayList<>();
        List<String> THREEDSFiles = new ArrayList<>();
        List<String> GLTFFiles = new ArrayList<>();
        List<String> X3DFiles = new ArrayList<>();
        List<String> XVLFiles = new ArrayList<>();
        List<String> JMESHFiles = new ArrayList<>();
        List<String> FBXFiles = new ArrayList<>();
        List<String> DAEFiles = new ArrayList<>();
        List<String> PLYFiles = new ArrayList<>();
        List<String> OFFFiles = new ArrayList<>();
        List<String> STEPFiles = new ArrayList<>();
        List<String> IGSFiles = new ArrayList<>();
        List<String> WRLFiles = new ArrayList<>();
        List<String> VRMLFiles = new ArrayList<>();
        List<String> DXFFiles = new ArrayList<>();
        List<String> BLENDFiles = new ArrayList<>();
        List<String> MAFiles = new ArrayList<>();
        List<String> MBFiles = new ArrayList<>();

        String[] AcceptedModelFileTypes = { "stl", "obj", "fbx", "dae", "3ds", "ply", "off", "x3d", "step", "igs",
                "wrl", "vrml", "dxf", "blend", "ma", "mb" };
        List<String> FileTypeList = Arrays.asList(AcceptedModelFileTypes);

        File folder = new File(folderPath); // Crating the file stream for the model folder
        if (folder.exists() && folder.isDirectory()) { // Check if thee is a folder
            File[] files = folder.listFiles(); // Creating a file array with all files in folder Models
            if (files != null) {
                for (File file : files) {
                    String FileSplit[] = file.getName().split("\\.");
                    if (FileTypeList.contains(FileSplit[1])) {
                        if (file.isFile()) {
                            if (file.getName().endsWith(".stl")) {
                                STLFiles.add(FileSplit[0] + " is a " + FileSplit[1].toUpperCase() + " file");
                                allFiles.add(FileSplit[0]);
                            } else if (file.getName().endsWith(".obj")) {
                                OBJFiles.add(FileSplit[0] + " is a " + FileSplit[1].toUpperCase() + " file");
                                allFiles.add(FileSplit[0]);
                            } else if (file.getName().endsWith("3mf")) {
                                THREEMFFiles.add(FileSplit[0] + " is a " + FileSplit[1].toUpperCase() + " file");
                                allFiles.add(FileSplit[0]);
                            } else if (file.getName().endsWith("3ds")) {
                                THREEDSFiles.add(FileSplit[0] + " is a " + FileSplit[1].toUpperCase() + " file");
                                allFiles.add(FileSplit[0]);
                            } else if (file.getName().endsWith("gltf")) {
                                GLTFFiles.add(FileSplit[0] + " is a " + FileSplit[1].toUpperCase() + " file");
                                allFiles.add(FileSplit[0]);
                            } else if (file.getName().endsWith("x3d")) {
                                X3DFiles.add(FileSplit[0] + " is a " + FileSplit[1].toUpperCase() + " file");
                                allFiles.add(FileSplit[0]);
                            } else if (file.getName().endsWith("xvl")) {
                                XVLFiles.add(FileSplit[0] + " is a " + FileSplit[1].toUpperCase() + " file");
                                allFiles.add(FileSplit[0]);
                            } else if (file.getName().endsWith("jmesh")) {
                                JMESHFiles.add(FileSplit[0] + " is a " + FileSplit[1].toUpperCase() + " file");
                                allFiles.add(FileSplit[0]);
                            } else if (file.getName().endsWith("fbx")) {
                                FBXFiles.add(FileSplit[0] + " is a " + FileSplit[1].toUpperCase() + " file");
                                allFiles.add(FileSplit[0]);
                            } else if (file.getName().endsWith("dae")) {
                                DAEFiles.add(FileSplit[0] + " is a " + FileSplit[1].toUpperCase() + " file");
                                allFiles.add(FileSplit[0]);
                            } else if (file.getName().endsWith("ply")) {
                                PLYFiles.add(FileSplit[0] + " is a " + FileSplit[1].toUpperCase() + " file");
                                allFiles.add(FileSplit[0]);
                            } else if (file.getName().endsWith("off")) {
                                OFFFiles.add(FileSplit[0] + " is a " + FileSplit[1].toUpperCase() + " file");
                                allFiles.add(FileSplit[0]);
                            } else if (file.getName().endsWith("step")) {
                                STEPFiles.add(FileSplit[0] + " is a " + FileSplit[1].toUpperCase() + " file");
                                allFiles.add(FileSplit[0]);
                            } else if (file.getName().endsWith("igs")) {
                                IGSFiles.add(FileSplit[0] + " is a " + FileSplit[1].toUpperCase() + " file");
                                allFiles.add(FileSplit[0]);
                            } else if (file.getName().endsWith("wrl")) {
                                WRLFiles.add(FileSplit[0] + " is a " + FileSplit[1].toUpperCase() + " file");
                                allFiles.add(FileSplit[0]);
                            } else if (file.getName().endsWith("vrml")) {
                                VRMLFiles.add(FileSplit[0] + " is a " + FileSplit[1].toUpperCase() + " file");
                                allFiles.add(FileSplit[0]);
                            } else if (file.getName().endsWith("dxf")) {
                                DXFFiles.add(FileSplit[0] + " is a " + FileSplit[1].toUpperCase() + " file");
                                allFiles.add(FileSplit[0]);
                            } else if (file.getName().endsWith("blend")) {
                                BLENDFiles.add(FileSplit[0] + " is a " + FileSplit[1].toUpperCase() + " file");
                                allFiles.add(FileSplit[0]);
                            } else if (file.getName().endsWith("ma")) {
                                MAFiles.add(FileSplit[0] + " is a " + FileSplit[1].toUpperCase() + " file");
                                allFiles.add(FileSplit[0]);
                            } else if (file.getName().endsWith("mb")) {
                                MBFiles.add(FileSplit[0] + " is a " + FileSplit[1].toUpperCase() + " file");
                                allFiles.add(FileSplit[0]);
                            } else {
                                non3DFiles.add(FileSplit[0] + " is a " + FileSplit[1].toUpperCase() + " file");
                            }
                            // rep.open(FileSplit[0], FileSplit[1], 10, file.getPath());
                            xml.create(FileSplit[0], FileSplit[1]);
                        }
                    }
                }

                // ---------------------------------------------------------------------------------------------------------------------------------------------

                /**
                 * Output of the STLFiles list
                 */
                if (!STLFiles.isEmpty()) {
                    System.out.println("\n------------------STL FILES------------------");

                    for (String fileName : STLFiles) {
                        System.out.println(fileName);
                    }

                    System.out.println("---------------------------------------------");

                } else {
                    System.out.println("\nThere are no STL files in the Folder " + folderPath + "\n");
                }

                /**
                 * Output of the OBJFiles list
                 */
                if (!OBJFiles.isEmpty()) {
                    System.out.println("\n----------------OBJ FILES----------------");

                    for (String fileName : OBJFiles) {
                        System.out.println(fileName);
                    }

                    System.out.println("---------------------------------------------");
                } else {
                    System.out.println("\nThere are no OBJ files in the Folder " + folderPath + "\n");
                }

                /**
                 * Output of the STLFiles list
                 */
                if (!THREEMFFiles.isEmpty()) {
                    System.out.println("\n------------------3MF FILES------------------");

                    for (String fileName : THREEMFFiles) {
                        System.out.println(fileName);
                    }

                    System.out.println("---------------------------------------------");

                } else {
                    System.out.println("\nThere are no 3MF files in the Folder " + folderPath + "\n");
                }

                /**
                 * Output of the STLFiles list
                 */
                if (!THREEDSFiles.isEmpty()) {
                    System.out.println("\n------------------3DS FILES------------------");

                    for (String fileName : THREEDSFiles) {
                        System.out.println(fileName);
                    }

                    System.out.println("---------------------------------------------");

                } else {
                    System.out.println("\nThere are no 3DS files in the Folder " + folderPath + "\n");
                }

                /**
                 * Output of the STLFiles list
                 */
                if (!GLTFFiles.isEmpty()) {
                    System.out.println("\n------------------GLTF FILES------------------");

                    for (String fileName : GLTFFiles) {
                        System.out.println(fileName);
                    }

                    System.out.println("---------------------------------------------");

                } else {
                    System.out.println("\nThere are no GLTF files in the Folder " + folderPath + "\n");
                }

                /**
                 * Output of the STLFiles list
                 */
                if (!X3DFiles.isEmpty()) {
                    System.out.println("\n------------------X3D FILES------------------");

                    for (String fileName : X3DFiles) {
                        System.out.println(fileName);
                    }

                    System.out.println("---------------------------------------------");

                } else {
                    System.out.println("\nThere are no X3D files in the Folder " + folderPath + "\n");
                }

                /**
                 * Output of the STLFiles list
                 */
                if (!XVLFiles.isEmpty()) {
                    System.out.println("\n------------------XVL FILES------------------");

                    for (String fileName : XVLFiles) {
                        System.out.println(fileName);
                    }

                    System.out.println("---------------------------------------------");

                } else {
                    System.out.println("\nThere are no XVL files in the Folder " + folderPath + "\n");
                }

                /**
                 * Output of the STLFiles list
                 */
                if (!JMESHFiles.isEmpty()) {
                    System.out.println("\n------------------JMESH FILES------------------");

                    for (String fileName : JMESHFiles) {
                        System.out.println(fileName);
                    }

                    System.out.println("---------------------------------------------");

                } else {
                    System.out.println("\nThere are no JMESH files in the Folder " + folderPath + "\n");
                }

                /**
                 * Output of the STLFiles list
                 */
                if (!FBXFiles.isEmpty()) {
                    System.out.println("\n------------------FBX FILES------------------");

                    for (String fileName : FBXFiles) {
                        System.out.println(fileName);
                    }

                    System.out.println("---------------------------------------------");

                } else {
                    System.out.println("\nThere are no FBX files in the Folder " + folderPath + "\n");
                }

                /**
                 * Output of the STLFiles list
                 */
                if (!DAEFiles.isEmpty()) {
                    System.out.println("\n------------------DAE FILES------------------");

                    for (String fileName : DAEFiles) {
                        System.out.println(fileName);
                    }

                    System.out.println("---------------------------------------------");

                } else {
                    System.out.println("\nThere are no DAE files in the Folder " + folderPath + "\n");
                }

                /**
                 * Output of the STLFiles list
                 */
                if (!PLYFiles.isEmpty()) {
                    System.out.println("\n------------------PLY FILES------------------");

                    for (String fileName : PLYFiles) {
                        System.out.println(fileName);
                    }

                    System.out.println("---------------------------------------------");

                } else {
                    System.out.println("\nThere are no PLY files in the Folder " + folderPath + "\n");
                }

                /**
                 * Output of the STLFiles list
                 */
                if (!OFFFiles.isEmpty()) {
                    System.out.println("\n------------------OFF FILES------------------");

                    for (String fileName : OFFFiles) {
                        System.out.println(fileName);
                    }

                    System.out.println("---------------------------------------------");

                } else {
                    System.out.println("\nThere are no OFF files in the Folder " + folderPath + "\n");
                }

                /**
                 * Output of the STLFiles list
                 */
                if (!STEPFiles.isEmpty()) {
                    System.out.println("\n------------------STEP FILES------------------");

                    for (String fileName : STEPFiles) {
                        System.out.println(fileName);
                    }

                    System.out.println("---------------------------------------------");

                } else {
                    System.out.println("\nThere are no STEP files in the Folder " + folderPath + "\n");
                }

                /**
                 * Output of the STLFiles list
                 */
                if (!IGSFiles.isEmpty()) {
                    System.out.println("\n------------------IGS FILES------------------");

                    for (String fileName : IGSFiles) {
                        System.out.println(fileName);
                    }

                    System.out.println("---------------------------------------------");

                } else {
                    System.out.println("\nThere are no IGS files in the Folder " + folderPath + "\n");
                }

                /**
                 * Output of the STLFiles list
                 */
                if (!WRLFiles.isEmpty()) {
                    System.out.println("\n------------------WRL FILES------------------");

                    for (String fileName : WRLFiles) {
                        System.out.println(fileName);
                    }

                    System.out.println("---------------------------------------------");

                } else {
                    System.out.println("\nThere are no WRL files in the Folder " + folderPath + "\n");
                }

                /**
                 * Output of the STLFiles list
                 */
                if (!VRMLFiles.isEmpty()) {
                    System.out.println("\n------------------VRML FILES------------------");

                    for (String fileName : VRMLFiles) {
                        System.out.println(fileName);
                    }

                    System.out.println("---------------------------------------------");

                } else {
                    System.out.println("\nThere are no VRML files in the Folder " + folderPath + "\n");
                }

                /**
                 * Output of the STLFiles list
                 */
                if (!MAFiles.isEmpty()) {
                    System.out.println("\n------------------MA FILES------------------");

                    for (String fileName : MAFiles) {
                        System.out.println(fileName);
                    }

                    System.out.println("---------------------------------------------");

                } else {
                    System.out.println("\nThere are no MA files in the Folder " + folderPath + "\n");
                }

                /**
                 * Output of the STLFiles list
                 */
                if (!MBFiles.isEmpty()) {
                    System.out.println("\n------------------MB FILES------------------");

                    for (String fileName : MBFiles) {
                        System.out.println(fileName);
                    }

                    System.out.println("---------------------------------------------");

                } else {
                    System.out.println("\nThere are no MB files in the Folder " + folderPath + "\n");
                }
            } else {
                System.out.println("\nThere are no 3D files in the Folder " + folderPath + "\n");
            }
        } else {
            System.out.println("Incorrect Path!");
        }
    }
}